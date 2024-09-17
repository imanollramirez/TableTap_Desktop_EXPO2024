package Controlador;

import Vista.frmMenu;
import Vista.pnlRegistrarClientes;
import Controlador.ctrlClientesRegistrados;
import Vista.pnlPerfil;
import Modelo.tbClientes;
import Vista.pnlClientesRegistrados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlMenu implements MouseListener{

    private frmMenu VISTA;
    public ctrlMenu (frmMenu vista)
    {
        this.VISTA = vista;
      
        vista.btnMenuInicio.addMouseListener(this);
        vista.btnAgregarCliente.addMouseListener(this);
        vista.btnMesasOcupadas.addMouseListener(this);
        vista.btnPerfil.addMouseListener(this);
        vista.btnLogOut.addMouseListener(this);    
    }
    
    //Función para cambiar el color de los botones, según el que se seleccione.
    public void BotonSeleccionado(MouseEvent btn)
    {
        if(btn.getSource() == VISTA.btnMenuInicio)
        {
        VISTA.btnMenuInicio.setEnabled(false);
        VISTA.btnAgregarCliente.setEnabled(true);
        VISTA.btnMesasOcupadas.setEnabled(true);
        VISTA.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VISTA.btnAgregarCliente)
        {
        VISTA.btnMenuInicio.setEnabled(true);
        VISTA.btnAgregarCliente.setEnabled(false);
        VISTA.btnMesasOcupadas.setEnabled(true);
        VISTA.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VISTA.btnMesasOcupadas)
        {
        VISTA.btnMenuInicio.setEnabled(true);
        VISTA.btnAgregarCliente.setEnabled(true);
        VISTA.btnMesasOcupadas.setEnabled(false);
        VISTA.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VISTA.btnPerfil)
        {
        VISTA.btnMenuInicio.setEnabled(true);
        VISTA.btnAgregarCliente.setEnabled(true);
        VISTA.btnMesasOcupadas.setEnabled(true);
        VISTA.btnPerfil.setEnabled(false);   
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VISTA.btnMenuInicio)
        {
            BotonSeleccionado(e);
            VISTA.btnMenuInicio.enable(false);
            VISTA.pnlMainContainer.setVisible(false);
        }
        if(e.getSource() == VISTA.btnAgregarCliente)
        {
            BotonSeleccionado(e);
            pnlRegistrarClientes cl = new pnlRegistrarClientes();
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(cl);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
        }
        if(e.getSource() == VISTA.btnMesasOcupadas)
        {
            BotonSeleccionado(e);
            
            tbClientes Modelo = new tbClientes();
            pnlClientesRegistrados pnlClRegistrados = new pnlClientesRegistrados();
            ctrlClientesRegistrados ctrl = new ctrlClientesRegistrados(Modelo,pnlClRegistrados);
            
            
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(pnlClRegistrados);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
            
        }
        if(e.getSource() == VISTA.btnPerfil)
        {
            BotonSeleccionado(e);
            pnlPerfil perfil = new pnlPerfil();
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(perfil);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
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
