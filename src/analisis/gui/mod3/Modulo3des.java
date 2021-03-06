/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.gui.mod3;

import analisis.gui.MainMenu;
import analisis.math.Algoritmos;
import analisis.math.InvalidInput;
import analisis.math.PDF;
import analisis.math.VM;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author César
 */
public class Modulo3des extends javax.swing.JFrame {

    /**
     * Creates new form Modulo3des
     */
    public Modulo3des() {
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

        jPanel1 = new javax.swing.JPanel();
        lblf = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btncalc = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtfunc = new javax.swing.JTextField();
        txtx0 = new javax.swing.JTextField();
        txtresultado = new javax.swing.JTextField();
        btnreturn = new javax.swing.JButton();
        pnlvista = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtrango = new javax.swing.JTextField();
        txtavance = new javax.swing.JTextField();
        btnpdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblf.setText("F(x) =");

        jLabel1.setText("X0 =");

        btncalc.setText("Calcular");
        btncalc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalcActionPerformed(evt);
            }
        });

        jLabel2.setText("Recta Tangente");

        txtresultado.setEditable(false);

        btnreturn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnreturn.setText("Volver");
        btnreturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreturnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtresultado, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btncalc)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblf))
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnreturn)
                        .addGap(72, 72, 72)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(txtfunc, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(txtx0))
                .addContainerGap(515, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnreturn))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblf)
                    .addComponent(txtfunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtx0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btncalc)
                .addGap(34, 34, 34)
                .addComponent(txtresultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnlvista.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Intervalo en X y Y");

        jLabel4.setText("Avance de grafica(opcional)");

        btnpdf.setText("Generar Pdf");
        btnpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlvista, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtavance, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(txtrango))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnpdf)
                        .addGap(113, 113, 113))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtrango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtavance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(54, 54, 54)
                        .addComponent(btnpdf))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlvista, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncalcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalcActionPerformed
     pnlvista.removeAll();
     String func =txtfunc.getText();
     
     String respuesta="";
    //validar campos en blanco 
     if(VM.isBlank(func) || VM.isBlank(txtx0.getText()) || VM.isBlank(txtrango.getText()) || VM.isBlank(txtavance.getText()) ){
             txtresultado.setText("No dejes espacios vacios");
     }
     else{
         double valorinicial = Double.parseDouble(txtx0.getText());
            double rango = Double.parseDouble(txtrango.getText());
            double avance = Double.parseDouble(txtavance.getText());
            if(rango>=avance){
         try {
            respuesta = Algoritmos.rectasTangentes(func, valorinicial);
        } catch (InvalidInput ex) {
            Logger.getLogger(Modulo3des.class.getName()).log(Level.SEVERE, null, ex);
        }
     DataTable data = new DataTable(Double.class, Double.class);
     DataTable data2 = new DataTable(Double.class, Double.class);
     double y=0.0, y2=0.0;

     for (double x = -rango; x <= rango; x+=avance) {
         try {
             y = VM.eval(func,x);
         } catch (InvalidInput ex) {
             Logger.getLogger(Modulo3des.class.getName()).log(Level.SEVERE, null, ex);
         }
            data.add(x, y);
        }
        for (double x = -rango; x <= rango; x+=avance) {
         try {
             
             y2 = VM.eval(respuesta,x);
         } catch (InvalidInput ex) {
             Logger.getLogger(Modulo3des.class.getName()).log(Level.SEVERE, null, ex);
         }
            data2.add(x, y2);
        }
         XYPlot plot = new XYPlot(data,data2);
         LineRenderer lines = new DefaultLineRenderer2D();
         plot.setLineRenderer(data, lines);
         LineRenderer lines2 = new DefaultLineRenderer2D();
         plot.setLineRenderer(data2, lines2);
        Color color = new Color(0.0f, 0.3f, 1.0f);
        plot.getPointRenderer(data).setColor(color);
        plot.getLineRenderer(data).setColor(color);
       pnlvista.add(new InteractivePanel(plot));
       pnlvista.revalidate();
       pnlvista.repaint();
     txtresultado.setText("y ="+respuesta);
     }
            else{
                txtresultado.setText("El rango debe ser mayor al avance");
            }
     }
     
        
    
        
       
        
      
    }//GEN-LAST:event_btncalcActionPerformed

    private void btnreturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreturnActionPerformed
        // TODO add your handling code here:
        MainMenu menu=new MainMenu();menu.setVisible(true);menu.setLocationRelativeTo(null);this.setVisible(false);
    }//GEN-LAST:event_btnreturnActionPerformed

    private void btnpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpdfActionPerformed

        String func =txtfunc.getText();
        String respuesta="";
        if(VM.isBlank(func) || VM.isBlank(txtx0.getText()) || VM.isBlank(txtrango.getText()) || VM.isBlank(txtavance.getText()) ){
            txtresultado.setText("No dejes espacios vacios");
        }
        else{
            String valorinicial = txtx0.getText();
            String rango = txtrango.getText();
            String avance =txtavance.getText();
            try {
                respuesta = Algoritmos.rectasTangentes(func, Double.parseDouble(valorinicial));
            } catch (InvalidInput ex) {
                Logger.getLogger(Modulo3des.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                PDF.createPdfMod3("results/chapter01/hello_world2.pdf",respuesta,func,"Recta tangente");
                JOptionPane.showMessageDialog(null,"Pdf Creado con exito");
            } catch (IOException ex) {
                Logger.getLogger(Modulo3des.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Algo Fallo");
            }

        }

    }//GEN-LAST:event_btnpdfActionPerformed

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
            java.util.logging.Logger.getLogger(Modulo3des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulo3des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulo3des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulo3des.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulo3des().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncalc;
    private javax.swing.JButton btnpdf;
    private javax.swing.JButton btnreturn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblf;
    private javax.swing.JPanel pnlvista;
    private javax.swing.JTextField txtavance;
    private javax.swing.JTextField txtfunc;
    private javax.swing.JTextField txtrango;
    private javax.swing.JTextField txtresultado;
    private javax.swing.JTextField txtx0;
    // End of variables declaration//GEN-END:variables
}
