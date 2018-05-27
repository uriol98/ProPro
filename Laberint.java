import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


/**
    @class Laberint
    @brief 
    @author Oriol Canet
 */
public class Laberint {
    private Cela[][] lab; ///< Matriu de celes que representa les caselles del laberint
    private int amplada; ///< Amplada del laberint
    private int llargada; ///< Llargada del laberint
    private int nSales; ///< Nombre de sales que té el laberint
    private int minimSub; ///< Minim de caselles que ha de tenir una sala per poder-la subdividir
    private int probPorta; ///< Probabilitat que hi hagi porta en una paret
    private ArrayList<Porta> portes; ///< Llista de portes del laberint
    private ArrayList<Paret> paretsVerticals; ///< Llista de parets verticals del laberint
    private ArrayList<Paret> paretsHoritzontals; ///< Llista de parets horitzontals del laberint
    private ArrayList<Sala> sales; ///< Llista de sales que te el laberint
    
     /**
     @brief Crea un laberint buit
     @pre  cert
     @post S'ha creat un laberint buit 
     */
    public Laberint(){
        amplada = 0;
        llargada = 0;
        nSales=1;
        minimSub=3;
        probPorta=80;
        
    }
    
    
   //GENERACIO ALEATORIA LABERINT
      
    /**
     @brief Crea un laberint generat de forma aleatoria
     @pre 1<ampl<=30 i 1<llarg<=30 i (minimSub<llarg i minimSub<ampl)
     @post Es crea un laberint d'amplada ampl, llargada llarg amb sales generades de forma aleatòria
     * 
     */
    public void generarLaberint(int ampl, int llarg, int minimSub, int prop){
    
        this.minimSub=minimSub;
        amplada = ampl;
        llargada = llarg;
        probPorta= prop;
        lab =ferLaberint();
        iGenerarLaberint(1,amplada,1,llargada,'H');
        
        
    }
    
    /**
     @brief Inicialitza el laberint
     @pre amplada>0 i llargada>0
     @post El laberint és inicialitzat, juntament amb tots els atributs
     */
    private Cela[][] ferLaberint(){
    
        int numSala=0;
        ArrayList<Paret> paretsV = new ArrayList<>();
        paretsVerticals=paretsV;
        ArrayList<Paret> paretsH = new ArrayList<>();
        paretsHoritzontals=paretsH;
        ArrayList<Porta> port= new ArrayList<>();
        portes=port;
        sales = new ArrayList<>();
        
        Cela[][] nouLab = new Cela[amplada+1][llargada+1];
        for (int i = 0; i<=amplada;i++){
            for (int j = 0; j<=llargada;j++){
                nouLab[i][j] = new Cela();
                Posicio p = new Posicio(i,j);
                nouLab[i][j].afegirPosicio(p);
                
                
                
            }
        }
        return nouLab;
    }
    
    
    /**
     @brief Divideix el laberint
     @pre esq>0 i dre<=llargada i dalt>0 i baix<=amplada i (part='V' o part='H')
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private void iGenerarLaberint(int esq, int dre, int dalt, int baix, char part){
    
        Random rand= new Random();
        int particio;
        boolean esPotH=false;
        boolean esPotV=false;
        if (dre-esq>=minimSub) esPotV=true;
        if (baix-dalt>=minimSub) esPotH=true;
        
        if (esPotH!=esPotV){
            if(esPotV==true)part='V';
            else if (esPotH==true) part='H';
        }
        else {
            if (esPotH==false) part='N';
        }
        if(part=='V'){
            Paret p = new Paret();
            particio=rand.nextInt((dre-esq)-1)+esq+1;
            for(int i=dalt;i<=baix;i++){
                p.AfegirCela(lab[i][particio]);
            }
            
            generarPorta(p,'E');
            paretsVerticals.add(p);
            nSales++;
            iGenerarLaberint(esq,particio,dalt,baix,'H');
            iGenerarLaberint(particio+1,dre,dalt,baix,'H');
        }
        else if (part=='H'){
            Paret p = new Paret();
            particio=rand.nextInt((baix-dalt)-1)+dalt+1;
            for(int i=esq;i<=dre;i++){
                p.AfegirCela(lab[particio][i]);
            }
            generarPorta(p,'S');
            paretsHoritzontals.add(p);
            nSales++;
            iGenerarLaberint(esq,dre,dalt,particio,'V');
            iGenerarLaberint(esq,dre,particio+1,baix,'V');
        }

    }
    
    
    
    
    
    /**
     @brief Crea una porta a una paret
     @pre par.mida>0 i (dir='N' o dir='S' o dir='E' o dir='O')
     @post Es pot generar una porta en una posicio aleatòria de la paret
     */
    private void generarPorta( Paret par, char dir){
        
        Random rand = new Random();
        int probabilitat = rand.nextInt(100);
        if(probabilitat<probPorta){
            int max=par.mida()-1;
            int pos;
            if(max==0){ 
                pos =0;
            }
            else{ 
                pos = rand.nextInt(max);
            }
            Cela c = par.agafarCela(pos);
            Porta p = new Porta(c,dir);
            par.afegirPorta(p);
            portes.add(p);
        }
    }
    
    
    
