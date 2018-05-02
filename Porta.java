/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 8/4/2018
 * @author oriol
 */
public class Porta {
    private int numPorta;
    private Cela cel;
    private char orientacio;
    private char estat;
    private Paret par;

    /**
*
* @pre
* @post
*/
    public Porta(){
        numPorta=0;
        estat='T';
    }
    
    
    
/**
*
* @pre
* @post
*/
    
    public Porta(Cela c, char o){
    
        cel=c;
        orientacio=o;
        estat='T';
    }
    
    /**
*
* @pre
* @post
*/
    public char Orientacio(){
    
        return orientacio;
    }
    
    
/**
*
* @pre
* @post
*/
    
   public void afegirOrientacio(char c){
       orientacio = c;
   }
   
   
   /**
*
* @pre
* @post
*/
   public void afegirCela(Cela c){
       
       cel=c;
   }
   
   /**
*
* @pre
* @post
*/
   public Cela Posicio(){
       
       return cel;
   }
   
   public void afegirID(int id){
       numPorta=id;
   }
   
   public void canviarEstat(char c){
   
       estat =c;
   }
   
   
   public boolean esPotPassar(){
       if(estat=='O') return true;
       else if (estat=='D') return true;
       else return false;
   }
   
   public void afegirParet(Paret p){
   
       par=p;
   }
}
