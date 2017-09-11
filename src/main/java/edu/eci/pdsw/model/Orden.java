package edu.eci.pdsw.model;

import edu.eci.pdsw.examples.model.ItemOrden;
import java.util.LinkedList;
import java.util.List;

public class Orden {

	List<ItemOrden> itemsOrden;
        int a;

	public Orden() {
		itemsOrden=new LinkedList<>();
                a=0;
	}
	
	public void agregarItemOrden(ItemOrden p){
		itemsOrden.add(p);
	}
	
	public List<ItemOrden> getItemsOrden(){
		return itemsOrden;
	}
	
        @Override
	public String toString(){
		return itemsOrden.toString();
	}
	
}
