package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.model.Orden;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;



public class CalculadorBasicoCuentas implements CalculadorCuenta {
    /**
     * @pre La orden no debe ser vacia y tampoco nula.
     * @pos Devuelve un valor positivo, puede ser cero.
     * @param o de tipo Orden 
     * @return El costo de la orden
     */
    public int calcularCosto(Orden o) {
        int total=0;
        for (ItemOrden p:o.getItemsOrden()){
            total+=p.getPrecio();
        }
        return total;
	}
}
