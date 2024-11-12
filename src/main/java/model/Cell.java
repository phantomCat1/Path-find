/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Comparator;
import java.util.Set;
/**
 * This class represents the structure of a cell in the grid
 * @author Marian Luca
 */
public class Cell implements Comparator<Cell>{
    
    private int size = 30; // ???????????????????????????????
    
    // A cell can have any one of these statuses
    private final int START = 1;
    private final int END = 2;
    private final int NORMAL = 0;
    private final int WALL = -1;
    private final int SETTLED = 10;
    private final int ON_PATH = 15;
    private int status;
    private Cell parent;
    
    // distance represents the distance from the source node/ cell to the current cell in the Dijkstra algorithm
    // or the F cost in the A-Star algorithm
    public int distance = -1;
    
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
        this.parent = null;
    }
    
    /*
    Empty constructor
    */
    public Cell() {}
    
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
    
    public boolean isSetlled() {
        if (this.status == SETTLED) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isOnPath() {
        if (this.status == ON_PATH) {
            return true;
        } else {
            return false;
        }
    }
  
    /**
     * This method is used to change the status of the cell
     * @param s 
     */
    public void setStatus(int s) {
        this.status = s;
    }
    
    /**
     * This method changes the parent of the cell
     * @param p new parent
     */
    public void setParent(Cell p) {
        this.parent = p;
    }
    
    /**
     * This method returns the parent of the cell
     * @return parent
     */
    public Cell getParent() {
        return this.parent;
    }
    
    /*
    This method is used to get the weight of the current cell
    */
    public int getDistance() {
        return this.distance;
    }
    
    /*
    This method is used to set/ change the weight of the current cell
    */
    public void setDistance(int w) {
        this.distance = w;
    }

    @Override
    public int compare(Cell o1, Cell o2) {
        if (o1.getDistance() > o2.getDistance()) {
            return 1;
        } 
        if (o1.getDistance() < o2.getDistance()) {
            return -1;
        }
        return 0;
    }
    
}
