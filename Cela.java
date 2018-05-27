import java.util.ArrayList;

public class Cela {
 
    private Posicio pos; ///< Posicio on es troba la cela
    private Sala cambra; ///< Sala a la que pertany la cela
    private ArrayList<Clau> keys; ///< Llista de claus que hi ha en una cela
    private Tresor tres; ///< Tresor que hi a al joc
    private Personatge pers; ///< Personatge que ocupa la cela
    private boolean ocupada; ///< indica si la cela està ocupada per un personatge
    private Paret[] costats; ///< guarda les parets que hi ha a la cela. pos 0=NORD, pos 1=SUD, pos2=EST, pos3=OEST
    private Porta[] portes; ///< Porta que hi ha la cela
    
    
    /**
     @brief Crea una cela buida
     @pre cert
     @post S'ha creat una cela desocupada que no pertany a cap cambra i sense parets ni objectes
     */
    public Cela(){
        ocupada=false;
        cambra=null;
        Paret [] p = new Paret[4];
        costats=p;
        Porta [] port= new Porta[4];
        portes = port;
        keys= new ArrayList<>();
        tres=null;
    }
    
    /**
     @brief diu la posicio de la cela
     @pre cert
     @post Retorna la posicio on es troba la cela
     */
    public Posicio posicio(){
        return pos;
    }
    
    /**
     @brief Afegeix una clau
     @pre  cert
     @post Afegeix una clau a la llista de claus
     */
    
    public void afegirClau(Clau c){
    
        keys.add(c);
    }
    
    
    /**
     @brief Dóna les claus de la cela
     @pre  cert
     @post Retorna les claus de la cela
     */
    
    public ArrayList<Clau> Claus(){
    
        return  keys;
    }
    
    
    
    /**
     @brief Afegeix un tresor
     @pre cert
     @post Afegeix un tresor a la cela
     */
    public void afegirTresor(Tresor t){
    
            tres=t;
    }
    
    
    /**
     @brief Diu si la cela té tresor
     @pre cert
     @post Retorna el tresor de la cela. Si no en té, retorna null
     */
    public Tresor Tresors(){
    
            return tres;
    }
    
    /**
     @brief diu si la cela es troba en la mateixa sala
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public boolean mateixaSala(Cela cel){
    
        return cambra.numeroSala() == cel.cambra.numeroSala();
    }
    
    /**
     @brief diu si la cela esta ocupada
     @pre  cert
     @post Retorna cert si la cela està ocupada
     */
    public boolean esOcupada(){
    
        return ocupada;
    }

    /**
     @brief Assigna una sala a la cela
     @pre cert
     @post S'ha afegit sal com a sala de la cela
     */
    public void afegirSala(Sala sal){
        cambra = sal;
    }
    
    /**
     @brief Assigna una posicio a la cela
     @pre cert
     @post S'ha afegit \p p a la cela
     */
    public void afegirPosicio(Posicio p){
        pos=p;
    }
 
     /**
     @brief diu a quina sala es troba la cela
     @pre cert
     @post Retorna la sala al que es troba la cela
     */
    public Sala sala(){
        return cambra;
    }
    
    
    /**
     @brief Afegeix una paret a la cela
     @pre dir='N' o dir='S' o dir='E' o dir='W'
     @post Afegeix la paret \p p amb direccio dir a la cela
     */
    public void afegirParet(Paret p, char dir){
    
        if (dir=='N'){
            
            costats[0]=p;
        }
        else if (dir=='S'){
            
            costats[1]=p;
        }
        else if (dir=='E'){
            
            costats[2]=p;
        }
        else if (dir=='W'){
            
            costats[3]=p;
        }
    }
    
    
    /**
     @brief diu quina paret hi ha en una direccio
     @pre dir='N' o dir='S' o dir='E' o dir='W'
     @post Retorna la paret que hi ha en la direccio dir
     */
    public Paret paret(char dir){
    
        
        if (dir=='N'){
            return costats[0];
        
        }
        else if(dir=='S'){
            
            return costats[1];
        }
        else if(dir=='E'){
            
            return costats[2];
        }
        else {
            
            return costats[3];
        }
    }
    
    /**
     @brief Afegeix una porta
     @pre dir='N' o dir='S' o dir='E' o dir='W'
     @post  Afegeix la porta \p p amb direccio dir a la cela
     */
    public void afegirPorta(Porta p, char dir){
        
        if (dir=='N'){
            
            portes[0]=p;
        }
        else if (dir=='S'){
            
            portes[1]=p;
        }
        else if (dir=='E'){
            
            portes[2]=p;
        }
        else if (dir=='W'){
            
            portes[3]=p;
        }
    }
    
    /**
     @brief diu si la cela te porta en una direccio
     @pre cert
     @post Retorna la porta que hi ha en la direccio dir
     */
    public Porta tePorta(char dir){
        
        if (dir=='N'){
            
             return portes[0];
        }
        else if (dir=='S'){
            
             return portes[1];
        }
        else if (dir=='E'){
            
           return portes[2];
        }
        else {
            
            return portes[3];
        }
    }
    
    
    /**
     @brief canviar l'ocupacio de la cela
     @pre cert
     @post L'estat d'ocupació de la cela ha canviat
     */
    public void treurePersonatge(){
        pers=null;
    }
    
    public void afegirPersonatge(Personatge p){
        
        pers=p;
    }
}



