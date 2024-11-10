
package model;

import java.util.Set;

/**
 * This class represents the grid/ graph of cells
 * @author Marian Luca
 */
public class Grid {
    // Values chosen based on the fact that a cell would be 10x10 pixels 
    // on a 850x530 pixels panel
    private static final int ROWS = 53;
    private static final int COLS = 85;
    private static final int NOCELLS = ROWS*COLS;
    
    // 2D array representing the graph/ grid
    private final Cell[][] grid;
    //private int[][] graph;
    
    
    public Grid() {
        //graph = new int[NOCELLS][NOCELLS];
        grid = new Cell[ROWS][COLS];
        initialiseGrid();
    }
    
    private void initialiseGrid(){
        for (int i =0; i< ROWS; i++) {
            for (int j=0; j< COLS; j++) {
                grid[i][j] = new Cell(i, j);
                
            }
        }
    }
    
    public int getRows() {
        return this.ROWS;
    }
    
    public int getCols() {
        return this.COLS;
    }
    
    public Cell getCell(int row, int col) {
        if (row < 0 || row >= this.ROWS) {
            return null;
        }
        if (col <0 || col >= this.COLS) {
            return null;
        }
        return grid[row][col];
    }
    
    public void resetWalls() {
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                final Cell cell = this.getCell(i, j);
                if (cell.isWall()) {
                    cell.setStatus(0);
                }
            }
        }
    }
    
    public void resetPath() {
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                final Cell cell = this.getCell(i, j);
                if (cell.isOnPath() || cell.isSetlled()) {
                    cell.setStatus(0);
                }
            }
        }
    }
    
    public void resetEverything() {
        for (int i=0; i<ROWS; i++) {
            for (int j=0; j<COLS; j++) {
                final Cell cell = this.getCell(i, j);
                if (!cell.isNormal()) {
                    cell.setStatus(0);
                }
            }
        }
    }
    
}
