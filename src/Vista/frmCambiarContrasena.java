/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;

/**
 *
 * @author Aleim
 */
public class frmCambiarContrasena extends javax.swing.JFrame {

    /**
     * Creates new form frmCambiarContrasena
     */
    public frmCambiarContrasena() {
        initComponents();
        
        /*Este código lo que haces que les asigna el logo a la aplicación.
        Lo hace de la siguiente manera, obtiene el recurso, osea la IMG, y luego se la asigna al form, acá mismo
        ya que estamos en el mismo formulario.*/
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/TableTap_Logo_Transparente.png")).getImage());
        
        try {
            Font poppins = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Poppins/Poppins-regular.ttf"));
            poppins = poppins.deriveFont(16f); 
            
            Font pop = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Poppins/Poppins-Bold.ttf"));
            pop = pop.deriveFont(16f);
            txtUsuario.setFont(poppins);
            txtNuevaContra.setFont(poppins);
            txtConfirmarNuevaContra.setFont(poppins);
            btnRestablecer.setFont(pop);
            
            
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        txtConfirmarNuevaContra = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtNuevaContra = new javax.swing.JTextField();
        btnRestablecer = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Restablecer contraseña");
        setMinimumSize(new java.awt.Dimension(500, 620));
        setResizable(false);

        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setMaximumSize(new java.awt.Dimension(500, 620));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtConfirmarNuevaContra.setForeground(new java.awt.Color(0, 0, 0));
        txtConfirmarNuevaContra.setToolTipText("Ingrese su nombre de usuario");
        txtConfirmarNuevaContra.setBorder(null);
        panel.add(txtConfirmarNuevaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 441, 250, 40));

        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setToolTipText("Ingrese su nombre de usuario");
        txtUsuario.setBorder(null);
        panel.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 252, 250, 40));

        txtNuevaContra.setForeground(new java.awt.Color(0, 0, 0));
        txtNuevaContra.setToolTipText("Ingrese su nombre de usuario");
        txtNuevaContra.setBorder(null);
        panel.add(txtNuevaContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 348, 250, 40));

        btnRestablecer.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        btnRestablecer.setForeground(new java.awt.Color(255, 255, 255));
        btnRestablecer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRestablecer.setText("Restablecer");
        panel.add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 536, 130, 48));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CambiarContra_img.png"))); // NOI18N
        panel.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Container.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmCambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCambiarContrasena.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    public javax.swing.JLabel btnRestablecer;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel panel;
    public javax.swing.JTextField txtConfirmarNuevaContra;
    public javax.swing.JTextField txtNuevaContra;
    public javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
