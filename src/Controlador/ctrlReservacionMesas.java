package Controlador;

import Modelo.tbClientes;
import Modelo.tbMesas;
import Modelo.tbEmpleados;
import Vista.pnlRegistrarClientes;
import Vista.frmInformacionCliente;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlReservacionMesas implements MouseListener {

    tbMesas MODELO;
    pnlRegistrarClientes VISTA;
    
    public ctrlReservacionMesas (pnlRegistrarClientes vista, tbMesas modelo)
    {
        this.MODELO = modelo;
        this.VISTA = vista;
        
        vista.Mesa1.addMouseListener(this);
        vista.Mesa2.addMouseListener(this);
        vista.Mesa3.addMouseListener(this);
        vista.Mesa4.addMouseListener(this);
        vista.Mesa5.addMouseListener(this);
        vista.Mesa6.addMouseListener(this);
        vista.Mesa7.addMouseListener(this);
        vista.Mesa8.addMouseListener(this);
        vista.Mesa9.addMouseListener(this);
        vista.Mesa10.addMouseListener(this);
        vista.Mesa11.addMouseListener(this);
        vista.Mesa12.addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {  
        if(e.getSource() == VISTA.Mesa1)
        {
            if(VISTA.Mesa1.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,1);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa2)
        {
            if(VISTA.Mesa2.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,2);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa3)
        {
            if(VISTA.Mesa3.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,3);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa4)
        {
            if(VISTA.Mesa4.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,4);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa5)
        {
            if(VISTA.Mesa5.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,5);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa6)
        {
            if(VISTA.Mesa6.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,6);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa7)
        {
            if(VISTA.Mesa7.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,7);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa8)
        {
            if(VISTA.Mesa8.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,8);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa9)
        {
            if(VISTA.Mesa9.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,9);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa10)
        {
            if(VISTA.Mesa10.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,10);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa11)
        {
            if(VISTA.Mesa11.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,11);
                infoCl.setVisible(true);
            }
        }
        if(e.getSource() == VISTA.Mesa12)
        {
            if(VISTA.Mesa12.isEnabled() == false)
            {
                JOptionPane.showMessageDialog(null, "La mesa no se encuentra disponible.");
            }
            else
            {
                frmInformacionCliente infoCl = new frmInformacionCliente();
                tbClientes cl = new tbClientes();
                tbMesas mesas = new tbMesas();
                tbEmpleados em = new tbEmpleados();
                
                ctrlInformacionCliente ctrlInfo = new ctrlInformacionCliente(infoCl,cl,mesas,em,12);
                infoCl.setVisible(true);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {    }

    @Override
    public void mouseReleased(MouseEvent e) {    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }
    
}
