

/**
    @class Porta
    @brief 
    @author Oriol Canet
 */
public class Porta {
    private int numPorta; ///< identificador de porta
    private Cela cel; ///< cela on es troba la porta
    private char orientacio; ///< orientacio de la porta
    private char estat; ///< estat en que es troba la porta
    private Paret par; ///< paret on es situa la porta
    private Sala [] sales;

    /**
     @brief Crea una porta tancada
     @pre cert
     @post S'ha creat una porta tancada i amb identificador de porta=0
     */
    public Porta(){
        numPorta=0;
        orientacio='N';
        estat='T'; 
        sales= new Sala[2];
    }
    
    
    
/**
     @brief Es crea una porta en una cela orientada
     @pre (\p c existeix) i ((\p o=='N') o (\p o=='S') o (\p o=='E') o (\p o=='W'))
     @post S'ha creat la porta a la cela \p c amb orientacio \p o
     */  
    public Porta(Cela c, char o){
    
        cel=c;
        orientacio=o;
        estat='T';
        sales= new Sala[2];
    }
    
    /**
     @brief diu quina és l'orientacio de la porta
     @pre 
     @post Retorna l'orientacio de la porta
     */
    public char Orientacio(){
    
        return orientacio;
    }
    
    
/**
     @brief Canvia la orientacio de la porta
     @pre  cert
     @post La orientacio de la porta passa a ser \p c
     */
   public void afegirOrientacio(char c){
       orientacio = c;
   }
   
   
   /**
     @brief Afegeix una cela
     @pre  \p c existeix
     @post S'ha afegit \p c a la porta
     */
   public void afegirCela(Cela c){
       
       cel=c;
   }
   
/**
     @brief diu a quina cela esta la porta
     @pre cert
     @post Retorna la cela on es troba la porta
     */
   public Cela Posicio(){
       
       return cel;
   }
   
   /**
     @brief Afegeix un identificador
     @pre La porta té les dues sales afegides
     @post La sala queda numerada seguint l'expressio 1000j+k on j i k són id's de cambres
     */
   public void numerarPorta(){
       int id1=sales[0].numeroSala();
       int id2=sales[1].numeroSala();
       if (id1<id2){
           numPorta=1000*id1+id2;
       }
       else{
           numPorta=1000*id2+id1;
       }
   }
   
   /**
     @brief La porta canvia d'estat
     @pre cert
     @post L'estat de la porta canvia a \p c
     */
   public void canviarEstat(char c){
   
       estat =c;
   }
   
   /**
     @brief Diu si es pot passar per la porta
     @pre cert
     @post Retorna cert si estat=='O' o estat=='D
     */
   public boolean esPotPassar(){
       if(estat=='O') return true;
       else if (estat=='D') return true;
       else return false;
   }
   
   /**
     @brief Afegeix una paret
     @pre cert
     @post S'afegeix la paret \p p a la porta
     */
   public void afegirParet(Paret p){
   
       par=p;
   }
   
   /**
     @brief Diu l'estat en que es troba la porta
     @pre cert
     @post Retorna l'estat de la porta
     */
   public char Estat(){
       return estat;
   }
   
   /**
     @brief Diu l'estat en que es troba la porta
     @pre cert
     @post Retorna l'estat de la porta
     */
   public void afegirSales(Sala s1, Sala s2){
       sales[0]=s1;
       sales[1]=s2;
       
   }
   
   
   /**
     @brief Diu l'estat en que es troba la porta
     @pre cert
     @post Retorna l'estat de la porta
     */
   public Sala Cambra(char c){
   
       if (c=='N'){
           return sales[0];
       }
       else if (c=='E'){
           return sales[0];
       }
       else{
           return sales[1];
       }
   }
   
   public void numerarPortaEntrada(){
       numPorta=0;
   }
}
