import java.util.ArrayList;

/**
 * 
 * @author oriol
 * 
 * Descripcio General: Cela d'una sala, on hi poden haver objectes i personatges
 */
//**********    FALTEN METODES AFEGIR CLAUS I TRESOR; I RETORNAR-LOS I CONSTRUCTOR PER DEFECTE

public class Cela {
 
    private Posicio pos;
    private int numSal;
   // private Vector<claus> keys;
   // private Vector<Tresor> tres;
    private boolean ocupada;
    private Paret[] costats; //pos 0=NORD, pos 1=SUD, pos2=EST, pos3=OEST
    private Porta port;
    
    
    /**
    * @pre 
    * @post
    */
    public Cela(){
        ocupada=false;
        numSal=-1;
        Paret [] p = new Paret[4];
        costats=p;
        //keys= new Vector<>();
        //tres= new Vector<>();
    }
    
    /**
    * @pre --;
    * @post Retorna les coordenades de la cela
    */
    public Posicio posicio(){
        return pos;
    }
    
    /**
     * @return 
    * @pre --;
    * @post Retorna cert si la cel·la té una o més claus
    */
    /*
    public boolean teClaus(){
    
        return  !keys.isEmpty();
    }
    */
    
    /**
     * @return 
    * @pre --;
    * @post Retorna cert si la cela te el tresor
    */
    public boolean teTresor(){
    
            //return !tres.isEmpty();
            return false;
    }
    
    /**
     * @param cel
     * @return 
    * @pre --;
    * @post L'humà és creat
    */
    public boolean mateixaSala(Cela cel){
    
        return numSal == cel.numSal;
    }
    
    /*
    * @Pre --;
    * @Post retorna cert si la cela està ocupada per un personatge
    */
    public boolean esOcupada(){
    
        return ocupada;
    }

    /*
    * @Pre 
    * @Post
    */
    public void afegirSala(int sal){
        numSal = sal;
    }
    
    /**
    * @pre 
    * @post
    */
    public void afegirPosicio(Posicio p){
        pos=p;
    }
 
     /**
    * @pre 
    * @post
    */
    public int numeroSala(){
        return numSal;
    }
    
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
        else if (dir=='O'){
            //costats.add(3, p);
            costats[3]=p;
        }
    }
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
    
    
    public void afegirPorta(Porta p){
        
        port=p;
    }
    
    public Porta tePorta(){
    
        return port;
    }
    
    public void canviarOcupar(){
        if(ocupada==false) ocupada=true;
        else ocupada=false;
    }
}

