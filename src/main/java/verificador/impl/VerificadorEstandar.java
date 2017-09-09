/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador.impl;

import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.Plato;
import verificador.VerificadorIVA;

/**
 *
 * @author 2114928
 */
public class VerificadorEstandar implements VerificadorIVA{
    public float obtenerPorcentaje(Plato p){
        return 0.19f;
    }
    public float obtenerPorcentajeBebida(Bebida b){
        return 0.19f;
    }
}
