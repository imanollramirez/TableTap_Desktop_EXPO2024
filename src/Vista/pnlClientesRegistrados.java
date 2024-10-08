package Vista;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

public class pnlClientesRegistrados extends javax.swing.JPanel {

    /**
     * Creates new form pnlClientesRegistrados
     */
    public pnlClientesRegistrados() {
        initComponents();
        try {
            Font poppinsFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fonts/Poppins/Poppins-Regular.ttf"));
            poppinsFont = poppinsFont.deriveFont(14f); 
            lbl1.setFont(poppinsFont);
            lbl2.setFont(poppinsFont);
            lbl3.setFont(poppinsFont);
            lbl4.setFont(poppinsFont);
            txtNombreCliente.setFont(poppinsFont);
            txtApellidosCliente.setFont(poppinsFont);
            txtCorreoCliente.setFont(poppinsFont);
            txtDUIcliente.setFont(poppinsFont);
            btnActualizar.setFont(poppinsFont);
            btnEliminar.setFont(poppinsFont);
            btnLimpiar.setFont(poppinsFont);
            jtbClientesRegistrados.setFont(poppinsFont);
            
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
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidosCliente = new javax.swing.JTextField();
        txtCorreoCliente = new javax.swing.JTextField();
        txtDUIcliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbClientesRegistrados = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl1.setForeground(new java.awt.Color(0, 0, 0));
        lbl1.setText("Nombre:");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, -1, -1));

        lbl2.setForeground(new java.awt.Color(0, 0, 0));
        lbl2.setText("Apellidos:");
        jPanel1.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, -1, -1));

        lbl3.setForeground(new java.awt.Color(0, 0, 0));
        lbl3.setText("Correo:");
        jPanel1.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, -1));

        lbl4.setForeground(new java.awt.Color(0, 0, 0));
        lbl4.setText("DUI:");
        jPanel1.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        btnActualizar.setText("Actualizar");
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 100, -1));

        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 100, -1));

        btnLimpiar.setText("Limpiar");
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 100, -1));
        jPanel1.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, 230, 40));
        jPanel1.add(txtApellidosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 260, 230, 40));
        jPanel1.add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 170, 230, 40));
        jPanel1.add(txtDUIcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 260, 230, 40));

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));

        jtbClientesRegistrados.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jtbClientesRegistrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbClientesRegistrados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 770, 340));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Clientes_img.png"))); // NOI18N
        jPanel1.add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 770));

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
    public javax.swing.JButton btnActualizar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel fondo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jtbClientesRegistrados;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    public javax.swing.JTextField txtApellidosCliente;
    public javax.swing.JTextField txtCorreoCliente;
    public javax.swing.JTextField txtDUIcliente;
    public javax.swing.JTextField txtNombreCliente;
    // End of variables declaration//GEN-END:variables
}
