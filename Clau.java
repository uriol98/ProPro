/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jere
 */
public class Clau {
    private int num_porta;
    private int pos;
   
    public Clau(){
        
    }
    public Clau(int num_porta,Posicio pos){
    //pre:
    //post:nova clau per la porta num_porta a la posicio pos
        this.num_porta = num_porta;
        this.pos = pos;
    }
    public int num(){
       return num_porta;
    }
     public Posicio pos(){
		return pos;
    }
}



