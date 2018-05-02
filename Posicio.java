
import static java.lang.Math.sqrt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Date creation: 29/3/2018
 * @author oriol
 */

/**
    Descripcio General: Coordenades cartesianes en dos dimensions 
*/
public class Posicio {
    private int x;
    private int y;
    
    /**
    * @pre : --;
    * @post : la coordenada x val x i la coordenada y val y
    */
    public Posicio (int x, int y){
    this.x = x;
    this.y = y;
    }
    
    /**
    * @pre --;
    * @post retorna la coordenada x
    */
    public int CoordenadaX(){
        return x;
    }
    
    /**
    * @pre --;
    * @post retorna la coordenada y
    */
    public int CoordenadaY () {
    
        return y;
    }
    
    /**
    * @pre : --;
    * @Post: Retorna el vector que hi ha entre dues posicions
    */
    public Posicio Vector(Posicio n){
        int distanciaX = n.x-x;
        int distanciaY = n.y-y;
       Posicio resultat = new Posicio(distanciaX,distanciaY);
       return resultat;
    }
    
    
    /**
    * @pre : --;
    * @Post: Retorna la distancia entre dues posicions
    */
    public float Distancia (Posicio n){
        
        return (float) sqrt((x-n.x)*(x-n.x)+(y-n.y)*(y-n.y));
    }
}

    