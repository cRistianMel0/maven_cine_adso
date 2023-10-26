/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author crife
 */
public class Conexion {
    
    Connection conectar = null;
    
    String USUARIO = "root";
    String DB = "maven_cine";
    String CONTRASENA = "";
    String IP = "localhost";
    String PUERTO = "3306";
            
    String cadena = "jdbc:mysql://"+IP+":"+PUERTO+"/"+DB;
    
    public Connection establecerConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, USUARIO, CONTRASENA);
            JOptionPane.showMessageDialog(null, "La conexion se ha realizado correctamente!!!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos, error: "+ e.toString());
        }
        
        return conectar;
    }
}
