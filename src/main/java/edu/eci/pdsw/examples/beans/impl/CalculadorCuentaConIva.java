/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;
import com.google.inject.Inject;
import edu.eci.pdsw.model.Orden;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;
import verificador.VerificadorIVA;
/**
 *
 * @author 2114928
 */
public class CalculadorCuentaConIva implements CalculadorCuenta{
    /**
     * @pre La orden no debe ser vacia y tampoco nula, ademas se debe saber si es una bebida azucarada.
     * @pos Devuelve un valor positivo, puede ser cero, se tiene en cuenta el tipo de almiento que es, bien sea bebida o comida.
     * @param o de tipo Orden 
     * @return El costo de la orden con el valor completo
     */
    @Inject
    private VerificadorIVA   verIVA;
    @Override
    public int calcularCosto(Orden o){
        double total=0;
        for (ItemOrden p:o.getItemsOrden()){
            total+=p.getPrecio();}        
        return (int) total;
    }
}
