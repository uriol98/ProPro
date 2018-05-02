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
	
        private ArrayListz<Int> memoria;
      
	private int nObjActual;
        private boolean teTresor;
	
	public Huma(){
            super();
            teTresor = false;
        }
        
        public Huma(String idPersonatge, String tipus, Posicio pos,int invSize,int memSize){
            super(String idPersonatge, String tipus, Posicio pos);
            this.invSize = invSize;
            this.memSize = memSize;
            teTresor = false; 
        }
        
	public boolean afegirObjecte(Clau clau){
            return(add(inventari clau));
	}
        
        @Override
        public void moviment(Posicio pos2){
        //post:acosta l'huma a la pos2 una casella
        }
        
        
	
}
