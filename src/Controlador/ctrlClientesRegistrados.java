package Controlador;

import Modelo.tbClientes;
import Vista.pnlClientesRegistrados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlClientesRegistrados implements MouseListener{

    private tbClientes MODELO;
    private pnlClientesRegistrados VISTA;
    
    public ctrlClientesRegistrados (tbClientes modelo, pnlClientesRegistrados vista)
    {
        this.MODELO = modelo;
        this.VISTA = vista;
        
        modelo.MostrarClientes(vista.jtbClientesRegistrados);
        
        //Esto solamente oculta la primer columna, que es el id. solamnete le pone un ancho d 0, porque si la quitamos da error al cargar los datos.
        vista.jtbClientesRegistrados.getColumnModel().getColumn(0).setPreferredWidth(0);
        vista.jtbClientesRegistrados.getColumnModel().getColumn(0).setMinWidth(0);
        vista.jtbClientesRegistrados.getColumnModel().getColumn(0).setMaxWidth(0);
        
        
        vista.btnActualizar.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        vista.jtbClientesRegistrados.addMouseListener(this);
    }
    
    public void Limpiar()
    {
        VISTA.txtNombreCliente.setText("");
        VISTA.txtApellidosCliente.setText("");
        VISTA.txtCorreoCliente.setText("");
        VISTA.txtDUIcliente.setText("");
        JOptionPane.showMessageDialog(null, "Se limpiaron los campos.");
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { 
    if(e.getSource() == VISTA.btnLimpiar)
    {
        Limpiar();
    }
    if(e.getSource() == VISTA.jtbClientesRegistrados)
    {
        MODELO.CargarDatosCl(VISTA);
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
