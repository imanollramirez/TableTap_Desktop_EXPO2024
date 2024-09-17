package Controlador;

import Vista.frmMenu;
import Vista.pnlRegistrarClientes;
import Vista.pnlPerfil;
import Vista.pnlClientesRegistrados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlMenu implements MouseListener{

    frmMenu VIEW;
    public ctrlMenu (frmMenu view)
    {
        this.VIEW = view;
        view.btnMenuInicio.addMouseListener(this);
        view.btnAgregarCliente.addMouseListener(this);
        view.btnMesasOcupadas.addMouseListener(this);
        view.btnPerfil.addMouseListener(this);
        view.btnLogOut.addMouseListener(this);
    }
    
    
    public void BotonSeleccionado(MouseEvent btn)
    {
        if(btn.getSource() == VIEW.btnMenuInicio)
        {
        VIEW.btnMenuInicio.setEnabled(false);
        VIEW.btnAgregarCliente.setEnabled(true);
        VIEW.btnMesasOcupadas.setEnabled(true);
        VIEW.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VIEW.btnAgregarCliente)
        {
        VIEW.btnMenuInicio.setEnabled(true);
        VIEW.btnAgregarCliente.setEnabled(false);
        VIEW.btnMesasOcupadas.setEnabled(true);
        VIEW.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VIEW.btnMesasOcupadas)
        {
        VIEW.btnMenuInicio.setEnabled(true);
        VIEW.btnAgregarCliente.setEnabled(true);
        VIEW.btnMesasOcupadas.setEnabled(false);
        VIEW.btnPerfil.setEnabled(true);   
        }
        if(btn.getSource() == VIEW.btnPerfil)
        {
        VIEW.btnMenuInicio.setEnabled(true);
        VIEW.btnAgregarCliente.setEnabled(true);
        VIEW.btnMesasOcupadas.setEnabled(true);
        VIEW.btnPerfil.setEnabled(false);   
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VIEW.btnMenuInicio)
        {
            BotonSeleccionado(e);
            VIEW.btnMenuInicio.enable(false);
            VIEW.pnlMainContainer.setVisible(false);
        }
        if(e.getSource() == VIEW.btnAgregarCliente)
        {
            BotonSeleccionado(e);
            pnlRegistrarClientes cl = new pnlRegistrarClientes();
            VIEW.pnlMainContainer.removeAll();
            VIEW.pnlMainContainer.add(cl);
            VIEW.pnlMainContainer.revalidate();
            VIEW.pnlMainContainer.repaint();
            VIEW.pnlMainContainer.setVisible(true);
        }
        if(e.getSource() == VIEW.btnMesasOcupadas)
        {
            BotonSeleccionado(e);
            pnlClientesRegistrados clRegis = new pnlClientesRegistrados();
            VIEW.pnlMainContainer.removeAll();
            VIEW.pnlMainContainer.add(clRegis);
            VIEW.pnlMainContainer.revalidate();
            VIEW.pnlMainContainer.repaint();
            VIEW.pnlMainContainer.setVisible(true);
            
        }
        if(e.getSource() == VIEW.btnPerfil)
        {
            BotonSeleccionado(e);
            pnlPerfil perfil = new pnlPerfil();
            VIEW.pnlMainContainer.removeAll();
            VIEW.pnlMainContainer.add(perfil);
            VIEW.pnlMainContainer.revalidate();
            VIEW.pnlMainContainer.repaint();
            VIEW.pnlMainContainer.setVisible(true);
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
