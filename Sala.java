
import java.util.ArrayList;

/**
    @class Sala
    @brief 
    @author Oriol Canet
 */
public class Sala {
    int numSala; ///< identificador de sala
    private boolean tresor; ///< indicador de tresor
    private ArrayList<Cela>  cambra; ///< contenidor amb les celes de la sala
    private ArrayList<Personatge> PersonatgesSala; ///< Contenidor amb els personatges de la sala
    
    /**
     @brief Crea una Sala buida
     @pre  cert
     @post S'ha creat una sala buida amb l'identificador nSala
     */
    Sala(int nSala){
        numSala= nSala;
        cambra = new ArrayList();
        PersonatgesSala= new ArrayList();
    }
    
    /**
     @brief Diu si és la sala del tresor
     @pre cert
     @post Retorna cert si és la sala del tresor
     */
    public boolean teTresor(){
        return tresor;
    }

    /**
     @brief Afegeix una cela al laberint
     @pre cert
     @post S'ha afegit \p c a la sala
     */
    public void afegirCela(Cela c){
        cambra.add(c);
    }
    
    /**
     @brief Diu quina sala és
     @pre cert 
     @post Retorna l'identificador de Sala
     */
    public int numeroSala(){
        return numSala;
    }
    
    
    /**
     @brief Afegeix un personatge
     @pre cert 
     @post S'ha afegit el personatge \p p a la sala
     */
    public void afegirPersonatge(Personatge p){
        PersonatgesSala.add(p);
    }
    
    
    /**
     @brief Treu un personatge de la Sala
     @pre cert 
     @post El personatge \p p surt de la sala
     */
    public void sortirPersonatge(Personatge p){
        PersonatgesSala.remove(p);
    }
}

