
package solvers;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import model.Cell;
import model.Grid;
import gui.MainFrame;
import java.util.concurrent.CancellationException;
import javax.swing.JOptionPane;
/**
 * This is an abstract class for the different algorithms classes implemented
 * @author Marian Luca/ phantomCat1
 */
public abstract class GeneralSolver extends SwingWorker<Boolean, Cell>{
    protected final Cell start;
    protected final Cell end;
    final Grid grid;
    protected boolean result=false;
    final protected MainFrame FRAME;
    
    public GeneralSolver(Cell start, Cell end, Grid grid, MainFrame frame) {
        this.start = start;
        this.end = end;
        this.grid = grid;
        this.FRAME = frame;
    }
    
    @Override
    protected void done() {
        try {
            result = get();
            if (result) {
                Cell cell = end.getParent();
                while (cell != start) {
                    cell.setStatus(15); // set status to ON_PATH 
                    cell = cell.getParent();
                    FRAME.repaint();
                    
                }
            } else {
                JOptionPane.showMessageDialog(FRAME, new String[] {"There exists no path between the two cells"},"", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (InterruptedException e) {
            return;
        } catch (ExecutionException e) {
            return;
        } catch (CancellationException e) {
            return;
        }
    }
    
    @Override
    protected void process(List<Cell> chunks) {
        for (Cell c: chunks) {
            FRAME.repaint();
        }
    }
    
    
}
