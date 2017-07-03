/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.gui.mod2;

import analisis.gui.MainMenu;
import analisis.gui.mod3.Modulo3des;
import analisis.math.Algoritmos;
import analisis.math.InvalidInput;
import analisis.math.VM;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;

/**
 *
 * @author hmanr
 */
public class Mod2 extends javax.swing.JFrame {

    /**
     * Creates new form Mod2
     */
    public Mod2() {
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

        jLabel1 = new javax.swing.JLabel();
        function = new javax.swing.JTextField();
        lFunction = new javax.swing.JLabel();
        inter = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        varA = new javax.swing.JTextField();
        varB = new javax.swing.JTextField();
        a = new javax.swing.JLabel();
        lValue = new javax.swing.JLabel();
        variable = new javax.swing.JTextField();
        start = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        result = new javax.swing.JTextField();
        lResult = new javax.swing.JLabel();
        gPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Area Bajo La Curva");

        function.setPreferredSize(new java.awt.Dimension(200, 30));

        lFunction.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lFunction.setText("Función");

        inter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inter.setText("Intervalos");

        d.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        d.setText("De: ");

        varA.setPreferredSize(new java.awt.Dimension(50, 30));

        varB.setPreferredSize(new java.awt.Dimension(50, 30));
        varB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                varBActionPerformed(evt);
            }
        });

        a.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        a.setText("a");

        lValue.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lValue.setText("Variable a evaluar:");

        variable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        variable.setPreferredSize(new java.awt.Dimension(100, 30));
        variable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                variableActionPerformed(evt);
            }
        });

        start.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        start.setText("Calcular");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        back.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        back.setText("Volver");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        result.setPreferredSize(new java.awt.Dimension(200, 30));
        result.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resultActionPerformed(evt);
            }
        });

        lResult.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lResult.setText("Resultado:");

        gPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 243, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lResult)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(262, 262, 262))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(311, 311, 311))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(669, 669, 669))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(back)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lFunction)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(inter)
                                            .addComponent(function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(d)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(varA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(a)
                                        .addGap(18, 18, 18)
                                        .addComponent(varB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lValue)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(start)))
                                .addGap(18, 18, 18)
                                .addComponent(gPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(back)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lFunction)
                            .addComponent(function, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(inter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d)
                            .addComponent(varA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a)
                            .addComponent(varB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lValue)
                            .addComponent(variable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(start))
                    .addComponent(gPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(result, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lResult))
                .addGap(28, 28, 28)
                .addComponent(jLabel7)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void varBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_varBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_varBActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        gPanel.removeAll();
        String func =function.getText();
        String var=variable.getText();
        String var1=varA.getText();
        String var2=varB.getText();
        if(!func.isEmpty() && !var.isEmpty() && !var1.isEmpty() && !var2.isEmpty()){
        double inter1=Double.parseDouble(var1);
        double inter2=Double.parseDouble(var2);
        double answer=0.0;
        System.out.println(func+" "+var+" "+var1+" "+var2);
           try {
            answer=Algoritmos.ReglaDeSimpsonSimple(func,inter1,inter2,var);
        } catch (InvalidInput input) {
            Logger.getLogger(Mod2.class.getName()).log(Level.SEVERE, null,input);
        }
           DataTable data = new DataTable(Double.class,Double.class);
           DataTable data2 = new DataTable(Double.class,Double.class);
           
           double y=0.0,y2=0.0;
           for (double x = -10; x <= 10; x++) {
               try {
                   y=VM.eval(func,x,var);
                   System.out.println(y);
               } catch (Exception e) {
                   
               }
            data.add(x,y);
        }
           if(inter1<inter2){
               for (double x = inter1; x <=inter2; x++) {
                   try {
                       y2=VM.eval(func,x,var);
                       System.out.println(y2);
                   } catch (InvalidInput ex) {
                       Logger.getLogger(Mod2.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   data2.add(x,y2);
               }
           }
           else{
                for (double x = inter2; x <=inter1; x++) {
                   try {
                       y2=VM.eval(func,x,var);
                   } catch (InvalidInput ex) {
                       Logger.getLogger(Mod2.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   data2.add(x,y2);
               }
           }
           XYPlot plot = new XYPlot(data,data2);
           LineRenderer lines = new DefaultLineRenderer2D();
           plot.setLineRenderer(data, lines);
           LineRenderer lines2 = new DefaultLineRenderer2D();
           plot.setLineRenderer(data2,lines2);
           Color color = new Color(0.0f, 0.3f, 1.0f);
            plot.getPointRenderer(data).setColor(color);
            plot.getLineRenderer(data).setColor(color);
            gPanel.add(new InteractivePanel(plot));
            gPanel.revalidate();
            gPanel.repaint();
            gPanel.setVisible(true);
            result.setText("Y= "+Double.toString(answer));
        }
        else{
            result.setText("Error. Ingrese valores validos");
        }
           
       

    }//GEN-LAST:event_startActionPerformed

    private void variableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_variableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_variableActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        MainMenu menu=new MainMenu();menu.setVisible(true);menu.setLocationRelativeTo(null);this.setVisible(false);
    }//GEN-LAST:event_backActionPerformed

    private void resultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resultActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resultActionPerformed

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
            java.util.logging.Logger.getLogger(Mod2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mod2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mod2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mod2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mod2().setVisible(true);
            }
        });
    }
   


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a;
    private javax.swing.JButton back;
    private javax.swing.JLabel d;
    private javax.swing.JTextField function;
    private javax.swing.JPanel gPanel;
    private javax.swing.JLabel inter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lFunction;
    private javax.swing.JLabel lResult;
    private javax.swing.JLabel lValue;
    private javax.swing.JTextField result;
    private javax.swing.JButton start;
    private javax.swing.JTextField varA;
    private javax.swing.JTextField varB;
    private javax.swing.JTextField variable;
    // End of variables declaration//GEN-END:variables
}
