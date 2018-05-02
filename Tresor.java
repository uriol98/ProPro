/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jere
 */
public class Tresor {
    private int valor;
    private Posicio pos;
    
    public Tresor(){
        
    }
    public Tresor(int valor, Posicio pos){
        this.valor = valor;
        this.pos = pos;
    }
    public Posicio pos(){
	return pos;
    }
}
