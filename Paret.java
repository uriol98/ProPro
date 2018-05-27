import java.util.ArrayList;


/**
    @class Paret
    @brief 
    @author Oriol Canet
 */
public class Paret {
    private ArrayList<Cela> celes;
    private ArrayList<Porta> port;
    
   /**
     @brief Crea una paret buida
     @pre cert
     @post La paret està buida
     */
    public Paret(){
    
        ArrayList<Cela> p = new ArrayList();
        port=new ArrayList();
        celes=p;
    }
    
    
    /**
     @brief Afegeix una cela
     @pre cert
     @post S'ha afegit la cela \p c a la paret
     */
    public void AfegirCela(Cela c){
        celes.add(c);
    }
    
    
    /**
     @brief afegeix una porta
     @pre cert
     @post S'ha afegit la porta \p p a la paret
     */
    public void afegirPorta(Porta p){
        port.add(p);
    }
    
    /**
     @brief diu la mida de la paret
     @pre cert
     @post Retorna la mida de la paret
     */
    public int mida(){
        return celes.size();
    }

    
    /**
     @brief retorna una cela
     @pre 0<=pos<=mida
     @post Retorna la cela que hi ha a la posicio pos 
     */
    public Cela agafarCela(int pos){
            
            return celes.get(pos);
        }
    
    
}

