package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;

public class tbMesas {
    private int idMesa;
    private String EstadoMesa;
    private int idCliente;
    private int idEmpleado;

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getEstadoMesa() {
        return EstadoMesa;
    }

    public void setEstadoMesa(String EstadoMesa) {
        this.EstadoMesa = EstadoMesa;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    
    public void EliminarMesa(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseConexion.getCon();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String idCliente = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement eliminarMesa = conexion.prepareStatement("DELETE FROM Mesa WHERE idCliente = ?");
            eliminarMesa.setString(1, idCliente);
            eliminarMesa.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