    /**
     @brief Escriu en el fitxer de generacio de laberint
     @pre nomFitxer és el nom d'un fitxer que existeix
     @post S'ha generat un fitxer de lectura de laberint
     */
  public  void generarFitxer(String nomFitxer) throws FileNotFoundException, UnsupportedEncodingException{
    
    
    
    PrintWriter writer = new PrintWriter(nomFitxer, "UTF-8");
    writer.println("llargada");
    writer.println(llargada);
    writer.println("amplada");
    writer.println(amplada);
    writer.println("parets_horitzontals");
    int altura;
    int primer;
    int ultim;
    
    for(int i = 0; i<paretsHoritzontals.size();i++){
        altura=paretsHoritzontals.get(i).agafarCela(0).posicio().CoordenadaX();
        primer=paretsHoritzontals.get(i).agafarCela(0).posicio().CoordenadaY();
        ultim =paretsHoritzontals.get(i).agafarCela(paretsHoritzontals.get(i).mida()-1).posicio().CoordenadaY();
        writer.println(altura + " S " + primer+".."+ultim);
    }
    writer.println("#");
    writer.println("parets_verticals");
    for(int i = 0; i<paretsVerticals.size();i++){
        altura=paretsVerticals.get(i).agafarCela(0).posicio().CoordenadaY();
        primer=paretsVerticals.get(i).agafarCela(0).posicio().CoordenadaX();
        ultim =paretsVerticals.get(i).agafarCela(paretsVerticals.get(i).mida()-1).posicio().CoordenadaX();
        writer.println(altura + " E " + primer+".."+ultim);
    }

    writer.println("#");
    writer.println("portes");
    for (int i = 0;i<portes.size();i++){
        int x= portes.get(i).Posicio().posicio().CoordenadaX();
        int y= portes.get(i).Posicio().posicio().CoordenadaY();
        char orientacio = portes.get(i).Orientacio();
        writer.println("("+x+","+y+") "+orientacio);   
    }
    writer.println("#");
    writer.println("porta_entrada");
    String portaEntrada = generarPortaEntrada();
    writer.println(portaEntrada);
    writer.println("#");
    writer.close();

        
    }
  
  
  /**
     @brief Genera la porta d'entrada al laberint
     @pre El laberint ja té les parets dels voltants
     @post Es genera la porta d'entrada al laberint
     */
  private String generarPortaEntrada(){
      String s="(";
      Random rand = new Random();
      int paret = rand.nextInt(4)+1; //1 =paret Nord, 2=paret Sud, 3=paret Est, 4=paret Oest
      int altura;
      if(paret==1){
          altura= rand.nextInt(llargada)+1;
          s= s+"1,"+altura+") N";
      }
      else if (paret==2){
          altura = rand.nextInt(llargada)+1;
          s= s+amplada+","+altura+") S";
      }
      else if (paret==3){
          altura = rand.nextInt(amplada)+1;
          s= s+altura+",10) E";
      }
      else{
          altura = rand.nextInt(amplada)+1;
          s=s+altura+","+1+") W";
      }
      return s;
      
  }
    
