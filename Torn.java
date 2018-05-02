import java.util.arraylist;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jere
 */
public class Torn{
	InputStreamRead isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader (isr);
	char accio;
        Personatge pers;//utilitzat pel torn actual
        
        
	//moviment: w,a,s,d/ agafar objecte:e/ obrir porta:f/ atacar:x
        
	public void nouTorn(ArrayList personatges,int i){
	//pre:
        //post:
            pers = personatges.get(i);
            
        
	}
	private void novaAccio(){
        //pre:
        //post:comença una nova accio
        }
		if (tornJugador){
			char accio = (char) br.read();
		}
		else if (tornHumaNPC){
			char accio = accioHuma()
		}
		else{//torn de troll
			char accio = accioTroll()
		}
	}
	private boolean personatgeProper(vector personatges, Sala sala){
	//pre:
	//post:retorna cert si hi ha un altre personatge a la mateixa sala
		for (int i = 0;i < personatges.size() ; i++){
			//recòrrer tota la sala
		}	
	}
	
	private char accioHuma(Huma huma){
	//pre:torn de l'humà npc (no jugador)
	//post:retorna un caràcter corresponent a l'accio que realitzarà l'humà depenent de les cirumstàncies
        
		if(objecteATerra(){
			Objecte obj = huma.pos.objecte();
                        huma.afegirObjecte(obj);
		}
		if(salaTeTresor(){
			//es mou en direccio del tresor
		}
		else if(!personatgeProper(){
			//fugir de la sala per la porta mes propera
		}
		else{
			//es mou en direccio a una altra porta per entrar a una sala diferent
		}
	}
	
        private boolean objecteAterra(){
        //pre:
        //post:
}
	private char accioTroll(){
	//pre: torn de troll
	//post: retorna un caràcter corresponent a l'accio qe farà el troll
	
		if (personatgeProper()){
			if (personatgeCasellaContigua(){
				//atacar
				return 'x';
			}
			else{
				//es mou en direccio al personatge
			}
		}
		else{
			//es mou en direccio a la porta mes propera
		}
	}
	
