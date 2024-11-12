
package solvers;

import java.util.*;
import model.Cell;
import model.Grid;
import gui.MainFrame;
/**
 * This class implements the DFS algorithm for finding the shortest path
 * @author Marian Luca/ phantomCat1
 */
public class DFSSolver extends GeneralSolver {
    private Set<Cell> settled;
    public DFSSolver(Cell start, Cell end, Grid grid, MainFrame frame) {
        super(start, end, grid, frame);
        settled = new HashSet<Cell>();
        
    }

    @Override
    protected Boolean doInBackground() throws Exception {
        
        settled.add(start);
        try {
            result = DFSrecurse(start);
        } catch (Exception e){
            throw e;
        }
        return result;
    }
    
    private boolean DFSrecurse(Cell c) throws Exception {
        Set<Cell> neighbours = investigateNeighbours(c);
       
        // try to recursively go through each path/ neighbour of the cell;
        try{
            for (Cell cell: neighbours) {
                // If STOP is pressed throw an exception, which will be passed up the recursion
                // until it can be properly handled
                if (this.isCancelled()) {
                    throw new InterruptedException("Cancelled");
                }
                // if the cell is the end cell, stop execution
                if(cell.isEnd()){
                    return true;
                }
                // if cell is settled/ investigated already, skip this iteration
                if (settled.contains(cell)) {
                    continue;
                }
                // keep track of the fact we visited this cell
                settled.add(cell);
                // change cell status to settled to allow proper repaint
                if(cell.isNormal()) {
                    cell.setStatus(10);
                    // publish this cell so that it can be repainted
                    publish(cell);
                }
                
                Thread.sleep(FRAME.getDelay());
                // recursively investigate the depth of this neighbour cell
                result = DFSrecurse(cell);

            }
        } catch(Exception e) {
            throw e;
        }
        // if no depth of the neighbours has found the end cell,
        // it means there is no path
        return result;
    }
    
    private Set investigateNeighbours(Cell c) {
        Set<Cell> neighbours = new HashSet<Cell>();
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
                if (cell != null && !settled.contains(cell) && !cell.isWall()) {
                    neighbours.add(cell);
                    cell.setParent(c);
                }
            }
        }
        return neighbours;
    }
}
