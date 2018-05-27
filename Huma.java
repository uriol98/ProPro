/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.arrayList;
/**
 *
 * @author Jere
 */
public class Huma extends Personatge{
	private int invSize;
        private int memSize;
        private ArrayList<Clau> inventari;
	
        private ArrayList<Int> memoria;
      
	private int nObjActual;
        
	
        private Tresor tresor;
	public Huma(){
        //Pre:
        //Post:
        
            super();
            teTresor = false;
        }
        
        public Huma(String idPersonatge, String tipus, Posicio pos,int invSize,int memSize){
        //Pre:
        //Post:
            super(String idPersonatge, String tipus, Posicio pos);
            this.invSize = invSize;
            this.memSize = memSize;
            teTresor = false; 
        }
        
	public boolean afegirObjecte(Clau clau){
        //Pre:
        //Post:
            if(inventari.contains(clau)){
                return(inventari.add(clau));
	}
            
        public boolean afegirTresor(){
        //Pre:
        //Post:
        
            if (inventari.size < invSize){
                tresor =  this.cela().Tresors();
                                
            }
            
        }
        
        
 
        public void decisio(){
        //Pre:torn de huma no controlat per usuari
        //Post:tria quina es la millor accio 
            if(tresor == null){
                
            }
            
            else if(this.cela().teTresor()){
                this.afegirTresor();
            }
            else if(this.cela().teClau()){
                this.afegirObjecte(this.cela().clau)
            }
            else if(this.cela().sala().contePersonatge()){
                //fugir
            }
            
        }
        private void sortir(){
            
        }
        
        
	
}
