/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.view;

import edu.eci.pdsw.services.ManejadorOrdenesFactory;
import edu.eci.pdsw.examples.model.Bebida;
import edu.eci.pdsw.examples.model.ExcepcionManejadorOrdenes;
import edu.eci.pdsw.examples.model.Orden;
import edu.eci.pdsw.examples.model.Plato;
import edu.eci.pdsw.examples.services.*;

/**
 *
 * @author hcadavid
 */
public class SimpleApp {

    public static void main(String a[]) throws ExcepcionManejadorOrdenes {
        ManejadorOrdenes calcC = ManejadorOrdenesFactory.getInstance().getManejador();
        Orden o = new Orden();
        o.agregarItemOrden(new Plato("pizza", 7500));
        o.agregarItemOrden(new Bebida("pepsi 300ml", 3900,1000));
        o.agregarItemOrden(new Plato("hamburguesa", 8000));
        o.agregarItemOrden(new Bebida("sprite 300ml", 200,2000));
        System.out.println(calcC.calcularCosto(o));                 
    }
}
