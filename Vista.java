
package Vista;



import static Modelo.RepuestoSql.acceso;
import static Modelo.RepuestoSql.conexin;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Vista extends JFrame {
  
    public static Connection acceso = conexin.crearConexion();
    public JTable Tabla;
    public DefaultTableModel model;
    Object[] filas=new Object[5];
    public JPanel panel;
    public JButton botonAgregar, botonActualizar,botonEliminar,botonMostrar,botonCancelar;
    public JTextField texto1,texto2,texto3,texto4,texto5;
  
    
    public Vista(){
        setSize(700,550);//tamano de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inventario de repuestos");
        setLocationRelativeTo(null);
        this.paneles();
        this.etiquetas();   
        this.botones();
        this.tabla();

    }
    public void paneles(){
        
        panel= new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
        panel.setBackground(Color.DARK_GRAY);
    }
    public void etiquetas(){
        JLabel etiqueta = new JLabel("Repuesto ID:");
        JLabel etiqueta1 = new JLabel("Nombre repuesto:");
        JLabel etiqueta2 = new JLabel("Precio repuesto:");
        JLabel etiqueta3 = new JLabel("Decripcion repuesto:");
        JLabel etiqueta4 = new JLabel("Fecha importacion repuesto:");
        JLabel etiqueta5 = new JLabel("¿Que desea hacer?");
        JLabel etiqueta6 = new JLabel("TABLA DE REPUESTOS");
        etiqueta.setForeground(Color.WHITE);
        etiqueta1.setForeground(Color.WHITE);
        etiqueta2.setForeground(Color.WHITE);
        etiqueta3.setForeground(Color.WHITE);
        etiqueta4.setForeground(Color.WHITE);
        etiqueta5.setForeground(Color.WHITE);
        etiqueta6.setForeground(Color.WHITE);
        etiqueta.setBounds(20,40,110,30);
        etiqueta1.setBounds(20,80,150,30);
        etiqueta2.setBounds(20,120,110,30);
        etiqueta3.setBounds(20,160,150,30);
        etiqueta4.setBounds(20,200,300,30);
        etiqueta5.setBounds(470,10,300,30);
        etiqueta6.setBounds(260,240,300,30);
        panel.add(etiqueta);
        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(etiqueta3);
        panel.add(etiqueta4);
        panel.add(etiqueta5);
        panel.add(etiqueta6);
    
}    
   public void botones(){
       
     
       botonAgregar=new JButton("Agregar");
       botonActualizar=new JButton("Actualizar");
       botonEliminar=new JButton("Eliminar");
       botonMostrar=new JButton("Mostrar");
       botonCancelar=new JButton("Cancelar");
       botonAgregar.setBounds(470, 45, 120, 20);
       botonActualizar.setBounds(470, 90, 120, 20);
       botonEliminar.setBounds(470, 135, 120, 20);
       botonMostrar.setBounds(470, 180, 120, 20);
       botonCancelar.setBounds(470,225,120,20);
      
       
       
    
       panel.add(botonAgregar);
       panel.add(botonActualizar);
       panel.add(botonEliminar);
       panel.add(botonMostrar);
       panel.add(botonCancelar);
    
   
   
   
       
       texto1= new JTextField();
        texto2= new JTextField();
        texto3= new JTextField();
        texto4= new JTextField();
        texto5= new JTextField();
       
        
       texto1.setBounds(210,40,180,20);
       texto1.setEnabled(false);
       texto2.setBounds(210,80,180,20);
       texto3.setBounds(210,120,180,20);
       texto4.setBounds(210,160,180,20);
       texto5.setBounds(210,200,180,20);
       panel.add(texto1);
       panel.add(texto2);
       panel.add(texto3);
       panel.add(texto4);
       panel.add(texto5);
  
   }
   
     public void tabla(){
         
         String[] columnas={"rep id","rep_nombre","rep_precio","rep_descripcion","rep_fecha_importacion"};
          model= new DefaultTableModel(null,columnas);
         Tabla=new JTable(model);
         JScrollPane scroll=new JScrollPane(Tabla);
         scroll.setBounds(40,40,400,200);
         panel.add(scroll);
             try{
            Statement sentencia= acceso.createStatement();
            ResultSet datos= sentencia.executeQuery("SELECT * FROM repuesto1");
            while(datos.next()){
            filas[0]=datos.getInt(1);
            filas[1]=datos.getString(2);
            filas[2]=datos.getString(3);
            filas[3]=datos.getString(4);
            filas[4]=datos.getString(5);
            model.addRow(filas);
            
            }
            }
          catch (Exception e){
            e.printStackTrace();
            }

    scroll.setBounds(40,280,180,20);
    scroll.setSize(600,220);
    
}
     public void otrasFilas(){
            try{
            model.getDataVector().removeAllElements();
            Statement sentencia= acceso.createStatement();
            ResultSet datos= sentencia.executeQuery("SELECT * FROM repuesto1");
            while(datos.next()){
            filas[0]=datos.getInt(1);
            filas[1]=datos.getString(2);
            filas[2]=datos.getString(3);
            filas[3]=datos.getString(4);
            filas[4]=datos.getString(5);
            
            model.addRow(filas);
            
            }
            }
          catch (Exception e){
            e.printStackTrace();
            }
         
     }

         public void limpiar(){
        texto1.setText("");
       texto2.setText("");
       texto3.setText("");
        texto4.setText("");
        texto5.setText("");
        botonAgregar.setEnabled(true);
        botonEliminar.setEnabled(false);
        botonActualizar.setEnabled(false);
        botonMostrar.setEnabled(true);
        botonCancelar.setEnabled(true);
         }
    public void filas(Object[] files){
 
        model.addRow(files);
        
        
    }
    
    public void remover(int i){
        model.removeRow(i);
    }
public static void main(String []args){
   Vista ventana=new Vista();
  
   ventana.setVisible(true);
    
}

    
   }
