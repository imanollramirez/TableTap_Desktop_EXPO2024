package Controlador;

import Modelo.tbUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmCambiarContrasena;
import static Vista.frmLogin.initFrmLogin;
import javax.swing.JOptionPane;

/*Este controlador, cumple con la función de actualizar la contraseña del usuario.
Pidiendole su nombre de usuario y contraseña, y antes de que se actualice, verifica si el uusario existe, y también si
la contraseña es la misma que la antigua, por motivos de seguridad debe de ser distinta.

-Se utiliza:
-  formulario de recuperación.
-  Controlador del mismo
-  tbUsuarios, que es donde están almacenados los usuarios en la base de datos.
*/

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
                    VISTA.dispose();
                    initFrmLogin();
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
