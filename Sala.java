
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
    @class Sala
    @brief 
    @author Oriol Canet
 */
public class Sala {
    int numSala; ///< identificador de sala
    int amplada; ///< amplada de la sala
    int llargada; ///< llargada de la sala
    private boolean tresor; ///< indicador de tresor
    private ArrayList<Cela>  cambra; ///< contenidor amb les celes de la sala
    //private Personatges PersonatgesSala[]; ///< Contenidor amb els personatges de la sala
    
    /**
     @brief Crea una Sala buida
     @pre  cert
     @post S'ha creat una sala buida amb l'identificador nSala
     */
    Sala(int nSala){
        numSala= nSala;
        cambra = new ArrayList();
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

}


