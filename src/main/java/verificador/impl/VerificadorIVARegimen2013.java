/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador.impl;
import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.ItemOrden;
import edu.eci.pdsw.examples.model.Plato;
import verificador.VerificadorIVA;

/**
 *
 * @author 2114928
 */
public class VerificadorIVARegimen2013 implements VerificadorIVA{
    public float obtenerPorcentaje(Plato p){               
        return 0.19f;
    }
    
    public float obtenerPorcentajeBebida(Bebida b){
        if(b.getCalorias()>1000){            
            return 0.29f;
        }
        else{
            return 0.19f;
        }
    }
}
