/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.gui.mod4;

import analisis.math.Algoritmos;
import analisis.math.VM;
import de.erichseifert.gral.data.DataTable;

/**
 *
 * @author Luis
 */
public class Modulo4 extends javax.swing.JPanel {

	/**
	 * Creates new form Modulo4
	 */
	public Modulo4() {
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

        integralTButton = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();

        integralTButton.setText("jToggleButton1");
        integralTButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                integralTButtonActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(integralTButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(125, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(integralTButton)
                .addGap(58, 58, 58))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void integralTButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_integralTButtonActionPerformed
        String fun = jTextField1.getText();
		
		jTextField1.setText(Double.toString(Algoritmos.deltaCentral(fun, 3, 1,6)));
    }//GEN-LAST:event_integralTButtonActionPerformed

	private DataTable data;
	
	
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton integralTButton;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
