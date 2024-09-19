package Controlador;

import Vista.frmLogin;
import Modelo.tbUsuarios;
import static Vista.frmMenu.initFrmMenu;
import static Vista.frmRecuperarContrasena.initFrmRecuperarContrasena;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlLogin implements MouseListener{

    frmLogin VISTA;
    tbUsuarios MODELO;
    
    public ctrlLogin(frmLogin vista, tbUsuarios modelo)
    {
        this.VISTA = vista;
        this.MODELO = modelo;
        
        vista.btnLogin.addMouseListener(this);
        vista.btnRecuperarCon.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VISTA.btnLogin)
        {
            MODELO.setNombreUsuario(VISTA.txtUsuario.getText());
            MODELO.setContrasenaUsuario(MODELO.ContrasenaEncriptada(VISTA.txtContrasena.getText()));
            if(MODELO.IniciarSesion() == true)
            {
                if(MODELO.RevisarCargo() == true)
                {    
                initFrmMenu();
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
