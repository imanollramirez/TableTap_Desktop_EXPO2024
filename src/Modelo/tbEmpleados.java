package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;

public class tbEmpleados {

    private String idEmpleado;
    private String NombreEmpleado;
    
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return NombreEmpleado;
    }

    public void setNombreEmpleado(String NombreEmpleado) {
        this.NombreEmpleado = NombreEmpleado;
    }
    
    public tbEmpleados()
    {
        
    }
    
    public tbEmpleados(String idEmpleado,String NombreEmpleado)
    {
        this.idEmpleado = idEmpleado;
        this.NombreEmpleado = NombreEmpleado;
    }
    
    @Override
    public String toString()
    {
        return NombreEmpleado;
    }
    
    public void CargarMeseros(JComboBox cb)
    {
        try
        {
          String idCargoEmpleado = "";
          Connection conexion = claseConexion.getCon();
          PreparedStatement cargo = conexion.prepareStatement("SELECT * FROM CargoEmpleado WHERE CargoEmpleado = ?");
          cargo.setString(1, "Mesero");
          ResultSet rs = cargo.executeQuery();
          
          if(rs.next())
          {
              idCargoEmpleado = rs.getString("idCargoEmpleado");
          }
          
          PreparedStatement meseros = conexion.prepareStatement("SELECT * FROM Empleado WHERE idCargoEmpleado = ?");
          meseros.setString(1, idCargoEmpleado);
          ResultSet res = meseros.executeQuery();
          
          while(res.next())
          {
              String nombreMeseros = res.getString("NombreEmpleado");
              String idMeseros = res.getString("idEmpleado");
              cb.addItem(new tbEmpleados(idMeseros,nombreMeseros));
          }
          
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }
      
}
