
package model;

import java.util.Comparator;
import java.util.Set;
/**
 * This class represents the structure of a cell in the grid
 * @author Marian Luca / phantomCat1
 */
public class Cell implements Comparator<Cell>{
    
    
    
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
    
    /**
     * Checks if the cell is a wall cell
     * @return true if cell has status WALL, false otherwise
     */
    public boolean isWall() {
        if (this.status == WALL) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks if the cell is the starting cell
     * @return true if cell has status START, false otherwise
     */
    public boolean isStart() {
        if (this.status == START) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks if the cell is normal
     * @return true if cell has status NORMAL, false otherwise
     */
    public boolean isNormal() {
        if (this.status == NORMAL) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks if the cell is the end cell
     * @return true is the cell has status END, false otherwise
     */
    public boolean isEnd() {
        if (this.status == END) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks if the cell has been investigated
     * @return true if cell has been investigated, false otherwise
     */
    public boolean isSetlled() {
        if (this.status == SETTLED) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * Checks if the cell is on the final traced path
     * @return true if cell is on the final trace path, false otherwise
     */
    public boolean isOnPath() {
        if (this.status == ON_PATH) {
            return true;
        } else {
            return false;
        }
    }
  
    /**
     * This method is used to change the status of the cell
     * @param s integer representing the new status
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
     * @return parent of the cell
     */
    public Cell getParent() {
        return this.parent;
    }
    
    /*
    This method is used to get the distance of the current cell
    */
    public int getDistance() {
        return this.distance;
    }
    
    /*
    This method is used to set/ change the distance of the current cell
    */
    public void setDistance(int w) {
        this.distance = w;
    }

    /*
    This method is the subclass implementation of Cell 
    It compares two cells based on the distance attribute
    Used by the PriorityQueue in Dijkstra and A-Star for determining the order in which cells are explored
    */
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
