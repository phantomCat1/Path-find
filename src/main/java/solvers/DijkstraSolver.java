
package solvers;

import java.util.*;
import model.Cell;
import model.Grid;
import gui.MainFrame;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
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
    
    
    private void investigateNeighbours(Cell c) {
        final int row = c.getRow();
        final int col = c.getCol();
        final int distance = c.getWeight();
        int counter=0;
        for (int i = row-1; i <= row+1; i++) {
            for (int j = col-1; j<= col+1; j++) {
                counter+=1;
                if (counter%2 !=0) {
                    continue;
                }
                Cell cell = grid.getCell(i, j);
                if (cell != null && !settledCells.contains(cell)) {
                    int newDistance = distance +1;
                    if (newDistance < cell.getWeight()) {
                        cell.setParent(c);
                        cell.setWeight(distance +1);
                        queue.add(cell);
                    }
                }
            }
        }
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        for (int i=0; i<grid.getRows(); i++) {
            for (int j=0; j<grid.getCols(); j++) {
               Cell cell = grid.getCell(i, j);
               if (!cell.isWall()) {
                   cell.setWeight(Integer.MAX_VALUE);
                   vertexNumber+=1;
               }
               if(this.isCancelled()) {
                   throw new InterruptedException("Cancelled");
               }
            }
        }
        start.setWeight(0);
        queue.add(start);


        while (settledCells.size()!= vertexNumber) {
            if(this.isCancelled()) {
               throw new InterruptedException("Cancelled");
           }
            if (queue.isEmpty()) {
                return false;
            }
            // Remove the cell with smallest distance from source
            Cell cell = queue.remove();
            // If already investigated, skip this iteration
            if (settledCells.contains(cell)) {
                continue;
            }
            // Add to the set of investigated cells
            settledCells.add(cell);
            publish(cell);
            // Change status to VISITED for repainting
            // we only repaint NORMAL cells
            if (cell.isNormal()) {
                cell.setStatus(10);
            }

            // Investigate neighbours of current cell 
            investigateNeighbours(cell);
            try {
                Thread.sleep(FRAME.getDelay());
            } catch (Exception e) {
                System.err.println(e);
            }
        }
        return true;
    }
            
    
}
