
package solvers;

import java.util.*;
import model.Cell;
import model.Grid;
import gui.MainFrame;
/**
 * This class implements a Front-to-Back Bidirectional search algorithm for finding the path between the start and end cells
 * It uses the A-star algorithm for both directions of the search
 * As in the A-Star algorithm implementation, the heuristic is calculated based on the Manhattan distance between the current cell
 * and the final/ end cell of the opposing search.
 * @author Marian Luca / phantomCat1
 */
public class BidirectionalSolver extends GeneralSolver {
    private HashMap<Cell, Integer> map;
    // this set represents the closed set of the search starting from the 'start' cell
    private Set<Cell> closedStart;
    // this set represents the closed set of the search starting from the 'end' cell
    private Set<Cell> closedEnd;
    
    // this set represents the open set of the search starting from the 'start' cell
    private PriorityQueue<Cell> openStart;
    // this set represents the open set of the search starting from the 'end' cell
    private PriorityQueue<Cell> openEnd;
    
    // these HashMaps maps each cell to its respective parent in both searches
    private HashMap<Cell, Cell> parentStart;
    private HashMap<Cell, Cell> parentEnd;
    
    public BidirectionalSolver(Cell start, Cell end, Grid grid, MainFrame frame) {
        super(start, end, grid, frame);
        closedStart = new HashSet<Cell>();
        closedEnd = new HashSet<Cell>();
        openStart = new PriorityQueue<Cell>(new Cell());
        openEnd = new PriorityQueue<Cell>(new Cell());
        map = new HashMap<Cell, Integer>();
        parentStart = new HashMap<Cell, Cell>();
        parentEnd = new HashMap<Cell, Cell>();
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        map.put(start, 0);
        map.put(end, 0);
        openStart.add(start);
        openEnd.add(end);
        //we run the loop as long until the two open sets are 
        while (!(openStart.isEmpty() && openEnd.isEmpty())) {
            if (this.isCancelled()) {
                throw new InterruptedException("Cancelled");
            }
            Cell cellStart = openStart.poll();
            Cell cellEnd = openEnd.poll();
            // if the two graph searches meet, then we stop execution, set the parent of each cell on the trace path
            // and return true
            if (closedEnd.contains(cellStart)) {
                // We build the final trace path using the 'parent' field of the cells
                Cell cell = cellStart;
                while (!cellStart.isStart()) {
                    cellStart.setParent(parentStart.get(cellStart));
                    cellStart = parentStart.get(cellStart);
                }
                cellStart = cell;
                cell = parentStart.get(cellStart);
                while (!cell.isEnd()) {
                    
                    cellStart.setParent(cell);
                    cell = cellStart;
                    cellStart = parentEnd.get(cellStart);
                }
                return true;
            } else if (closedStart.contains(cellEnd)) {
                Cell cell = cellEnd;
                while (!cellEnd.isStart()) {
                    cellEnd.setParent(parentStart.get(cellEnd));
                    cellEnd = parentStart.get(cellEnd);
                }
                cellEnd = cell;
                cell = parentStart.get(cellEnd);
                while (!cell.isEnd()) {
                    cellEnd.setParent(cell);
                    cell = cellEnd;
                    cellEnd = parentEnd.get(cellEnd);
                }
                return true;
            }
            // if both cells have already been explored, skip iteration
            if (closedStart.contains(cellStart) && closedEnd.contains(cellEnd)) {
                continue;
            } else if (!closedStart.contains(cellStart) && closedEnd.contains(cellEnd)) {
                // if only one of the cells has been investigated, we still need to explore the other one
                closedStart.add(cellStart);
                //update cell status 
                if (cellStart.isNormal()) {
                    cellStart.setStatus(10);
                }
                publish(cellStart);
                investigateNeighbours(cellStart, end, closedStart, openStart);
                Thread.sleep(FRAME.getDelay());
            } else if (closedStart.contains(cellStart) && !closedEnd.contains(cellEnd)) {
                closedEnd.add(cellEnd);
                if (cellEnd.isNormal()) {
                    cellEnd.setStatus(10);
                    publish(cellEnd);
                }
                
                investigateNeighbours(cellEnd, start, closedEnd, openEnd);
                Thread.sleep(FRAME.getDelay());
            } else {
                closedEnd.add(cellEnd);
                closedStart.add(cellStart);
                //update cell status 
                if (cellStart.isNormal()) {
                    cellStart.setStatus(10);
                    //publish the cells so that the EDT can update the GUI
                    publish(cellStart);
                }
                if (cellEnd.isNormal()) {
                    cellEnd.setStatus(10);
                    //publish the cells so that the EDT can update the GUI
                    publish(cellEnd);
                }
              
                //investigate neighbours of both cells
                investigateNeighbours(cellStart, end, closedStart, openStart);
                investigateNeighbours(cellEnd, start, closedEnd, openEnd);
                Thread.sleep(FRAME.getDelay());
            }
        }
        return false;
    }
    
    /**
     *  This method checks the up, down, left, right neighbours of the given cell
     * @param c the cell whose neighbours we need to check
     */
    private void investigateNeighbours(Cell c, Cell target, Set<Cell> closed, PriorityQueue<Cell> open) {
        final int row = c.getRow();
        final int col = c.getCol();
        final int distance = map.get(c);
        int counter=0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j<= col+1; j++) {
                // we ensure that only the up, down, left, right neighbours are checked
                counter+=1;
                if (counter%2 !=0) {
                    continue;
                }
                Cell cell = grid.getCell(i, j);
                if (cell != null && !closed.contains(cell) && !cell.isWall()) {
                    // compute the new G cost of the cell 
                    int GCost = distance +1;
                    // if the cell is in the open set, i.e. already in the priority queue
                    if (open.contains(cell)) {
                        // if it was already in the open set, then its G cost would have already been added to the HashMap
                        if (GCost < map.get(cell)) {
                            map.put(cell, GCost);
                            int HCost = heuristic(c, target);
                            if (closed == closedStart) {
                                parentStart.put(cell, c);
                            } else if (closed == closedEnd) {
                                parentEnd.put(cell, c);
                            }
                            cell.setDistance(GCost + HCost);
                            // PriorityQueue does not automatically update itself when an already queued element
                            // changes its comparison value
                            open.remove(cell);
                            open.add(cell);   
                        }  
                    } else {
                        // if not in the open set, then its G cost was not added to the HashMap 
                        map.put(cell, GCost);
                        int HCost = heuristic(c, target);
                        if (closed == closedStart) {
                            parentStart.put(cell, c);
                        } else if (closed == closedEnd) {
                            parentEnd.put(cell, c);
                        }
                        cell.setDistance(GCost + HCost);
                        open.add(cell);
                    }
                    
                    
                    
                }
            }
        }
    }
    
    /**
     *  This method computes the H cost or heuristic of a given cell 
     * using the Manhattan distance between the given cell and the end cell
     * @param c representing the cell whose H cost we need to compute
     * @return the H cost
     */
    private int heuristic(Cell c1, Cell c2) {
        return Math.abs(c1.getRow() - c2.getRow()) + Math.abs(c1.getCol()-c2.getCol());
    }
    
}
