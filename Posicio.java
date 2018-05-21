
import static java.lang.Math.sqrt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
    @class Posicio
    @brief 
    @author Oriol Canet
 */
public class Posicio {
    private int x;
    private int y;
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Posicio (int x, int y){
    this.x = x;
    this.y = y;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public int CoordenadaX(){
        return x;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public int CoordenadaY () {
    
        return y;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Posicio Vector(Posicio n){
        int distanciaX = n.x-x;
        int distanciaY = n.y-y;
       Posicio resultat = new Posicio(distanciaX,distanciaY);
       return resultat;
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public float DistanciaManhattan (Posicio n){
        int i= x-n.x;
        if(i<0) x=x*-1;
        int j= y-n.y;
        if (j<0) j=j *-1;
        return i+j;
    }
}

    

    
