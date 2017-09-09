/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verificador;

import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.Plato;

/**
 *
 * @author 2114928
 */
public interface VerificadorIVA {
    public float obtenerPorcentaje(Plato p);
    public float obtenerPorcentajeBebida(Bebida b);
}
