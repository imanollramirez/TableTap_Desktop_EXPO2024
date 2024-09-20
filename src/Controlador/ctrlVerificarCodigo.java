
package Controlador;

import Vista.frmCambiarContrasena;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmVerificarCodRecuperacion;

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
             frm.setVisible(true);
         }
         else
         {
             
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
