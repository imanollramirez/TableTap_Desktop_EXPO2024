package Controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.frmInformacionCliente;
import Modelo.tbClientes;
import Modelo.tbMesas;
import Modelo.tbEmpleados;
import java.util.UUID;
import javax.swing.JOptionPane;

/*
Este controlador pide la información del cliente que se va a registrar, también las tablad de Clietnes y Mesas,
ya que en ambas se harán el INSERT, porque el cliente posee una mesa.

Se le asigna una mesa, y tambien un mesero.
*/


public class ctrlInformacionCliente implements MouseListener{

    frmInformacionCliente VISTA;
    tbClientes CLIENTES;
    tbMesas MESAS;
    tbEmpleados EMPLEADOS;
    public String idEmpleado = "";
    
    
    public ctrlInformacionCliente(frmInformacionCliente vista,tbClientes clientes, tbMesas mesas, tbEmpleados empleados, int NumMesa)
    {
        this.VISTA = vista;
        this.CLIENTES = clientes;
        this.MESAS = mesas;
        this.EMPLEADOS = empleados;
        
        vista.btnListo.addMouseListener(this);
        empleados.CargarMeseros(vista.cbMesero);
        mesas.setIdMesa(NumMesa);
        
        //Investigation: This code, gets the first Employee found in the Combo Box, avoiding any mistakes by not touching it.
        //I mean, if the User do not change it, cuz the ID would be empty.
        tbEmpleados selectedItem = (tbEmpleados) vista.cbMesero.getSelectedItem();
        if (selectedItem != null) {
        idEmpleado = selectedItem.getIdEmpleado();
        mesas.setIdEmpleado(idEmpleado); 
}
        //This code change the employee and gets the ID, to send it to the BD, Teacher Bryan taught it to us.
        vista.cbMesero.addActionListener(e -> 
         {
             if(e.getSource() == vista.cbMesero)
                {
                if(selectedItem != null)
                {
                    idEmpleado = selectedItem.getIdEmpleado();
                    mesas.setIdEmpleado(idEmpleado);
                }
                }
         });
    }
    
    @Override
    public void mouseClicked(MouseEvent e) { 
    if(e.getSource() == VISTA.btnListo)
    {
        if(VISTA.txtNombreCliente.getText().isEmpty() || VISTA.txtApellidosCliente.getText().isEmpty() || VISTA.txtCorreoCliente.getText().isEmpty() || VISTA.txtDUIcliente.getText().isEmpty())
        {
        JOptionPane.showMessageDialog(null, "Complete los campos.");    
        }
        else if (VISTA.txtNombreCliente.getText().matches(".*\\d.*") || VISTA.txtApellidosCliente.getText().matches(".*\\d.*"))
        {
        JOptionPane.showMessageDialog(null, "El nombre o apellido no puede contener números.");    
        }
        else if (!VISTA.txtCorreoCliente.getText().matches("[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+")) {
    
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
         String idCliente = UUID.randomUUID().toString();
            
         CLIENTES.setIdCliente(idCliente);
         CLIENTES.setNombreCliente(VISTA.txtNombreCliente.getText());
         CLIENTES.setApellidoCliente(VISTA.txtApellidosCliente.getText());
         CLIENTES.setCorreoCliente(VISTA.txtCorreoCliente.getText());
         CLIENTES.setDUIcliente(VISTA.txtDUIcliente.getText());
         
         MESAS.setIdMesa(MESAS.getIdMesa());
         MESAS.setEstadoMesa("Ocupada");
         MESAS.setIdCliente(idCliente);
         MESAS.setIdEmpleado(idEmpleado);
               

         if(CLIENTES.ExisteDUI() == true)
         {
           JOptionPane.showMessageDialog(null, "El número de DUI ya está registrado.");

         }
         else
         {
         CLIENTES.RegistrarCliente();
         MESAS.ReservarMesa();
            
         JOptionPane.showMessageDialog(null, "Se registró el cliente correctamente.");
         VISTA.dispose(); 
         }
         
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
