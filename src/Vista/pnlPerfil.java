package Vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;


public class pnlPerfil extends javax.swing.JPanel {
    
    public pnlPerfil() {
        initComponents();
        try {
            Font poppinsFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Poppins/Poppins-Bold.ttf"));
            poppinsFont = poppinsFont.deriveFont(22f); 
            
            Font Info = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Poppins/Poppins-Regular.ttf"));
            Info = Info.deriveFont(20f);
            
            Font Otro = poppinsFont;
            
            txtCorreoPerfil.setFont(Info);
            txtDUIperfil.setFont(Info);
            txtTelefonoPerfil.setFont(Info);
            lblNombreEmpleado.setFont(Otro);
            lblApellidosEmpleado.setFont(Otro);
            lblCargoEmpleado.setFont(Otro);
            
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

        jPanel1 = new javax.swing.JPanel();
        txtTelefonoPerfil = new javax.swing.JTextField();
        txtCorreoPerfil = new javax.swing.JTextField();
        txtDUIperfil = new javax.swing.JTextField();
        lblNombreEmpleado = new javax.swing.JLabel();
        lblApellidosEmpleado = new javax.swing.JLabel();
        lblCargoEmpleado = new javax.swing.JLabel();
        imgFotoPerfil = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtTelefonoPerfil.setEditable(false);
        txtTelefonoPerfil.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefonoPerfil.setToolTipText("");
        txtTelefonoPerfil.setBorder(null);
        txtTelefonoPerfil.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtTelefonoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 493, 290, 40));

        txtCorreoPerfil.setEditable(false);
        txtCorreoPerfil.setForeground(new java.awt.Color(0, 0, 0));
        txtCorreoPerfil.setToolTipText("");
        txtCorreoPerfil.setBorder(null);
        txtCorreoPerfil.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtCorreoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 286, 290, 40));

        txtDUIperfil.setEditable(false);
        txtDUIperfil.setForeground(new java.awt.Color(0, 0, 0));
        txtDUIperfil.setToolTipText("");
        txtDUIperfil.setBorder(null);
        txtDUIperfil.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(txtDUIperfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 290, 40));

        lblNombreEmpleado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblNombreEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreEmpleado.setText("Nombre del empleado");
        jPanel1.add(lblNombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 410, 50));

        lblApellidosEmpleado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblApellidosEmpleado.setForeground(new java.awt.Color(0, 0, 0));
        lblApellidosEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApellidosEmpleado.setText("Apellidos del empleado");
        jPanel1.add(lblApellidosEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 630, 410, 50));

        lblCargoEmpleado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblCargoEmpleado.setForeground(new java.awt.Color(255, 0, 0));
        lblCargoEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCargoEmpleado.setText("Cargo del empleado");
        jPanel1.add(lblCargoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 690, 410, 50));

        imgFotoPerfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgFotoPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/perfil_prueba.png"))); // NOI18N
        imgFotoPerfil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        imgFotoPerfil.setMaximumSize(new java.awt.Dimension(360, 360));
        imgFotoPerfil.setMinimumSize(new java.awt.Dimension(390, 390));
        imgFotoPerfil.setPreferredSize(new java.awt.Dimension(390, 390));
        jPanel1.add(imgFotoPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 168, 360, 390));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Perfil_img.png"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    public javax.swing.JLabel imgFotoPerfil;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblApellidosEmpleado;
    public javax.swing.JLabel lblCargoEmpleado;
    public javax.swing.JLabel lblNombreEmpleado;
    public javax.swing.JTextField txtCorreoPerfil;
    public javax.swing.JTextField txtDUIperfil;
    public javax.swing.JTextField txtTelefonoPerfil;
    // End of variables declaration//GEN-END:variables
}
