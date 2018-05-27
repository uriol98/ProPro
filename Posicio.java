


/**
    @class Posicio
    @brief 
    @author Oriol Canet
 */
public class Posicio {
    private int x; ///< posicio d'una matriu
    private int y; ///< posicio y d'una matriu
    
    /**
     @brief Crea una posicio amb x i y
     @pre  cert
     @post S'ha creat una posicio amb x = \p x i y= \p y
     */
    public Posicio (int x, int y){
    this.x = x;
    this.y = y;
    }
    
    /**
     @brief Diu quina és la coordenada x
     @pre cert
     @post Retorna la coordenada x de la posicio
     */
    public int CoordenadaX(){
        return x;
    }
    
    /**
     @brief Diu quina és la coordenada y
     @pre cert
     @post Retorna la coordenada y de la posició
     */
    public int CoordenadaY () {
    
        return y;
    }
    
    /**
     @brief Diu quin és el vector que hi ha entre dues posicions
     @pre cert
     @post Retorna el vector format entre la posicio i \p n
     */
    public Posicio Vector(Posicio n){
        int distanciaX = n.x-x;
        int distanciaY = n.y-y;
       Posicio resultat = new Posicio(distanciaX,distanciaY);
       return resultat;
    }
    
    
    /**
     @brief Diu quina és la distancia entre dues posicions
     @pre cert
     @post Retorna la distància que hi ha entre la posicio i \p n
     */
    public int DistanciaManhattan (Posicio n){
        int i= x-n.x;
        if(i<0) x=x*-1;
        int j= y-n.y;
        if (j<0) j=j *-1;
        return i+j;
    }
}

    
