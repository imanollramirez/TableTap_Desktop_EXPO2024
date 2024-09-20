package Controlador;

import Modelo.tbUsuarios;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmCambiarContrasena;
import static Vista.frmLogin.initFrmLogin;

public class ctrlCambiarContrasena implements MouseListener{
    
    private frmCambiarContrasena VISTA;
    private tbUsuarios MODELO;
    public ctrlCambiarContrasena(frmCambiarContrasena vista, tbUsuarios modelo)
    {
        this.VISTA = vista;
        this.MODELO = modelo;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        initFrmLogin();
        VISTA.dispose();
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
