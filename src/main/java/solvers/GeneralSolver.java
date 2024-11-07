
package solvers;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import model.Cell;
import model.Grid;
/**
 * This is an abstract class for the different algorithms classes implemented
 * @author Marian Luca/ phantomCat1
 */
public abstract class GeneralSolver {
    private final Cell start;
    private final Cell end;
    private final Grid grid;
    
    public GeneralSolver(Cell start, Cell end, Grid grid) {
        this.start = start;
        this.end = end;
        this.grid = grid;
    }
    public abstract boolean solve();
    public boolean runSolver() {
        SwingWorker<Boolean, Void> solver = new SwingWorker<Boolean, Void>(){
            @Override
            protected Boolean doInBackground() throws Exception {
                return solve();
            }
        
        };
        try {
            return solver.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;   
    }
}
