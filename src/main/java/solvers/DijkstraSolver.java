
package solvers;

import model.Cell;
import model.Grid;
/**
 *This class is used to implement the Dijkstra algorithm for finding the path.
 * @author Marian Luca/ phnatomCat1
 */
public class DijkstraSolver extends GeneralSolver{
    public DijkstraSolver(Cell start, Cell end, Grid grid) {
        super(start, end, grid);
    }
    @Override
    public boolean solve() {
        return true;
    }
    
}
