/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.examples.beans.impl;

import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.beans.CalculadorCuenta;
import edu.eci.pdsw.examples.model.ItemOrden;

/**
 *
 * @author 2114928
 */
public class CalculadorCuentaConPropina implements CalculadorCuenta{/**
     * @pre La orden no debe ser vacia y tampoco nula, ademas su valor debe superar los $15.000
     * @pos Devuelve un valor positivo, puede ser cero con el 10% de propina agregado
     * @param o de tipo Orden 
     * @return El costo de la orden
     */
    public int calcularCosto(Orden o){
        double total=0;
        for (ItemOrden p:o.getItemsOrden()){
            total+=p.getPrecio();}    
        if (total>15000){
            total=total*1.1;
        }    
    return (int) total;
    }
}
