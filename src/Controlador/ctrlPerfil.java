package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.tbEmpleados;
import Vista.pnlPerfil;
import javax.swing.JOptionPane;

public class ctrlPerfil implements MouseListener{

    tbEmpleados MODELO;
    pnlPerfil VISTA;
    
    public ctrlPerfil(pnlPerfil vista,tbEmpleados modelo)
    {
        this.VISTA = vista;
        this.MODELO = modelo;
        
        vista.btnCerrarSesion.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {   
        if(e.getSource() == VISTA.btnCerrarSesion)
        {
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
