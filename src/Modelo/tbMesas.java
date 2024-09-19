package Modelo;

import Vista.pnlRegistrarClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

public class tbMesas{
    private int idMesa;
    private String EstadoMesa;
    private String idCliente;
    private String idEmpleado;

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

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
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
    
    public void EstadoMesa(pnlRegistrarClientes vista) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = claseConexion.getCon();

        try {
            PreparedStatement revisarEstado = conexion.prepareStatement("SELECT idMesa FROM MESA WHERE EstadoMesa = ?");
            revisarEstado.setString(1, "Ocupada");
            ResultSet rs = revisarEstado.executeQuery();
            
        while (rs.next()) {
        String idMesa = rs.getString("idMesa");
    
        switch (idMesa) {
        case "1":
            vista.Mesa1.disable();
            break;
        case "2":
            vista.Mesa2.disable();
            break;
        case "3":
            vista.Mesa3.disable();
            break;
        case "4":
            vista.Mesa4.disable();
            break;
        case "5":
            vista.Mesa5.disable();
            break;
        case "6":
            vista.Mesa6.disable();
            break;
        case "7":
            vista.Mesa7.disable();
            break;
        case "8":
            vista.Mesa8.disable();
            break;
        case "9":
            vista.Mesa9.disable();
            break;
        case "10":
            vista.Mesa10.disable();
            break;
        case "11":
            vista.Mesa11.disable();
            break;
        case "12":
            vista.Mesa12.disable();
            break;
        default:
            break;
                 }
        }

            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
    public void ReservarMesa()
    {
        Connection conexion = claseConexion.getCon();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement nuevaMesa = conexion.prepareStatement("INSERT INTO Mesa(idMesa,EstadoMesa,idCliente,idEmpleado) VALUES(?,?,?,?)");
            //Establecer valores de la consulta SQL
            nuevaMesa.setInt(1,getIdMesa());
            nuevaMesa.setString(2,getEstadoMesa());
            nuevaMesa.setString(3,getIdCliente());
            nuevaMesa.setString(4,getIdEmpleado());//Mesero encargado.
            //Ejecutar la consulta
            nuevaMesa.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
    }
}
