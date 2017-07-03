/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisis.gui;


import analisis.gui.mod1.Modulo1;
import analisis.gui.mod2.Mod2;
import analisis.gui.mod3.Modulo3des;
import analisis.gui.mod4.Mod4;

/**
 *
 * @author Luis
 */
public class MainMenu extends javax.swing.JFrame {

	/**
	 * Creates new form MainMenu
	 */
	public MainMenu() {
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

        btnNewton = new javax.swing.JButton();
        btnABCurva = new javax.swing.JButton();
        btnRT = new javax.swing.JButton();
        btnIM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnNewton.setText("Newton Raphson");
        btnNewton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewtonActionPerformed(evt);
            }
        });

        btnABCurva.setText("Área Bajo la Curva");
        btnABCurva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnABCurvaActionPerformed(evt);
            }
        });

        btnRT.setText("Rectas Tangentes");
        btnRT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRTActionPerformed(evt);
            }
        });

        btnIM.setText("Integrales Múltiples");
        btnIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIM)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnNewton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnABCurva, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnNewton)
                .addGap(38, 38, 38)
                .addComponent(btnABCurva)
                .addGap(43, 43, 43)
                .addComponent(btnRT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnIM)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewtonActionPerformed
        Modulo1 mod = new Modulo1(); mod.setVisible(true);this.setVisible(false);
    }//GEN-LAST:event_btnNewtonActionPerformed

    private void btnIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIMActionPerformed
        Mod4 mod4=new Mod4();mod4.setVisible(true);this.setVisible(false);
    }//GEN-LAST:event_btnIMActionPerformed

    private void btnRTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRTActionPerformed
        Modulo3des mod3 = new Modulo3des(); mod3.setVisible(true);this.setVisible(false);
    }//GEN-LAST:event_btnRTActionPerformed

    private void btnABCurvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnABCurvaActionPerformed
        // TODO add your handling code here:
        Mod2 mod2=new Mod2();mod2.setVisible(true);this.setVisible(false);
    }//GEN-LAST:event_btnABCurvaActionPerformed

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
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenu().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnABCurva;
    private javax.swing.JButton btnIM;
    private javax.swing.JButton btnNewton;
    private javax.swing.JButton btnRT;
    // End of variables declaration//GEN-END:variables
}
