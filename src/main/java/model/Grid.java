/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Set;

/**
 * This class represents the grid/ graph of cells
 * @author Marian Luca
 */
public class Grid {
    // Values chosen based on the fact that a cell would be 10x10 pixels 
    // on a 850x530 pixels panel
    private static final int ROWS = 85;
    private static final int COLS = 53;
    private static final int NOCELLS = ROWS*COLS;
    
    // 2D array representing the graph/ grid
    private Cell[][] grid;
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
        return grid[row][col];
    }
    
    public void resetWalls(Set<Cell> walls) {
        for (Cell cell: walls) {
            cell.setStatus(Cell.Status.Normal);
        }
    }
    
    public void resetPath(Set<Cell> path) {
        for (Cell cell: path) {
            cell.setWeight(-1);
        }
    }
    
    public void resetEverything(Set<Cell> path, Set<Cell> walls) {
        resetWalls(walls);
        resetPath(path);
    }
    
}
