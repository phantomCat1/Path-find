
package gui;

import javax.swing.JOptionPane;
import model.Cell;
import model.Grid;
import solvers.*;
/**
 *
 * @author Marian Luca/ phantomCat1
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        start = null;
        end = null;
        grid = new Grid();
        delay=10;
        jAlgoPanel.setVisible(false);
        jEndAlgoPanel.setVisible(false);
        gridPanel = jMainPanel;
        gridPanel.setGrid(grid);
        jMainPanel.invalidate();
        repaint();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTopPanel = new javax.swing.JPanel();
        jSolveButton = new javax.swing.JButton();
        jSliderLabel = new javax.swing.JLabel();
        jSpeedSlider = new javax.swing.JSlider();
        jHelpButton = new javax.swing.JButton();
        jStopButton = new javax.swing.JButton();
        jEraserRadioButton = new javax.swing.JRadioButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jAlgoPanel = new java.awt.Panel();
        jDijkstraButton = new javax.swing.JButton();
        jAStarButton = new javax.swing.JButton();
        jDFSButton = new javax.swing.JButton();
        jBFSButton = new javax.swing.JButton();
        jBidirectionalButton = new javax.swing.JButton();
        jMainPanel = new gui.GridPanel();
        jEndAlgoPanel = new javax.swing.JPanel();
        jResetWallsButton = new javax.swing.JButton();
        jResetEverythingButton = new javax.swing.JButton();
        jChangeNothingButton = new javax.swing.JButton();
        jResetPathButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(860, 640));
        setResizable(false);

        jTopPanel.setPreferredSize(new java.awt.Dimension(860, 70));

        jSolveButton.setText("Solve");
        jSolveButton.setFocusable(false);
        jSolveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSolveButtonMouseClicked(evt);
            }
        });

        jSliderLabel.setText("Speed:");

        jSpeedSlider.setMaximum(60);
        jSpeedSlider.setValue(30);
        jSpeedSlider.setFocusable(false);
        jSpeedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpeedSliderStateChanged(evt);
            }
        });

        jHelpButton.setText("Help");
        jHelpButton.setFocusable(false);
        jHelpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHelpButtonMouseClicked(evt);
            }
        });

        jStopButton.setText("Stop/Reset");
        jStopButton.setFocusable(false);
        jStopButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jStopButtonMouseClicked(evt);
            }
        });

        jEraserRadioButton.setText("Eraser");
        jEraserRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEraserRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jTopPanelLayout = new javax.swing.GroupLayout(jTopPanel);
        jTopPanel.setLayout(jTopPanelLayout);
        jTopPanelLayout.setHorizontalGroup(
            jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jTopPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jHelpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSolveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSliderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96)
                .addComponent(jStopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jEraserRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jTopPanelLayout.setVerticalGroup(
            jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jTopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jStopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jEraserRadioButton))
                    .addGroup(jTopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jHelpButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSolveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSliderLabel)
                        .addComponent(jSpeedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(554, 554, 554))
        );

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(860, 530));

        jAlgoPanel.setBackground(new java.awt.Color(204, 204, 204));
        jAlgoPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jAlgoPanel.setForeground(new java.awt.Color(204, 255, 255));
        jAlgoPanel.setPreferredSize(new java.awt.Dimension(350, 400));

        jDijkstraButton.setText("Dijkstra");
        jDijkstraButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDijkstraButtonMouseClicked(evt);
            }
        });

        jAStarButton.setText("A-Star");
        jAStarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jAStarButtonMouseClicked(evt);
            }
        });

        jDFSButton.setText("DFS");
        jDFSButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDFSButtonMouseClicked(evt);
            }
        });

        jBFSButton.setText("BFS");
        jBFSButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBFSButtonMouseClicked(evt);
            }
        });

        jBidirectionalButton.setText("Bidirectional");
        jBidirectionalButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBidirectionalButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jAlgoPanelLayout = new javax.swing.GroupLayout(jAlgoPanel);
        jAlgoPanel.setLayout(jAlgoPanelLayout);
        jAlgoPanelLayout.setHorizontalGroup(
            jAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAlgoPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(jAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAStarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDijkstraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDFSButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBFSButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBidirectionalButton, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jAlgoPanelLayout.setVerticalGroup(
            jAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jAlgoPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jDijkstraButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAStarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jDFSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBFSButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jBidirectionalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        jMainPanel.setPreferredSize(new java.awt.Dimension(860, 530));
        jMainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jMainPanelMouseDragged(evt);
            }
        });
        jMainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMainPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jMainPanelLayout = new javax.swing.GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jMainPanelLayout.setVerticalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jEndAlgoPanel.setPreferredSize(new java.awt.Dimension(350, 400));

        jResetWallsButton.setText("Reset Walls");
        jResetWallsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jResetWallsButtonMouseClicked(evt);
            }
        });

        jResetEverythingButton.setText("Reset Everything");
        jResetEverythingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jResetEverythingButtonMouseClicked(evt);
            }
        });

        jChangeNothingButton.setText("Change nothing");
        jChangeNothingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChangeNothingButtonMouseClicked(evt);
            }
        });

        jResetPathButton.setText("Reset Path");
        jResetPathButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jResetPathButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jEndAlgoPanelLayout = new javax.swing.GroupLayout(jEndAlgoPanel);
        jEndAlgoPanel.setLayout(jEndAlgoPanelLayout);
        jEndAlgoPanelLayout.setHorizontalGroup(
            jEndAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEndAlgoPanelLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jEndAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jResetPathButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addGroup(jEndAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jChangeNothingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jResetEverythingButton, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                        .addComponent(jResetWallsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jEndAlgoPanelLayout.setVerticalGroup(
            jEndAlgoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jEndAlgoPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jResetWallsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jResetEverythingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jChangeNothingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jResetPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jAlgoPanel, javax.swing.JLayeredPane.POPUP_LAYER);
        jLayeredPane1.setLayer(jMainPanel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jEndAlgoPanel, javax.swing.JLayeredPane.POPUP_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(250, 250, 250)
                    .addComponent(jAlgoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(192, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jEndAlgoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(jAlgoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jEndAlgoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(530, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 70, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSolveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSolveButtonMouseClicked
        if (!solving) {
            
            jAlgoPanel.setVisible(true);
            System.out.println("Hello from solve");
            this.pack();
            jAlgoPanel.requestFocusInWindow();
        }
        
    }//GEN-LAST:event_jSolveButtonMouseClicked

    private void jHelpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHelpButtonMouseClicked
        
        JOptionPane.showMessageDialog(this,
                new String[] {
                    "You are presented a rectangular grid of cells.",
                    " ",
                    "Step 1:",
                    "  Click on any cell to select the start and ending positions.",
                    " ",
                    "Step 2:",
                    "  Click or drag your mouse on any cell to create walls.",
                    " ",
                    "Step 3:",
                    "  Click the 'Eraser' radio button to enable editing and erasing",
                    " of the colored cells",
                    " ",
                    "Step 4:",
                    "  Click on the 'Start' button and select any of the given algorithms.",
                    " ",
                    "Step 5:",
                    "  You may click on the 'Stop' button to stop the execution",
                    "at any point in time.",
                    " ",
                    "Step 6:",
                    " Use the slider at the top to adjust the speed of the visualisation.",
                    " ",
                    "Step 7:",
                    " After the algorithm ends, click on the 'Stop' button and choose to ",
                    "reset the cells in any way you want."
                },
                "Help for Path Finder", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jHelpButtonMouseClicked

    private void jStopButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jStopButtonMouseClicked
        // TODO add your handling code here:
        solver.cancel(true);
        System.out.println(String.format("Swing worker was cancelled %b", solver.isCancelled()));
        solving = false;
        jEndAlgoPanel.setVisible(true);
        this.pack();
        jEndAlgoPanel.requestFocusInWindow();
    }//GEN-LAST:event_jStopButtonMouseClicked

    private void jDijkstraButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDijkstraButtonMouseClicked
        // TODO add your handling code here:
        jAlgoPanel.setVisible(false);
        solving = true; // Keep track of the fact that solving has begun.
        solver = new DijkstraSolver(start,end,grid, this);
        
        solver.execute();
        
    }//GEN-LAST:event_jDijkstraButtonMouseClicked

    private void jDFSButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDFSButtonMouseClicked
        // TODO add your handling code here:
        jAlgoPanel.setVisible(false);
        solving = true; // Keep track of the fact that solving has begun.
        solver = new DFSSolver(start,end,grid, this);
        
        solver.execute();
    }//GEN-LAST:event_jDFSButtonMouseClicked

    private void jBFSButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBFSButtonMouseClicked
        // TODO add your handling code here:
        jAlgoPanel.setVisible(false);
        solving = true; // Keep track of the fact that solving has begun.
        solver = new BFSSolver(start,end,grid, this);
        
        solver.execute();
    }//GEN-LAST:event_jBFSButtonMouseClicked

    private void jAStarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAStarButtonMouseClicked
        // TODO add your handling code here:
        jAlgoPanel.setVisible(false);
        solving = true; // Keep track of the fact that solving has begun.
        solver = new AStarSolver(start,end,grid, this);
        
        solver.execute();
    }//GEN-LAST:event_jAStarButtonMouseClicked

    private void jBidirectionalButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBidirectionalButtonMouseClicked
        // TODO add your handling code here:
        jAlgoPanel.setVisible(false);
        solving = true; // Keep track of the fact that solving has begun.
        solver = new BidirectionalSolver(start,end,grid, this);
        
        solver.execute();
    }//GEN-LAST:event_jBidirectionalButtonMouseClicked

    private void jMainPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMainPanelMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==0 || solving) {
            return;
        }
        final Cell cell = gridPanel.mouseToCell(evt);
        
        if (cell == null) {
            return;
        }
        if (!solving) {
            if (cell.isNormal() && cellTypeCounter == 0) {
                cell.setStatus(1); //i.e status START = 1 
                start = cell;
                cellTypeCounter = 1;
            }
            else if (cell.isStart() && eraser) {
                cell.setStatus(0); // i.e. status NORMAL = 0
                start = null;
                cellTypeCounter = 0;
            }
            else if (cell.isNormal() && cellTypeCounter == 1) {
                cell.setStatus(2); // i.e status END = 2;
                end = cell;
                cellTypeCounter = 2;
            }
            else if (cell.isEnd() && eraser) {
                cell.setStatus(0); // i.e. status NORMAL = 0
                end = null;
                cellTypeCounter = 1;
            }
            else if (cell.isNormal() && cellTypeCounter ==2 && !eraser) {
                cell.setStatus(-1); // i.e status WALL = -1;
                gridPanel.setWalls(cell);
                cellTypeCounter =2;
            }
            else if (cell.isWall() && cellTypeCounter ==2 && eraser) {
                cell.setStatus(0); // i.e status NORMAL = 0;
                gridPanel.removeWalls(cell);
                cellTypeCounter =2;
            }

            jMainPanel.invalidate();
            repaint();
            jMainPanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_jMainPanelMouseClicked

    private void jMainPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMainPanelMouseDragged
        // TODO add your handling code here:
        if (!solving) {
        final Cell cell = gridPanel.mouseToCell(evt);
        if (cell == null) {
            return;
        }
        
            if (cell.isNormal() && cellTypeCounter ==2 && !eraser) {
                cell.setStatus(-1); // i.e status WALL = -1;
                gridPanel.setWalls(cell);
                cellTypeCounter =2;
            }
            else if (cell.isWall() && cellTypeCounter ==2 && eraser ) {
                cell.setStatus(0); // i.e status NORMAL = 0;
                gridPanel.removeWalls(cell);
                cellTypeCounter =2;
            }
            jMainPanel.invalidate();
            repaint();
            jMainPanel.requestFocusInWindow();
        }
    }//GEN-LAST:event_jMainPanelMouseDragged

    private void jEraserRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEraserRadioButtonActionPerformed
        // TODO add your handling code here:
        if (eraser) {
            eraser = false;
        } else {
            eraser = true;
        }
    }//GEN-LAST:event_jEraserRadioButtonActionPerformed

    private void jResetWallsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jResetWallsButtonMouseClicked
        // TODO add your handling code here:
        jEndAlgoPanel.setVisible(false);
        grid.resetWalls();
        jMainPanel.invalidate();
        repaint();
        jMainPanel.requestFocusInWindow();
    }//GEN-LAST:event_jResetWallsButtonMouseClicked

    private void jResetEverythingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jResetEverythingButtonMouseClicked
        // TODO add your handling code here:
        cellTypeCounter=0;
        jEndAlgoPanel.setVisible(false);
        grid.resetEverything();
        jMainPanel.invalidate();
        repaint();
        jMainPanel.requestFocusInWindow();
    }//GEN-LAST:event_jResetEverythingButtonMouseClicked

    private void jChangeNothingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangeNothingButtonMouseClicked
        // TODO add your handling code here:
        jEndAlgoPanel.setVisible(false);
        jMainPanel.invalidate();
        repaint();
        jMainPanel.requestFocusInWindow();
    }//GEN-LAST:event_jChangeNothingButtonMouseClicked

    private void jResetPathButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jResetPathButtonMouseClicked
        // TODO add your handling code here:
        jEndAlgoPanel.setVisible(false);
        grid.resetPath();
        jMainPanel.invalidate();
        repaint();
        jMainPanel.requestFocusInWindow();
    }//GEN-LAST:event_jResetPathButtonMouseClicked

    private void jSpeedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpeedSliderStateChanged
        // TODO add your handling code here:
        
        this.delay = jSpeedSlider.getMaximum() - jSpeedSlider.getValue();
        if(this.delay <5) {
            this.delay=5;
        }
    }//GEN-LAST:event_jSpeedSliderStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jAStarButton;
    private java.awt.Panel jAlgoPanel;
    private javax.swing.JButton jBFSButton;
    private javax.swing.JButton jBidirectionalButton;
    private javax.swing.JButton jChangeNothingButton;
    private javax.swing.JButton jDFSButton;
    private javax.swing.JButton jDijkstraButton;
    private javax.swing.JPanel jEndAlgoPanel;
    private javax.swing.JRadioButton jEraserRadioButton;
    private javax.swing.JButton jHelpButton;
    private javax.swing.JLayeredPane jLayeredPane1;
    private gui.GridPanel jMainPanel;
    private javax.swing.JButton jResetEverythingButton;
    private javax.swing.JButton jResetPathButton;
    private javax.swing.JButton jResetWallsButton;
    private javax.swing.JLabel jSliderLabel;
    private javax.swing.JButton jSolveButton;
    private javax.swing.JSlider jSpeedSlider;
    private javax.swing.JButton jStopButton;
    private javax.swing.JPanel jTopPanel;
    // End of variables declaration//GEN-END:variables
    private final GridPanel gridPanel;
    private final Grid grid;
    private Cell start;
    private Cell end;
    private boolean solving=false;
    private boolean eraser = false;
    private int delay;
    private GeneralSolver solver;
    private int cellTypeCounter=0; // used to keep track of the type of cells that have been selected
    // 1 for start cell, 2 for stop cell, >2 for wall cell

    public long getDelay() {
       return this.delay;
    }
    
   
}
