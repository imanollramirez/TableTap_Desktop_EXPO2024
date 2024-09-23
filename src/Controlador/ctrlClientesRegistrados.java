package Controlador;

import Modelo.tbClientes;
import Modelo.tbMesas;
import Vista.pnlClientesRegistrados;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/* Este controlador contiene la tabla de los clintes registrados en la base, se pude eliminar y actuliazar (Insertar no porque esa función
es de otro form.
- Bueno, es lo mismo que el de android, si el cliente tiene un pedido y no ha finalzado, no se puede eliminar; de lo contrario si.
- Se actualiza normal como lo de siempre, los campos y solamente se cambia la información*/

public class ctrlClientesRegistrados implements MouseListener{

    private tbClientes CLIENTES;
    private pnlClientesRegistrados VISTA;
    private tbMesas MESAS;
    
    public ctrlClientesRegistrados (tbMesas mesas,tbClientes clientes, pnlClientesRegistrados vista)
    {
        this.CLIENTES = clientes;
        this.VISTA = vista;
        this.MESAS = mesas;
        
        CLIENTES.MostrarClientes(vista.jtbClientesRegistrados);
        
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
    if(e.getSource() == VISTA.btnActualizar)
    {
       if (VISTA.txtNombreCliente.getText().isEmpty() || 
        VISTA.txtApellidosCliente.getText().isEmpty() || 
        VISTA.txtCorreoCliente.getText().isEmpty() || 
        VISTA.txtDUIcliente.getText().isEmpty()) {
    
        JOptionPane.showMessageDialog(null, "Complete los campos.");
    
        // .*\\d.*    => asi es la manera de validar si el texto contiene números.      
        
        } else if (VISTA.txtNombreCliente.getText().matches(".*\\d.*") || VISTA.txtApellidosCliente.getText().matches(".*\\d.*")) {
    
        JOptionPane.showMessageDialog(null, "El nombre o apellido no puede contener números.");
        VISTA.txtNombreCliente.setFocusable(true);
    
        } else if (!VISTA.txtCorreoCliente.getText().matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
    
        JOptionPane.showMessageDialog(null, "¡El correo electrónico es inválido!.");
        VISTA.txtCorreoCliente.setFocusable(true);
    
        } else if (VISTA.txtDUIcliente.getText().matches(".*[a-zA-Z].*")) {
    
        JOptionPane.showMessageDialog(null, "El número de DUI no puede contener letras.");
        VISTA.txtDUIcliente.setFocusable(true);
        }
        else if(VISTA.txtDUIcliente.getText().length() > 10)
        {
            JOptionPane.showMessageDialog(null, "El número de DUI no puede contener más de 8 dígitos.");
            VISTA.txtDUIcliente.setFocusable(true);
        }
        else if(VISTA.txtDUIcliente.getText().length() < 10)
        {
            JOptionPane.showMessageDialog(null, "El número de DUI no puede contener menos de 8 dígitos.");
            VISTA.txtDUIcliente.setFocusable(true);
        }
        else
        {            
            CLIENTES.setNombreCliente(VISTA.txtNombreCliente.getText());
            CLIENTES.setApellidoCliente(VISTA.txtApellidosCliente.getText());
            CLIENTES.setCorreoCliente(VISTA.txtCorreoCliente.getText());
            CLIENTES.setDUIcliente(VISTA.txtDUIcliente.getText());
            
            CLIENTES.ActualizarCliente(VISTA.jtbClientesRegistrados);
            JOptionPane.showMessageDialog(null, "Se actualizó el cliente correctamente.");
            Limpiar();
            
            CLIENTES.MostrarClientes(VISTA.jtbClientesRegistrados);
            //Ocultar el ID
            VISTA.jtbClientesRegistrados.getColumnModel().getColumn(0).setPreferredWidth(0);
            VISTA.jtbClientesRegistrados.getColumnModel().getColumn(0).setMinWidth(0);
            VISTA.jtbClientesRegistrados.getColumnModel().getColumn(0).setMaxWidth(0);
        }
    }
    if(e.getSource() == VISTA.btnEliminar)        
    {
        try
        {
            if(CLIENTES.ExistePedidoCliente(VISTA.jtbClientesRegistrados) == true)
            {
                JOptionPane.showMessageDialog(null, "No puede eliminar el cliente porque aún no finaliza su orden.");
            }
            else
            {
            MESAS.EliminarMesa(VISTA.jtbClientesRegistrados);
            CLIENTES.EliminarCliente(VISTA.jtbClientesRegistrados);
            JOptionPane.showMessageDialog(null, "Se eliminó el cliente correctamente.");
            Limpiar();
        
            CLIENTES.MostrarClientes(VISTA.jtbClientesRegistrados);
            //Ocultar el ID
            VISTA.jtbClientesRegistrados.getColumnModel().getColumn(0).setPreferredWidth(0);
            VISTA.jtbClientesRegistrados.getColumnModel().getColumn(0).setMinWidth(0);
            VISTA.jtbClientesRegistrados.getColumnModel().getColumn(0).setMaxWidth(0);   
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente.");
        }
        
        
    }
    if(e.getSource() == VISTA.jtbClientesRegistrados)
    {
        CLIENTES.CargarDatosCl(VISTA);
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
