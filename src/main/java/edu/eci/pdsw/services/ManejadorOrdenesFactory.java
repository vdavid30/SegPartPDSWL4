package edu.eci.pdsw.services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import com.google.inject.AbstractModule;
import edu.eci.pdsw.examples.beans.*;
import edu.eci.pdsw.examples.beans.impl.*;
import edu.eci.pdsw.examples.services.ManejadorOrdenes;
import edu.eci.pdsw.view.SimpleApp;
import verificador.VerificadorIVA;
import verificador.impl.*;
/**
 *
 * @author hp
 */
public class ManejadorOrdenesFactory {
    private static ManejadorOrdenesFactory instance = new ManejadorOrdenesFactory();
    
    private static Injector injector;
    
    private ManejadorOrdenesFactory(){
        injector = createInjector(new AbstractModule() {

                    
                    protected void configure() {
                        bind(CalculadorCuenta.class).to(CalculadorCuentaConIva.class);
                        bind(VerificadorIVA.class).to(VerificadorIVARegimen2013.class);                      
                    }
                }
                
        );
    
    }
    public ManejadorOrdenes getManejador(){
        return injector.getInstance(ManejadorOrdenes.class);   
    }


    public static ManejadorOrdenesFactory getInstance(){
        return instance;
    }
}
