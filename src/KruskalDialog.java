

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stukarudel
 */
public class KruskalDialog extends javax.swing.JDialog {

    /**
     * Creates new form KruskalDialog
     */
    public KruskalDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        DisplayGraphButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        FindMSTButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAutoRequestFocus(false);
        setMinimumSize(new java.awt.Dimension(0, 550));
        setType(java.awt.Window.Type.UTILITY);

        jTextField1.setText("graph1.txt");
        jTextField1.setToolTipText("enter path to graph file");

        DisplayGraphButton.setText("Display Graph");
        DisplayGraphButton.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DisplayGraphButtonStateChanged(evt);
            }
        });
        DisplayGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DisplayGraphButtonActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setText("Kruskal's MST Finder");

        FindMSTButton.setText("Find Minimum Spanning Tree");
        FindMSTButton.setToolTipText("");
        FindMSTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FindMSTButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(DisplayGraphButton)
                                .addGap(18, 18, 18)
                                .addComponent(FindMSTButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DisplayGraphButton)
                    .addComponent(FindMSTButton))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DisplayGraphButtonStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DisplayGraphButtonStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_DisplayGraphButtonStateChanged

    private void DisplayGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DisplayGraphButtonActionPerformed
        jTextArea1.setText("");
        String s = jTextField1.getText();
        SimpleGraph G = Kruskal.LoadGraph(s);
        jTextArea1.append(Kruskal.InspectGraph(G).toString());     
    }//GEN-LAST:event_DisplayGraphButtonActionPerformed

    private void FindMSTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FindMSTButtonActionPerformed
        jTextArea1.setText("");
        String s = jTextField1.getText();
        SimpleGraph G = Kruskal.LoadGraph(s);
        //jTextArea1.append(Kruskal.InspectGraph(G).toString());
        //run Kruskals Algorithm to generate the MST edges
        jTextArea1.append(Kruskal.EvaluateMST(Kruskal.KruskalsAlgorithm(G)).toString());
    }//GEN-LAST:event_FindMSTButtonActionPerformed

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
            java.util.logging.Logger.getLogger(KruskalDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KruskalDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KruskalDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KruskalDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                KruskalDialog dialog = new KruskalDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DisplayGraphButton;
    private javax.swing.JButton FindMSTButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
