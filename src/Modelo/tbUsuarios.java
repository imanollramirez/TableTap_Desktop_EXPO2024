package Modelo;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.NoSuchAlgorithmException;


public class tbUsuarios {

    private String idUsuario;
    private String NombreUsuario;
    private String ContrasenaUsuario;
    
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContrasenaUsuario() {
        return ContrasenaUsuario;
    }

    public void setContrasenaUsuario(String ContrasenaUsuario) {
        this.ContrasenaUsuario = ContrasenaUsuario;
    }
    
    public String ContrasenaEncriptada(String Contrasena) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(Contrasena.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }
    }
    
    public boolean IniciarSesion()
    {
        try
        {         
          Connection conexion = claseConexion.getCon();          
                    
          PreparedStatement Login = conexion.prepareStatement("SELECT * FROM Usuario WHERE NombreUsuario = ? AND ContrasenaUsuario = ?");
          Login.setString(1, getNombreUsuario());
          Login.setString(2, getContrasenaUsuario());
          ResultSet rs = Login.executeQuery();
          
          if(rs.next())
          {
              return true;
          }
          else
          {
              return false;
          }          
         
          
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
        return false;

    }
    
    /*El try-with-resources:  es una estructura en Java que facilita el manejo automático de recursos como conexiones a bases de datos, archivos, PreparedStatement, ResultSet, etc. 
    Los recursos que se abren dentro de un bloque try-with-resources se cierran automáticamente cuando el bloque finaliza, ya sea que haya una excepción o no. Esto evita que tengas que
    cerrar los recursos manualmente, reduciendo el riesgo de fugas de memoria o conexiones no cerradas.*/
    
    //EL try-with-resources es la solución, tuve que buscar como solucionarlo porque tenia que verificar el cargo, pero al parecer de la manera que lo hacia no funcionaba,
    //porque no estaba manejando bien las conexiones.
    //Es como un Couroutine en Android, por cada query debe haber un try catch. (aunque sin el catch), el principal si es try-catch.
    public boolean RevisarCargo() {
    try (Connection conexion = claseConexion.getCon()) {
        PreparedStatement idUsuario = conexion.prepareStatement("SELECT * FROM Usuario WHERE NombreUsuario = ? AND ContrasenaUsuario = ?");
        idUsuario.setString(1, getNombreUsuario());
        idUsuario.setString(2, getContrasenaUsuario());
        try (ResultSet rs = idUsuario.executeQuery()) {
            if (rs.next()) {
                String idU = rs.getString("idUsuario");

                PreparedStatement cargoEm = conexion.prepareStatement("SELECT * FROM Empleado WHERE idUsuario = ?");
                cargoEm.setString(1, idU);
                try (ResultSet res = cargoEm.executeQuery()) {
                    if (res.next()) {
                        String Cargo = res.getString("idCargoEmpleado");

                        PreparedStatement cargo_em = conexion.prepareStatement("SELECT * FROM CargoEmpleado WHERE idCargoEmpleado = ?");
                        cargo_em.setString(1, Cargo);
                        try (ResultSet result = cargo_em.executeQuery()) {
                            if (result.next()) {
                                String Cargo_Empleado = result.getString("CargoEmpleado");

                                switch (Cargo_Empleado) {
                                    case "Gerente":
                                    case "Recepcionista":
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        }
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();  // Logs exception for debugging
    }
    return false;
}


}
