/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.webappsintro.controller;

import edu.eci.pdsw.model.Orden;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import edu.eci.pdsw.*;
import edu.eci.pdsw.examples.beans.impl.CalculadorBasicoCuentas;
import edu.eci.pdsw.examples.model.*;
import edu.eci.pdsw.examples.services.ManejadorOrdenes;
import edu.eci.pdsw.services.ManejadorOrdenesFactory;
import java.util.ArrayList;
import java.util.Set;
/**
 *
 * @author hcadavid
 */
@ManagedBean(name ="ordersManagedBean" )
@SessionScoped

public class OrdersManagedBean {
   
    public List<Orden> ordenes;
    public Orden ordenF= new Orden();
    public int nItems;
    public List<ItemOrden> items;
    public  Orden ordenA = new Orden();
    public Orden orden;   
    public CalculadorBasicoCuentas calc;
    public ItemOrden it = new ItemOrden();
    public ManejadorOrdenes calcC;
    public String seleccion;
    public String nombre;
    public int precio;
    
    public OrdersManagedBean(){       
        seleccion = "AAAA";
        calcC = ManejadorOrdenesFactory.getInstance().getManejador();
        calc= new CalculadorBasicoCuentas();
        ordenes = new ArrayList<Orden>();
        ordenes = calcC.getOrdenes();
        ordenF.agregarItemOrden(new Plato("Pizza", 7500));       
        ordenA.agregarItemOrden(new Bebida("Pepsi 300ml", 3900,1000));
        ordenA.agregarItemOrden(new Plato("Hamburguesa", 8000));
        ordenA.agregarItemOrden(new Bebida("Sprite 300ml", 200,2000));
        ordenA.setNumero(19);
        calcC.registrarOrden(ordenF);
        calcC.registrarOrden(ordenA);        
        nItems = (ordenF.getItemsOrden()).size();
        
        
        
    }
    public void crearOrden(){
        calcC.registrarOrden(new Orden());
    }
    public List<Orden> getOrdenes(){
        return calcC.getOrdenes();
    }
    public String getNombre(){
        return nombre;
    }
    public String getSeleccion(){
        return seleccion;
    }
    public int getPrecio(){
        return precio;
    }
    public void setNombre(String s){
        this.nombre=s;
    }
    public void setSeleccion(String seleccion){
        this.seleccion=seleccion;
    }
    public void setPrecio(int n){
        this.precio=n;
    }
    public int getNItems(){
        return nItems;
    }
    
     public void setA(Orden num){
        this.orden=num;
    }
    
    public Orden getOrden(int n) throws ExcepcionManejadorOrdenes{
        return calcC.consultarOrden(n);
    }
    
    public List<ItemOrden> getItems(){
        items=ordenA.getItemsOrden();
        return items;
    }
    
    public int getValorOrden (){
        return calc.calcularCosto(ordenA);
    }
    
    public void setItemNombre(String nom){
        it.setNombre(nom);
    }
    
    public void setItemPrecio(int pre){
        it.setPrecio(pre);
    }
    
    public void añadirItem(){
        if(this.seleccion.contains("Bebida")){
            it = new Bebida(nombre,precio,0);
        }else if(this.seleccion.contains("Plato")){
            it = new Plato(nombre,precio);
        }    
        ordenA.agregarItemOrden(it);
    }
    public void seleccionarOrdenA(){
        items=ordenA.getItemsOrden();
        actualizarPrecio();
    }
    public void actualizarPrecio(){
        precio = calc.calcularCosto(ordenA);
    }
    public void setOrdenA(Orden o){
        ordenA=o;
    }
    public void setOrdenA(int nOrden){
        ordenA = ordenes.get(nOrden);
    }
    
    public Orden getOrdenA(){
        return ordenA;
    }    
}
