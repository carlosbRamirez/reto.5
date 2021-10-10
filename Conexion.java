package Modelo;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;






public class Conexion {
    
    public static Connection conexion;
    public static Connection crearConexion() {
        try{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica","root","carlos310212");
        System.out.println("conexion ok");
        
        }catch (SQLException ex){
            ex.printStackTrace();{
           System.out.println("sin conexion"+ex);   
}
        }
return conexion;
        }
      
public static void main(String[]args){
    crearConexion();
}
}
