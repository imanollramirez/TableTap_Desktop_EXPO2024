package Controlador;

import Modelo.tbClientes;
import Vista.pnlClientesRegistrados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlClientesRegistrados implements MouseListener{

    private tbClientes MODELO;
    private pnlClientesRegistrados VISTA;
    
    public ctrlClientesRegistrados (tbClientes modelo, pnlClientesRegistrados vista)
    {
        this.MODELO = modelo;
        this.VISTA = vista;
        
        modelo.MostrarClientes(vista.jtbClientesRegistrados);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {    }

    @Override
    public void mousePressed(MouseEvent e) {    }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }
    
}
