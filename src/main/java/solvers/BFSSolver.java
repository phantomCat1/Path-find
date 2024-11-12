
package solvers;

import java.util.*;
import model.Cell;
import model.Grid;
import gui.MainFrame;
/**
 * This class implements the BFS path finding algorithm for computing the shortest path
 * @author Marian Luca/ PhantomCat1
 */
public class BFSSolver extends GeneralSolver {
    private Queue<Cell> queue;
    private Set<Cell> settled;
    
    public BFSSolver(Cell start, Cell end, Grid grid, MainFrame frame) {
        super(start, end, grid, frame);
        queue = new LinkedList<Cell>();
        settled = new HashSet<Cell>();
        
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        queue.add(start);
        
        while(queue.size() != 0) {
            // Throw exception to stop execution if STOP button is pressed
            if(this.isCancelled()) {
                throw new InterruptedException("Cancelled");
            }
            // get the cell at the head of the queue
            Cell cell = queue.poll();
            // If this cell is the end cell, we return true and stop execution
            if(cell.isEnd()) {
                return true;
            }
            // add the cell to the set of already investigated cells
            settled.add(cell);
            if(cell.isNormal()) {
                cell.setStatus(10);
                // publish cell so that the EDT can repaint the panel
                publish(cell);
            }
            
            // check and add neighbours to queue
            investigateNeighbours(cell);
            Thread.sleep(FRAME.getDelay());
        }
        
        //If the while loop is exited, then a path was not found
        return false;
    }
    
    private void investigateNeighbours(Cell c) {
        final int row = c.getRow();
        final int col = c.getCol();
        int counter=0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j<= col+1; j++) {
                counter+=1;
                if (counter%2 !=0) {
                    continue;
                }
                Cell cell = grid.getCell(i, j);
                if (cell != null && !settled.contains(cell) && !queue.contains(cell) && !cell.isWall()) {
                    queue.add(cell);
                    cell.setParent(c);
                }
            }
        }
    }
    
}
