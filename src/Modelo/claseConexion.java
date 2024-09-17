package Modelo;

import java.sql.*;


public class claseConexion {
    private static final String URL = "jdbc:oracle:thin:@192.168.1.10:1521:xe";
    private static final String USUARIO = "system";
    private static final String CONTRASENA = "godislove";

    //Creación del metodo de conexión que retorna la conexión
    public static Connection getCon() {
        try {
            // Cargar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Obtener la conexión en una variable
            Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);            
            // Retornamos la variable que tiene la conexión
            return con;
        } catch (SQLException e) {
            System.out.println("Este es el error" + e);
              return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("este es el error de la clase" + ex);
              return null;
        }
    }
}
