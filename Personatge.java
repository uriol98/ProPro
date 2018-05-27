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
	protected String idPersonatge;//nom d'ususari si es jugador
        protected Cela c;
        protected String tipus;
	//constructors
        public Personatge(){
        //constructor per defecte
        }
        public Personatge(String idPersonatge, Cela c){
        //post:cosntructor
            this.idPersonatge = idPersonatge;
            this.c = c;
        }
        
        public Cela cela(){
         //post:retorna posicio del personatge
            return this.c;
	}
         
        public String tipus(){
            return tipus;
        }

        public String nom(){
            return idPersonatge;
        }
        
        
        void moviment1(Posicio pos2){
        //Pre:
        //Post:el personatge s'ha acostat una casella la posicio 2(te en compte parets i sales)
            Cela[][] lab = laberint();
            if (this.c.posicio().CoordenadaX() >  pos2.CoordenadaX()){
                if (this.c.paret('N')){
                    if (this.c.tePorta('N')){
                        interactuaPorta('N');
                    }
                    else{
                        if (lab[this.cela().posicio().CoordenadaX - 1][this.cela().posicio().CoordenadaY].esOcupada()){
                            this.c = lab[this.cela().posicio().CoordenadaX][this.cela().posicio().CoordenadaY];
                    }
            }
        
            else if(this.c.posicio().CoordenadaX() < pos2.CoordenadaX()){
                if (this.c.paret('S')){
                    if (this.c.tePorta('S'))
                        interactuaPorta('S');
                    }
                    else {
                        if (lab[this.cela().posicio().CoordenadaX + 1][this.cela().posicio().CoordenadaY].esOcupada()){
                            this.c = lab[this.cela().posicio().CoordenadaX][this.cela().posicio().CoordenadaY];
                    }
                }
            }
            
            else if(this.c.posicio().CoordenadaY() > pos2.CoordenadaY()){
                if (this.c.paret('E'))
                    if (this.c.tePorta('E')){
                       interactuaPorta('E');
                    }
                    else {
                        if (lab[this.cela().posicio().CoordenadaX][this.cela().posicio().CoordenadaY - 1].esOcupada()){
                            this.c = lab[this.cela().posicio().CoordenadaX][this.cela().posicio().CoordenadaY];
                    }
                }
            }
            
            else if(this.c.posicio().CoordenadaY() < pos2.CoordenadaY()){
                if (this.c.paret('W'))
                    if (this.c.tePorta('W'))
                         interactuaPorta('W');
                    if (lab[this.cela().posicio().CoordenadaX][this.cela().posicio().CoordenadaY + 1].esOcupada()){
                        this.c = lab[this.cela().posicio().CoordenadaX][this.cela().posicio().CoordenadaY];
                    }    
             }
        }

        private void interactuaPorta( char 'D'){
        //Pre:Personatge al costat de una porta en direccio del caracter (N,S,E,W)
        //Post:Si es humà ha obert la porta, si es troll ha trencat la porta
        }
            if(tipus == "Troll"){
            //trenca porta
            
            }
            else{
            //obre porta    
            }
        }
        
        public void portaMesPropera(){
        //pre:personatge dins d'una sala
        //post:s'ha acostat una casella a la porta mes propera
            
        }
	
}
