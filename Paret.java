import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oriol
 */
public class Paret {
    private ArrayList<Cela> cel;
    private Porta por;
    
    //falta constructor
    public Paret(){
    
        ArrayList<Cela> p = new ArrayList();
        cel=p;
    }
    
    public void AfegirCela(Cela c){
        cel.add(c);
    }
    
    public void afegirPorta(Porta p){
        por=p;
    }
    

    public int mida(){
        return cel.size();
    }

    public Cela agafarCela(int pos){
            
            return cel.get(pos);
        }
    
    public void mostrar(){
        for(int i=0; i<cel.size();i++){
            System.out.println(cel.get(i).posicio().CoordenadaX()+" "+cel.get(i).posicio().CoordenadaY());
        }
    }
}




    

    