 //MÈTODES DE LECTURA DE LABERINT
  
  
  /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
  public void llegirLaberint(String nomFitxer) throws FileNotFoundException{
    Scanner cin = new Scanner(new File (nomFitxer));
    cin.next();
    llargada= cin.nextInt();
    if (llargada >30) throw new NumberFormatException("2 "+llargada);
    if (llargada <0)  throw new NumberFormatException("2 "+llargada);
    cin.next();
    amplada=cin.nextInt();
    if (amplada >30) throw new NumberFormatException("2 "+amplada);
    if (amplada <0)  throw new NumberFormatException("2 "+amplada);
    lab = ferLaberint();
    cin.next();
    String fila = cin.next();
    while(!fila.equals("#")){
        int f = Integer.parseInt(fila);
        String dir = cin.next();
        if (!dir.equals("N")){
            if (!dir.equals("S")){
                if (!dir.equals("E")){
                    if (!dir.equals("W"))throw new NumberFormatException("4 "+dir);
                }
            }
        }
        String paraula= cin.next();
        int ini= extreureNum(paraula);
        int fi= extreureNum(paraula.substring(2));
        if(ini>fi)throw new NumberFormatException("3 "+paraula);
        else if (fi> llargada) throw new NumberFormatException("3 "+paraula);
        else if (ini <1) throw new NumberFormatException("3 "+paraula);
        afegirParet(f,ini,fi,'H',dir);
        fila=cin.next();
    }
    //llegir parets verticals
    cin.next();
    String columna = cin.next();
    while (!columna.equals("#")){
        int f = Integer.parseInt(columna);
        String dir = cin.next();
        if (!dir.equals("N")){
            if (!dir.equals("S")){
                if (!dir.equals("E")){
                    if (!dir.equals("W"))throw new NumberFormatException("4 "+dir);
                }
            }
        }
        
        String paraula= cin.next();
        int ini= extreureNum(paraula);
        int fi= extreureNum(paraula.substring(2));
        if(ini>fi)throw new NumberFormatException("3 "+paraula);
        else if (fi> amplada) throw new NumberFormatException("3 "+paraula);
        else if (ini <1) throw new NumberFormatException("3 "+paraula);
        afegirParet(f,ini,fi,'V',dir);
        columna= cin.next();
    }
    //afegir parets dels voltants
    afegirParet(1,1,llargada,'H',"N");
    afegirParet(1,1,amplada,'V',"O");
    afegirParet(amplada,1,llargada,'H',"S");
    afegirParet(llargada,1,amplada,'V',"E");
    
    numerarSales2();
    //llegir portes
    cin.next();
    String port = cin.next();
    int pos1; int pos2;
    while(!port.equals("#")){
    
        pos1 = extreureNum(port);
        int indexSub=2;
        if (pos1>=10) indexSub++;
        pos2= extreureNum(port.substring(indexSub));
        String dir = cin.next();
        afegirPorta(pos1, pos2, dir);
        port=cin.next();
    }
    //llegir porta entrada
    
    cin.next();
    port= cin.next();
    pos1 = extreureNum(port);
    int indexSub=2;
    if (pos1>=10) indexSub++;
    pos2= extreureNum(port.substring(indexSub));
    String dir = cin.next();
    afegirPorta(pos1, pos2, dir);

  }
  
  
  /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
  private void afegirParet(int posIni, int ini, int fi, char dir, String orientacio){
  
    Paret p= new Paret();
    int i=ini;
    if(dir=='H'){
        while(i<=fi){
            p.AfegirCela(lab[posIni][i]);
            if(orientacio.equals("S")){
                lab[posIni][i].afegirParet(p, 'S');
                if(posIni<amplada){
                    lab[posIni+1][i].afegirParet(p, 'N');
                }
                i++;
                
            }
            else{
                lab[posIni][i].afegirParet(p, 'N');
                if(posIni>1){
                    lab[posIni-1][i].afegirParet(p, 'S');
                }
                i++;
                
            }  
        }
        paretsHoritzontals.add(p);
    }
    else if (dir=='V'){
        while (i<=fi){
            p.AfegirCela(lab[i][posIni]);
            if(orientacio.equals("E")){
                lab[i][posIni].afegirParet(p, 'E');
                if(posIni<llargada){
                    lab[i][posIni+1].afegirParet(p, 'W');
                }
                i++;
                
            }
            else{
            
                lab[i][posIni].afegirParet(p, 'W');
                if(posIni>1){
                lab[i][posIni-1].afegirParet(p, 'E');}
                i++;
                
            }
        }
        paretsVerticals.add(p);
    }
    //p.mostrar();
    //System.out.println("fi paret");
  }
  
  
  /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private void afegirPorta(int x, int y, String dir) throws NumberFormatException{
        //System.out.println("x "+x+ " y "+y+ " dir "+dir);
        Porta p = new Porta(lab[x][y],dir.charAt(0));
        if (lab[x][y].paret(dir.charAt(0))==null) throw new NumberFormatException("1 "+x+" "+y+" "+dir);
        else lab[x][y].paret(dir.charAt(0)).afegirPorta(p);
        if(dir.equals("N")){
            Sala s1=lab[x][y].sala();
            if(x-1>0){
                Sala s2=lab[x-1][y].sala();
                p.afegirSales(s1,s2);
                p.numerarPorta();
            }
            else p.numerarPortaEntrada();
        }
        else if(dir.equals("S")){
            Sala s1=lab[x][y].sala();
            if(x+1<=llargada){    
                Sala s2=lab[x+1][y].sala();
                p.afegirSales(s1,s2);
                p.numerarPorta();
            }
            else p.numerarPortaEntrada();
        }
        else if(dir.equals("E")){
            Sala s1=lab[x][y].sala();
            if(y+1<=llargada){
                Sala s2=lab[x][y+1].sala();
                p.afegirSales(s1,s2);
                p.numerarPorta();
            }
            else p.numerarPortaEntrada();
        }
        else{
            Sala s1=lab[x][y].sala();
            if(y-1>0){
                Sala s2=lab[x][y-1].sala();
                p.afegirSales(s1,s2);
                p.numerarPorta();
            }
            else p.numerarPortaEntrada();
        }
        lab[x][y].afegirPorta(p, dir.charAt(0));
        portes.add(p);
       // System.out.println("fet");
    }
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private int extreureNum(String s){ 
    
        int i =0;
        int numero=-1;
        boolean trobat=false;
        while (!trobat){
            if(s.charAt(i)>='0'){
                if(s.charAt(i)<='9'){
                    trobat=true;
                    numero= Integer.parseInt(String.valueOf(s.charAt(i)));
                }
                
            }
            else i++;
        }
        if(i<s.length()-1){
            if(s.charAt(i+1)>='0'){
                if(s.charAt(i+1)<='9'){
                    numero = numero*10 + Integer.parseInt(String.valueOf(s.charAt(i+1)));
                }   
            }
        }
        return numero;
    }
    
    
   /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private void numerarSales2(){
     
        for(int i = 1;i<=amplada;i++){
            for(int j=1;j<=llargada;j++){
                if (lab[i][j].sala()==null){
                    int auxj=j;
                    Sala s = new Sala(nSales);
                    while(lab[i][auxj].paret('E')==null){
                        auxj++;
                    }
                    int auxi=i;
                    while(lab[auxi][j].paret('S')==null){
                        auxi++;
                    }
                    nSales++;
                    for(int m=i;m<=auxi;m++){
                        for(int n=j;n<=auxj;n++){
                            lab[m][n].afegirSala(s);
                            s.afegirCela(lab[m][n]);
                        }
                    }
                }
                                  
            }
        }
    }
    
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     
     */
    public void mostrar(){
    
        String[][]  tauler = new String [amplada*2+2][llargada*2+2];
        int amplM=amplada*2+1;
        int llargM=llargada*2+1;   
        for(int i=0;i<=amplM;i++){
            for(int j=0;j<=llargM;j++){
                if(i==0) {
                    if(j>1){
                        if(lab[1][j/2].tePorta('N')!=null)tauler[i][j-1]="_";
                        else tauler[i][j]="#";
                    }
                    else tauler[i][j]="#";
                    
                }
                else if (i==amplM) tauler[i][j]="#";
                else{
                    if(j==0) tauler[i][j]="#";
                    else if(j==llargM) tauler[i][j]="#";
                    else tauler[i][j]=" ";
                }
            }
        }
        
        for(int i = 1;i<=amplada;i++){
            for (int j = 1; j<=llargada; j++){
                if(lab[i][j].paret('E')!=null) { //parets verticals
                    if(lab[i][j].tePorta('E')!=null) {
                        tauler[i*2-1][j*2]="|";
                        tauler[i*2][j*2]="#";
                    }
                    else  {
                        tauler[i*2-1][j*2]="#";
                        tauler[i*2][j*2]="#";
                    }
                }
                if(lab[i][j].paret('S')!=null) { //parets Horitzontals
                    if(lab[i][j].tePorta('S')!=null) {
                        tauler[i*2][j*2-1]="_";
                        tauler[i*2][j*2]="#";
                    }
                    else {
                        tauler[i*2][j*2-1]="#";
                        tauler[i*2][j*2]="#";
                    }
                }
            }
        }
        //mostrar
        for(int i=0;i<amplM;i++){
            String fila="";
            for(int j=0;j<llargM;j++){
                fila=fila+tauler[i][j];
            }
            System.out.println(fila);
        }
    }
    
    public Cela[][] laberint(){
        return lab;
    }
    
}
