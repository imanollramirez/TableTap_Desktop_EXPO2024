
package Controlador;

import Vista.frmCambiarContrasena;
import Controlador.ctrlCambiarContrasena;
import Modelo.tbUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmVerificarCodRecuperacion;
import javax.swing.JOptionPane;

public class ctrlVerificarCodigo implements MouseListener {

    public int CODIGO;
    private frmVerificarCodRecuperacion VISTA;
    
    public ctrlVerificarCodigo(frmVerificarCodRecuperacion vista, int codigo)
    {
        this.CODIGO = codigo;
        this.VISTA = vista;
        
        vista.btnVerificarCod.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
     if(e.getSource() == VISTA.btnVerificarCod)   
     {
         if(Integer.parseInt(VISTA.txtCodigo.getText()) == CODIGO)
         {
             frmCambiarContrasena frm = new frmCambiarContrasena();
             tbUsuarios usu = new tbUsuarios();
             ctrlCambiarContrasena ctrl = new ctrlCambiarContrasena(frm,usu);
             frm.setVisible(true);
             VISTA.dispose();
         }
         else
         {
             JOptionPane.showMessageDialog(null, "El código es incorrecto.");
         }
     }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
