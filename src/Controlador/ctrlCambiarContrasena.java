package Controlador;

import Modelo.tbUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmCambiarContrasena;
import static Vista.frmLogin.initFrmLogin;
import javax.swing.JOptionPane;

public class ctrlCambiarContrasena implements MouseListener{
    
    private frmCambiarContrasena VISTA;
    private tbUsuarios MODELO;
    public ctrlCambiarContrasena(frmCambiarContrasena vista, tbUsuarios modelo)
    {
        this.VISTA = vista;
        this.MODELO = modelo;
        
        vista.btnRestablecer.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VISTA.btnRestablecer)
        {
                MODELO.setNombreUsuario(VISTA.txtUsuario.getText());
                MODELO.setContrasenaUsuario(MODELO.ContrasenaEncriptada(VISTA.txtNuevaContra.getText()));
            
            if(VISTA.txtUsuario.getText().isEmpty() || VISTA.txtNuevaContra.getText().isEmpty() || VISTA.txtConfirmarNuevaContra.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Complete los campos.");
            }
            else if(!VISTA.txtConfirmarNuevaContra.getText().equals(VISTA.txtNuevaContra.getText()))
            {
                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
            }
            else
            {                
                if(MODELO.existeUsuario() == false)
                {
                    JOptionPane.showMessageDialog(null, "Usuario no encontrado, verifique su nombre de usuario.");
                }
                else
                {
                 if(MODELO.RevisarContra() == true)
                {
                    JOptionPane.showMessageDialog(null, "Su contraseña debe ser diferente a la antigua.");
                }
                else
                {
                    MODELO.CambiarContrasena();
                    JOptionPane.showMessageDialog(null, "Se restableció su contraseña correctamente.");
                    initFrmLogin();
                    VISTA.dispose();
                }   
                }
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
