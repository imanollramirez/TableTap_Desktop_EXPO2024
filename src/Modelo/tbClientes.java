package Modelo;

import Vista.pnlClientesRegistrados;
import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class tbClientes {

    private int idCliente;
    private String NombreCliente;
    private String ApellidoCliente;
    private String CorreoCliente;
    private String DUIcliente;
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }

    public void setNombreCliente(String NombreCliente) {
        this.NombreCliente = NombreCliente;
    }

    public String getApellidoCliente() {
        return ApellidoCliente;
    }

    public void setApellidoCliente(String ApellidoCliente) {
        this.ApellidoCliente = ApellidoCliente;
    }

    public String getCorreoCliente() {
        return CorreoCliente;
    }

    public void setCorreoCliente(String CorreoCliente) {
        this.CorreoCliente = CorreoCliente;
    }

    public String getDUIcliente() {
        return DUIcliente;
    }

    public void setDUIcliente(String DUIcliente) {
        this.DUIcliente = DUIcliente;
    }
    
    public void MostrarClientes(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = claseConexion.getCon();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();

        modeloDeDatos.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Apellidos", "Correo", "DUI"});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM Cliente");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("idCliente"), 
                    rs.getString("NombreCliente"), 
                    rs.getString("ApellidoCliente"), 
                    rs.getString("CorreoCliente"),
                    rs.getString("DUIcliente")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void cargarDatosTabla(pnlClientesRegistrados View) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = View.jtbClientesRegistrados.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String idCliente = View.jtbClientesRegistrados.getValueAt(filaSeleccionada, 0).toString();
            String nombre = View.jtbClientesRegistrados.getValueAt(filaSeleccionada, 1).toString();
            String apellidos = View.jtbClientesRegistrados.getValueAt(filaSeleccionada, 2).toString();
            String correo = View.jtbClientesRegistrados.getValueAt(filaSeleccionada, 3).toString();
            String DUI = View.jtbClientesRegistrados.getValueAt(filaSeleccionada, 4).toString();

            // Establece los valores en los campos de texto
            View.txtNombreCliente.setText(idCliente);
            View.txtApellidosCliente.setText(nombre);
            View.txtCorreoCliente.setText(apellidos);
            View.txtDUIcliente.setText(correo);
            View.txtDUIcliente.setText(DUI);   
        }
    }
    
    public void RegistrarCliente() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseConexion.getCon();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement nuevoCliente = conexion.prepareStatement("INSERT INTO Cliente (idCliente,NombreCliente,ApellidoCliente,CorreoCliente,DUIcliente) VALUES(?,?,?,?,?)");
            //Establecer valores de la consulta SQL
            nuevoCliente.setString(1,UUID.randomUUID().toString());
            nuevoCliente.setString(2, getNombreCliente());
            nuevoCliente.setString(3, getApellidoCliente());
            nuevoCliente.setString(4, getCorreoCliente());
            nuevoCliente.setString(5, getDUIcliente());
            //Ejecutar la consulta
            nuevoCliente.executeUpdate();
            conexion.commit();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
    
    public void ActualizarCliente(JTable tabla) {
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String ID = tabla.getValueAt(filaSeleccionada, 0).toString();
        
            
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseConexion.getCon();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement actuCliente = conexion.prepareStatement("UPDATE Cliente SET NombreCliente = ?, ApellidoCliente = ?, CorreoCliente = ?, DUIcliente = ? WHERE idCliente = ?");
            //Establecer valores de la consulta SQL
            actuCliente.setString(1,UUID.randomUUID().toString());
            actuCliente.setString(2, getNombreCliente());
            actuCliente.setString(3, getApellidoCliente());
            actuCliente.setString(4, getCorreoCliente());
            actuCliente.setString(5, ID);
            //Ejecutar la consulta
            actuCliente.executeUpdate();
            conexion.commit();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
    
    public void EliminarCliente(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseConexion.getCon();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String idCliente = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement eliminarCLiente = conexion.prepareStatement("DELETE FROM Cliente WHERE idCliente = ?");
            eliminarCLiente.setString(1, idCliente);
            eliminarCLiente.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
    
    
