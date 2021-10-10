
package controlador;

import Modelo.Repuesto;
import Modelo.RepuestoSql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Vista;





public class Controlador extends Vista implements ActionListener {
     
     Object[] file=new Object[5];
    
    private Vista vistaRepuesto= new Vista();
    private RepuestoSql repuestoSql= new RepuestoSql();
    private Repuesto repuesto= new Repuesto();
    
    
    public Controlador (Vista vistaRepuesto, Repuesto repuesto, RepuestoSql repuestoSql){
     this.repuesto=repuesto;
     this.repuestoSql=repuestoSql;
     this.vistaRepuesto=vistaRepuesto;
     
     this.vistaRepuesto.botonAgregar.addActionListener(this);
     this.vistaRepuesto.botonActualizar.addActionListener(this);
     this.vistaRepuesto.botonEliminar.addActionListener(this);
     this.vistaRepuesto.botonMostrar.addActionListener(this);
     this.vistaRepuesto.botonCancelar.addActionListener(this);
    
    }
    


    @Override
    public void actionPerformed(ActionEvent elBoton){
 
    if (elBoton.getSource()==vistaRepuesto.botonCancelar){
         
          vistaRepuesto.limpiar();
    
          }
        
    if(elBoton.getSource()==vistaRepuesto.botonAgregar){
        
        repuesto.setRep_nombre(vistaRepuesto.texto2.getText());
        repuesto.setRep_precio(vistaRepuesto.texto3.getText());
        repuesto.setRep_descripcion(vistaRepuesto.texto4.getText());
        repuesto.setRep_fecha_importacion(vistaRepuesto.texto5.getText());
     
        boolean registro=repuestoSql.Insertar(repuesto);
        vistaRepuesto.otrasFilas();
        file[1]=(vistaRepuesto.texto2.getText());
        file[2]=(vistaRepuesto.texto3.getText());
        file[3]=(vistaRepuesto.texto4.getText());
        file[4]=(vistaRepuesto.texto5.getText()); 
        vistaRepuesto.limpiar();
       
       }
       if (elBoton.getSource()==vistaRepuesto.botonEliminar){
        
        int rep_id=(vistaRepuesto.texto1.getText().isEmpty())?0: Integer.parseInt(vistaRepuesto.texto1.getText());
        
        repuesto.setRep_id(rep_id);
    
         
        boolean registro=repuestoSql.Eliminar(repuesto);
        vistaRepuesto.otrasFilas();
        vistaRepuesto.limpiar();
  
    }
    if (elBoton.getSource()==vistaRepuesto.botonActualizar){
    int rep_id=(vistaRepuesto.texto1.getText().isEmpty())?0: Integer.parseInt(vistaRepuesto.texto1.getText());
    repuesto.setRep_id(rep_id);
    repuesto.setRep_nombre(vistaRepuesto.texto2.getText());
    repuesto.setRep_precio(vistaRepuesto.texto3.getText());
    repuesto.setRep_descripcion(vistaRepuesto.texto4.getText());
    repuesto.setRep_fecha_importacion(vistaRepuesto.texto5.getText());
    boolean registro=repuestoSql.Actualizar(repuesto);
    int id=Integer.parseInt(vistaRepuesto.texto1.getText());
    vistaRepuesto.otrasFilas();
    vistaRepuesto.limpiar();
   
    
    }
   
     if (elBoton.getSource()==vistaRepuesto.botonMostrar){
    
           vistaRepuesto.texto1.setText(vistaRepuesto.Tabla.getModel().getValueAt(vistaRepuesto.Tabla.getSelectedRow(), 0).toString());
           vistaRepuesto.texto2.setText(vistaRepuesto.Tabla.getModel().getValueAt(vistaRepuesto.Tabla.getSelectedRow(), 1).toString());
           vistaRepuesto.texto3.setText(vistaRepuesto.Tabla.getModel().getValueAt(vistaRepuesto.Tabla.getSelectedRow(), 2).toString());
           vistaRepuesto.texto4.setText(vistaRepuesto.Tabla.getModel().getValueAt(vistaRepuesto.Tabla.getSelectedRow(), 3).toString());
           vistaRepuesto.texto5.setText(vistaRepuesto.Tabla.getModel().getValueAt(vistaRepuesto.Tabla.getSelectedRow(), 4).toString());
       
        
          vistaRepuesto.botonAgregar.setEnabled(false);
          vistaRepuesto.botonEliminar.setEnabled(true);
          vistaRepuesto.botonActualizar.setEnabled(true); 
          }   
       
          }
          }


