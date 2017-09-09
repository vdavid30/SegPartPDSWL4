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
import edu.eci.pdsw.examples.model.*;
import java.util.ArrayList;
/**
 *
 * @author hcadavid
 */
@ManagedBean(name ="ordersManagedBean" )
public class OrdersManagedBean {
    public List<Orden> ordenes;
    public Orden ordenF;
    public int nItems;
    public OrdersManagedBean(){
        ordenes = new ArrayList<Orden>();
        ordenF = new Orden();
        ordenF.agregarItemOrden(new Plato("pizza", 7500));
        Orden ordenA = new Orden();
        ordenA.agregarItemOrden(new Bebida("pepsi 300ml", 3900,1000));
        ordenA.agregarItemOrden(new Plato("hamburguesa", 8000));
        ordenA.agregarItemOrden(new Bebida("sprite 300ml", 200,2000));
        ordenes.add(ordenF);
        ordenes.add(ordenA);
        nItems = (ordenF.getItemsOrden()).size();
    }
    public void crearOrden(){      
        ordenes.add(new Orden());
    }
    public List<Orden> getOrdenes(){
        return ordenes;
    }
    public int getNItems(){
        return nItems;
    }
    
    
}
