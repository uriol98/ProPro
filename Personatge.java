/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jere
 */
public abstract class Personatge{
	protected Posicio pos;
	protected string idPersonatge;//nom d'ususari si es jugador
        
	//constructors
        public Personatge(){
            
        }
        public Personatge(String idPersonatge, Posicio pos){
            this.idPersonatge = idPersonatge;
            this.pos = pos;
        }
        
        public Posicio pos(){
         //post:retorna posicio del personatge
            return pos;
	}
         
        public abstract void moviment(Posicio pos2){
	//pre: 
	//post: el personatge s'ha acostat una casella la posicio 2
            
        }
        
        void moviment(Posicio pos2){
        //pre: 
	//post: el personatge s'ha acostat una casella la posicio 2
            if (this.pos.CoordenadaX() > pos2.CoordenadaX()){
                this.pos = Posicio(this.pos.CoordenadaX()-1,this.pos.CoordenadaY());
            }
            else if (this.pos.CoordenadaX() < pos2.CoordenadaX()){
                this.pos = Posicio(this.pos.CoordenadaX()+1,this.pos.CoordenadaY());
            }
            else if(this.pos.CoordenadaY() > pos2.CoordenadaY()){
                this.pos = Posicio(this.pos.CoordenadaX,this.pos.CoordenadaY()-1);
            }
            else if(this.pos.CoordenadaY() < pos2.CoordenadaY()){
                this.pos = Posicio(this.pos.CoordenadaX,this.pos.CoordenadaY()+1); 
            }       
        }
        
        void moviment1(Posicio pos2){
        //Pre:
        //Post:el personatge s'ha acostat una casella la posicio 2(te en compte parets i sales)
        }
        
	
}