/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jere
 */
public abstract class Objecte{
	private Posicio pos;
	
	public Posicio pos(){
		return pos;
	}
	public int idObj(){
		return id_obj;
		//si es tresor retorna -1, si es clau retorna el numero de la porta que obre	
	}
}

