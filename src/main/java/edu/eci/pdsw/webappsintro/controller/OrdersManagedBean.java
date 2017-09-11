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
    public CalculadorBasicoCuentas calc= new CalculadorBasicoCuentas();
    public ItemOrden it= new ItemOrden();
    
    public OrdersManagedBean(){
        ordenes = new ArrayList<Orden>();        
        ordenF.agregarItemOrden(new Plato("pizza", 7500));       
        ordenA.agregarItemOrden(new Bebida("pepsi 300ml", 3900,1000));
        ordenA.agregarItemOrden(new Plato("hamburguesa", 8000));
        ordenA.agregarItemOrden(new Bebida("sprite 300ml", 200,2000));
        ordenes.add(ordenF);
        ordenes.add(ordenA);
        nItems = (ordenF.getItemsOrden()).size();
        it.setNombre("prueba");
        it.setPrecio(1);
        
        
    }
    public void crearOrden(){
        System.out.println("Se agrego una Orden");
        ordenes.add(new Orden());
    }
    public List<Orden> getOrdenes(){
        return ordenes;
    }
    public int getNItems(){
        return nItems;
    }
    
     public void setA(Orden num){
        this.orden=num;
    }
    
    public Orden getOrden(){
        return orden;
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
        ordenA.agregarItemOrden(it);
    }
    
    
}
