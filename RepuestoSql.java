
package Modelo;


import Vista.Vista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;







public class RepuestoSql extends Vista{
   
    Vista vista;
   public static Conexion conexin= new Conexion();
   public static Connection acceso = conexin.crearConexion();
   public static Repuesto repuesto= new Repuesto();
    public static boolean Insertar(Repuesto repuesto) {
       try{
           String sql= "INSERT INTO repuesto1(rep_nombre,rep_precio,rep_descripcion,rep_fecha_importacion) values(?,?,?,?)";
           PreparedStatement statement= acceso.prepareStatement(sql);
           //statement.setString(1,repuesto.getRep_id());
           statement.setString(1,repuesto.getRep_nombre());
           statement.setString(2,repuesto.getRep_precio());
           statement.setString(3,repuesto.getRep_descripcion());
           statement.setString(4,repuesto.getRep_fecha_importacion());
           int rowsInserted = statement.executeUpdate();
           if (rowsInserted>0){
               System.out.println("Registro exitoso");
           }
           return true;
       }catch(SQLException e){
           System.out.println(e.getMessage());
           return false;
       }
       }
    public static boolean Eliminar (Repuesto repuesto) {
        try{
            String sql="DELETE FROM repuesto1 where rep_id=?";
            PreparedStatement statement= acceso.prepareStatement(sql);
            //statement.setInt(1,repuesto.getRep_id());
            statement.setInt(1,repuesto.getRep_id());
            int rowsDeleted= statement.executeUpdate();
            if (rowsDeleted>0)
                System.out.println("Eliminacion exitosa");
        
        return true;
        }catch (SQLException e){
        System.out.println(e.getMessage());
        return false;
}
    }
 

     public static boolean Actualizar (Repuesto repuesto) {
        try{
            String sql="UPDATE repuesto1 SET rep_nombre=?, rep_precio=?, rep_descripcion=?, rep_fecha_importacion=? WHERE rep_id=?";
            PreparedStatement statement= acceso.prepareStatement(sql);
            statement.setString(1,repuesto.getRep_nombre());
            statement.setString(2,repuesto.getRep_precio());
            statement.setString(3,repuesto.getRep_descripcion());
            statement.setString(4,repuesto.getRep_fecha_importacion());
            statement.setInt(5,repuesto.getRep_id());
            int rowsUpdated= statement.executeUpdate();
            if (rowsUpdated>0)
                System.out.println("Actualizacion exitosa");
        
        return true;
        }catch (SQLException e){
        System.out.println(e.getMessage());
        return false;
}
    }
     
     
     public static void main(String []args){
  
   
     
    }
}


 
