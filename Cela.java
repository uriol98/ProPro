import java.util.ArrayList;

/**
    @class Cela
    @brief 
    @author Oriol Canet
 */
//**********    FALTEN METODES AFEGIR CLAUS I TRESOR; I RETORNAR-LOS I CONSTRUCTOR PER DEFECTE

public class Cela {
 
    private Posicio pos;
    private Sala cambra;
   // private Vector<claus> keys;
   // private Vector<Tresor> tres;
    private boolean ocupada;
    private Paret[] costats; //pos 0=NORD, pos 1=SUD, pos2=EST, pos3=OEST
    private Porta port;
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Cela(){
        ocupada=false;
        cambra=null;
        Paret [] p = new Paret[4];
        costats=p;
        //keys= new Vector<>();
        //tres= new Vector<>();
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Posicio posicio(){
        return pos;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    /*
    public boolean teClaus(){
    
        return  !keys.isEmpty();
    }
    */
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public boolean teTresor(){
    
            //return !tres.isEmpty();
            return false;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public boolean mateixaSala(Cela cel){
    
        return cambra.numeroSala() == cel.cambra.numeroSala();
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public boolean esOcupada(){
    
        return ocupada;
    }

    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void afegirSala(Sala sal){
        cambra = sal;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void afegirPosicio(Posicio p){
        pos=p;
    }
 
     /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Sala sala(){
        return cambra;
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void afegirParet(Paret p, char dir){
    
        if (dir=='N'){
            //costats.add(0, p);
            costats[0]=p;
        }
        else if (dir=='S'){
            //costats.add(1, p);
            costats[1]=p;
        }
        else if (dir=='E'){
            //costats.add(2, p);
            costats[2]=p;
        }
        else if (dir=='W'){
            //costats.add(3, p);
            costats[3]=p;
        }
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Paret paret(char dir){
    
        
        if (dir=='N'){
            return costats[0];
        // return costats.get(0);
        }
        else if(dir=='S'){
            //return costats.get(1);
            return costats[1];
        }
        else if(dir=='E'){
            //return costats.get(2);
            return costats[2];
        }
        else {
            //return costats.get(3);
            return costats[3];
        }
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void afegirPorta(Porta p){
        
        port=p;
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Porta tePorta(){
    
        return port;
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void canviarOcupar(){
        if(ocupada==false) ocupada=true;
        else ocupada=false;
    }
}


