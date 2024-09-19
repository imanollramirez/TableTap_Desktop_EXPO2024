package Controlador;

import Vista.frmLogin;
import Modelo.tbUsuarios;
import Modelo.tbEmpleados;
import Vista.frmMenu;
import static Vista.frmRecuperarContrasena.initFrmRecuperarContrasena;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlLogin implements MouseListener{

    frmLogin VISTA;
    tbUsuarios USUARIO;
    tbEmpleados EMPLEADOS;
    
    public ctrlLogin(frmLogin vista, tbUsuarios usuario, tbEmpleados empleados)
    {
        this.VISTA = vista;
        this.USUARIO = usuario;
        this.EMPLEADOS = empleados;
        
        vista.btnLogin.addMouseListener(this);
        vista.btnRecuperarCon.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VISTA.btnLogin)
        {
            USUARIO.setNombreUsuario(VISTA.txtUsuario.getText());
            USUARIO.setContrasenaUsuario(USUARIO.ContrasenaEncriptada(VISTA.txtContrasena.getText()));
            if(USUARIO.IniciarSesion() == true)
            {
                if(USUARIO.RevisarCargo() == true)
                {
                EMPLEADOS.DatosPerfil(VISTA.txtUsuario.getText());
                frmMenu menu = new frmMenu();
                ctrlMenu ctrl = new ctrlMenu(menu,EMPLEADOS);
                menu.setVisible(true);
                VISTA.dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Tu cuenta no cuenta con acceso a este Cargo.");   
                }
            }
            else
            {
               JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos.");   
            }
            
        }
        if(e.getSource() == VISTA.btnRecuperarCon)
        {
            initFrmRecuperarContrasena();
            VISTA.dispose();
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
