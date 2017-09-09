package edu.eci.pdsw.examples.services;

import java.util.LinkedList;
import java.util.List;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import edu.eci.pdsw.examples.beans.*;
import edu.eci.pdsw.examples.beans.impl.*;
import edu.eci.pdsw.examples.model.*;


public class ManejadorOrdenes implements CalculadorCuenta{

        @Inject
        private CalculadorCuenta calCuenta;
	
	List<Orden> ordenes;

                
	public ManejadorOrdenes(){
		ordenes=new LinkedList<>();
	}

        
                      
        public List<Orden> getOrdenes() {
            return ordenes;
        }
	
	public void registrarOrden(Orden o){
		ordenes.add(o);
	}
        
	public Orden consultarOrden(int n) throws ExcepcionManejadorOrdenes{
		if (n>=ordenes.size()) throw new ExcepcionManejadorOrdenes("Orden inexistente:");
		return ordenes.get(n);
	}
	
	public int calcularTotalOrden(int n) throws ExcepcionManejadorOrdenes{
		if (n>=ordenes.size()) throw new ExcepcionManejadorOrdenes("Orden inexistente:");
		return calCuenta.calcularCosto(ordenes.get(n));		
	}
	
        public int calcularCosto(Orden o){
            return calCuenta.calcularCosto(o);
        }
}
