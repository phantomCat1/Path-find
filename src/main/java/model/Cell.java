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
    enum Status {
        Normal,
        Start,
        End,
        Wall
    }
    public Status status;
    
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
        this.status = Status.Normal;
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
    
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status s) {
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
