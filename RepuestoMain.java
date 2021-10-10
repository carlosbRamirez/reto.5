
package repuestoMain;

import Modelo.Repuesto;
import Modelo.RepuestoSql;
import Vista.Vista;
import controlador.Controlador;


public class RepuestoMain  {
    
    public static void main(String []args){
        Vista vistaDB= new Vista();
        RepuestoSql modeloDb= new RepuestoSql();
        Repuesto rep= new Repuesto();
         new Controlador(vistaDB,rep,modeloDb);
        vistaDB.setVisible(true);
    }
}
