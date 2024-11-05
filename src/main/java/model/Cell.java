/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Set;
/**
 * This class represents the structure of a cell in the grid
 * @author Marian Luca
 */
public class Cell {
    
    private int size = 30; // ???????????????????????????????
    
    // A cell can have any one of these statuses
    private final int START = 1;
    private final int END = 2;
    private final int NORMAL = 0;
    private final int WALL = -1;
    private int status;
    
    // weight represents the distance from the source node/ cell to the current cell
    private int weight = -1;
    
    // The set of neighbours of the current cell
    Set<Cell> neighbours;
    
    // Position of the cell in the grid
    private int row;
    private int col;
    
    /*
    Constructor to initialise the cell
    */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.status = NORMAL;
    }
    
    /*
    This method is used to get the row position of the current cell
    */
    public int getRow() {
        return this.row;
    }
    
    /*
    This method is used to get the column position of the current cell
    */
    public int getCol() {
        return this.col;
    }
    
    /*
    This method is used to get the set of neighbour cells of the current cell
    */
    public Set getNeighbours() {
        return this.neighbours;
    }
    
    public void setNeighbour(Cell n) {
        this.neighbours.add(n);
    }
    
    public boolean isWall() {
        if (this.status == WALL) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isStart() {
        if (this.status == START) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isNormal() {
        if (this.status == NORMAL) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isEnd() {
        if (this.status == END) {
            return true;
        } else {
            return false;
        }
    }
    
    public void setStatus(int s) {
        this.status = s;
    }
    
    /*
    This method is used to get the weight of the current cell
    */
    public int getWeight() {
        return this.weight;
    }
    
    /*
    This method is used to set/ change the weight of the current cell
    */
    public void setWeight(int w) {
        this.weight = w;
    }
    
}
