
package solvers;

import java.util.*;
import model.Cell;
import model.Grid;
import gui.MainFrame;
/**
 * This class contains the implementation of the A-star algorithm
 * @author Marian Luca/ phantomCat1
 */
public class AStarSolver extends GeneralSolver {
    private Set<Cell> settled;
    private PriorityQueue<Cell> queue;
    // this map is used to map each cell to its corresponding G cost
    // The weight field of each cell will now be used as the F cost
    private Map<Cell, Integer> map;
    
    public AStarSolver(Cell start, Cell end, Grid grid, MainFrame frame) {
        super(start, end, grid, frame);
        // the settled set acts as the closed set
        settled = new HashSet<Cell>();
        // The priority queue acts as the open set
        queue = new PriorityQueue<Cell>(new Cell());
        map = new HashMap<Cell, Integer>();
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        map.put(start, 0);
        start.setDistance(0);
        queue.add(start);
        // we iterate until the queue is empty, meaning we explored as many cells as we could
        // if no path was found during this exploration of as many cells as possible, i.e. the queue is empty
        // then there exists no such path
        while(!queue.isEmpty()) {
            if (this.isCancelled()) {
                throw new InterruptedException("Cancelled");
            }
            
            // Remove the cell with smallest F cost from the queue
            Cell cell = queue.poll();
            // if this cell is the end cell, we stop the execution and trace the path
            if (cell.isEnd()) {
                return true;
            }
            
            // if this cell is already settled/ investigated, we continue to the next iteration
            if (settled.contains(cell)) {
                continue;
            }
            
            // add the cell to the set settled
            settled.add(cell);
            // update the cells status 
            if (cell.isNormal()) {
                cell.setStatus(10);
            }
            //publish the cell so that the EDT can update the GUI with the newly settled cell
            publish(cell);
            // investigate the neighbours of the given cell
            investigateNeighbours(cell);
            Thread.sleep(FRAME.getDelay());
        }
        
        return false;
    }
    
    /**
     *  This method checks the up, down, left, right neighbours of the given cell
     * @param c the cell whose neighbours we need to check
     */
    private void investigateNeighbours(Cell c) {
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
                if (cell != null && !settled.contains(cell) && !cell.isWall()) {
                    // compute the new G cost of the cell 
                    int GCost = distance +1;
                    // if the cell is in the open set, i.e. already in the priority queue
                    if (queue.contains(cell)) {
                        // if it was already in the open set, then its G cost would have already been added to the HashMap
                        if (GCost < map.get(cell)) {
                            map.put(cell, GCost);
                            int HCost = heuristic(c);
                            cell.setParent(c);
                            cell.setDistance(GCost + HCost);
                            // PriorityQueue does not automatically update itself when an already queued element
                            // changes its comparison value
                            queue.remove(cell);
                            queue.add(cell);   
                        }  
                    } else {
                        // if not in the open set, then its G cost was not added to the HashMap 
                        map.put(cell, GCost);
                        int HCost = heuristic(c);
                        cell.setParent(c);
                        cell.setDistance(GCost + HCost);
                        queue.add(cell);
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
    private int heuristic(Cell c) {
        return Math.abs(c.getRow() - end.getRow()) + Math.abs(c.getCol()-end.getCol());
    }
}
