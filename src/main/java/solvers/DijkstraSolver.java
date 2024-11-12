
package solvers;

import java.util.*;
import model.Cell;
import model.Grid;
import gui.MainFrame;
/**
 *This class is used to implement the Dijkstra algorithm for finding the path.
 * @author Marian Luca/ phnatomCat1
 */
public class DijkstraSolver extends GeneralSolver{
    
    private PriorityQueue<Cell> queue;
    private Set<Cell> settledCells;
    private int vertexNumber=0;
    
    public DijkstraSolver(Cell start, Cell end, Grid grid, MainFrame frame) {
        super(start, end, grid, frame);
        this.queue = new PriorityQueue<Cell>( new Cell());
        this.settledCells = new HashSet<Cell>();
        
    }
    
    /**
     *  This method checks the up, down, left, right neighbours of the given cell
     * @param c the cell whose neighbours we need to check
     */
    private void investigateNeighbours(Cell c) {
        final int row = c.getRow();
        final int col = c.getCol();
        final int distance = c.getDistance();
        int counter=0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j<= col+1; j++) {
                // we ensure that only the up, down, left, right neighbours are checked
                counter+=1;
                if (counter%2 !=0) {
                    continue;
                }
                Cell cell = grid.getCell(i, j);
                if (cell != null && !settledCells.contains(cell) && !cell.isWall()) {
                    int newDistance = distance +1;
                    if (queue.contains(cell)) {
                        if (newDistance < cell.getDistance()) {
                            cell.setParent(c);
                            cell.setDistance(newDistance);
                            // PriorityQueue does not automatically update itself when an already queued element
                            // changes its comparison value
                            queue.remove(cell);
                            queue.add(cell);
                        }    
                    } else {
                        cell.setParent(c);
                        cell.setDistance(newDistance);
                        queue.add(cell);
                    }
                }
            }
        }
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        // We setup each cell with a maximum weight and count the number of non-wall cells
        // which are the cells we will be working with as part of the graph
        for (int i=0; i<grid.getRows(); i++) {
            for (int j=0; j<grid.getCols(); j++) {
               Cell cell = grid.getCell(i, j);
               if (!cell.isWall()) {
                   cell.setDistance(Integer.MAX_VALUE);
                   vertexNumber+=1;
               }
               if(this.isCancelled()) {
                   throw new InterruptedException("Cancelled");
               }
            }
        }
        start.setDistance(0);
        queue.add(start);

        // we iterate until the queue is empty, meaning we explored as many cells as we could
        // if no path was found during this exploration of as many cells as possible, i.e. the queue is empty
        // then there exists no such path
        while (!queue.isEmpty()) {
            if(this.isCancelled()) {
               throw new InterruptedException("Cancelled");
           }
            
            // Remove the cell with smallest distance from source
            Cell cell = queue.remove();
            // if end cell is found stop execution and return true
            if(cell.isEnd()) {
                return true;
            }
            // If already investigated, skip this iteration
            if (settledCells.contains(cell)) {
                continue;
            }
            // Add to the set of investigated cells
            settledCells.add(cell);
            
            // Change status to VISITED for repainting
            // we only repaint NORMAL cells
            if (cell.isNormal()) {
                cell.setStatus(10);
            }
            publish(cell);
            // Investigate neighbours of current cell 
            investigateNeighbours(cell);
            try {
                Thread.sleep(FRAME.getDelay());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return false;
    }
            
    
}
