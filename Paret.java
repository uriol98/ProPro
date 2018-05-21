import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
    @class Paret
    @brief 
    @author Oriol Canet
 */
public class Paret {
    private ArrayList<Cela> cel;
    private Porta por;
    
   /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Paret(){
    
        ArrayList<Cela> p = new ArrayList();
        cel=p;
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void AfegirCela(Cela c){
        cel.add(c);
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void afegirPorta(Porta p){
        por=p;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public int mida(){
        return cel.size();
    }

    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Cela agafarCela(int pos){
            
            return cel.get(pos);
        }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void mostrar(){
        for(int i=0; i<cel.size();i++){
            System.out.println(cel.get(i).posicio().CoordenadaX()+" "+cel.get(i).posicio().CoordenadaY());
        }
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Porta getPorta(){
        return por;
    }
    
}

