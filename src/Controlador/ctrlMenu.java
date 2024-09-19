package Controlador;

import Vista.frmMenu;
import Vista.pnlRegistrarClientes;
import Controlador.ctrlClientesRegistrados;
import Controlador.ctrlReservacionMesas;
import Vista.pnlPerfil;
import Modelo.tbClientes;
import Modelo.tbMesas;
import Modelo.tbEmpleados;
import Vista.pnlClientesRegistrados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ctrlMenu implements MouseListener{

    private frmMenu VISTA;
    private tbEmpleados INFO;
    public ctrlMenu (frmMenu vista, tbEmpleados info)
    {
        this.VISTA = vista;
        this.INFO = info;
      
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
            frmMenu menu = new frmMenu();
            tbMesas mesas = new tbMesas();
            ctrlReservacionMesas ctrlReservar = new ctrlReservacionMesas(cl,mesas,menu);
            mesas.EstadoMesa(cl);
            
            VISTA.pnlMainContainer.removeAll();
            VISTA.pnlMainContainer.add(cl);
            VISTA.pnlMainContainer.revalidate();
            VISTA.pnlMainContainer.repaint();
            VISTA.pnlMainContainer.setVisible(true);
        }
        if(e.getSource() == VISTA.btnMesasOcupadas)
        {
            BotonSeleccionado(e);
            
            tbClientes Clientes = new tbClientes();
            pnlClientesRegistrados pnlClRegistrados = new pnlClientesRegistrados();
            tbMesas Mesas = new tbMesas();
            ctrlClientesRegistrados ctrl = new ctrlClientesRegistrados(Mesas,Clientes,pnlClRegistrados);
            
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
            perfil.txtCorreoPerfil.setText(INFO.Correo);
            perfil.txtDUIperfil.setText(INFO.DUI);
            perfil.txtTelefonoPerfil.setText(INFO.Telefono);
            perfil.lblNombreEmpleado.setText(INFO.Nombre);
            perfil.lblApellidosEmpleado.setText(INFO.Apellidos);
            perfil.lblCargoEmpleado.setText(INFO.Cargo);
            
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
