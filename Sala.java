/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oriol
 */
public class Sala {
    int numSala;
    int amplada;
    int llargada;
    private boolean tresor;
    private Cela[][] cambra;
    
    /**
     * 
     * @param ampl
     * @param llarg
     * @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Sala(int ampl, int llarg){
    
        amplada = ampl;
        llargada= llarg;
        Cela[][] c = new Cela[ampl][llarg];
        for (int i = 0; i<ampl;i++){
            for (int j = 0; j<llarg;j++){
                Posicio p = new Posicio(i,j);
                c[i][j].afegirPosicio(p);
            }
        }
        cambra = c;
    }
}
