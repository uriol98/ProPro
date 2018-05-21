/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
    @class Porta
    @brief 
    @author Oriol Canet
 */
public class Porta {
    private int numPorta; ///< identificador de porta
    private Cela cel; ///< cela on es troba la porta
    private char orientacio; ///< orientacio de la porta
    private char estat; ///< estat en que es troba la porta
    private Paret par; ///< paret on es situa la porta

    /**
     @brief Crea una porta tancada
     @pre cert
     @post S'ha creat una porta tancada i amb identificador de porta=0
     */
    public Porta(){
        numPorta=0;
        orientacio='N';
        estat='T';
    }
    
    
    
/**
     @brief Es crea una porta en una cela orientada
     @pre (\p c existeix) i ((\p o=='N') o (\p o=='S') o (\p o=='E') o (\p o=='W'))
     @post S'ha creat la porta a la cela \p c amb orientacio \p o
     */  
    public Porta(Cela c, char o){
    
        cel=c;
        orientacio=o;
        estat='T';
    }
    
    /**
     @brief diu quina és l'orientacio de la porta
     @pre 
     @post Retorna l'orientacio de la porta
     */
    public char Orientacio(){
    
        return orientacio;
    }
    
    
/**
     @brief Canvia la orientacio de la porta
     @pre  cert
     @post La orientacio de la porta passa a ser \p c
     */
   public void afegirOrientacio(char c){
       orientacio = c;
   }
   
   
   /**
     @brief Afegeix una cela
     @pre  \p c existeix
     @post S'ha afegit \p c a la porta
     */
   public void afegirCela(Cela c){
       
       cel=c;
   }
   
/**
     @brief diu a quina cela esta la porta
     @pre cert
     @post Retorna la cela on es troba la porta
     */
   public Cela Posicio(){
       
       return cel;
   }
   
   /**
     @brief Afegeix un identificador
     @pre \p id > 0
     @post S'afegeix l'identificador \p i a la porta
     */
   public void afegirID(int i){
       numPorta=i;
   }
   
   /**
     @brief La porta canvia d'estat
     @pre cert
     @post L'estat de la porta canvia a \p c
     */
   public void canviarEstat(char c){
   
       estat =c;
   }
   
   /**
     @brief Diu si es pot passar per la porta
     @pre cert
     @post Retorna cert si estat=='O' o estat=='D
     */
   public boolean esPotPassar(){
       if(estat=='O') return true;
       else if (estat=='D') return true;
       else return false;
   }
   
   /**
     @brief Afegeix una paret
     @pre cert
     @post S'afegeix la paret \p p a la porta
     */
   public void afegirParet(Paret p){
   
       par=p;
   }
   
   /**
     @brief Diu l'estat en que es troba la porta
     @pre cert
     @post Retorna l'estat de la porta
     */
   public char Estat(){
       return estat;
   }
}

