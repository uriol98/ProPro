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
    private Cela[][] lab;
    private int amplada; // amplada i
    private int llargada; // altura j
    private int nSales;
    private int minimSub;
    private ArrayList<Porta> portes;
    private ArrayList<Paret> paretsVerticals;
    private ArrayList<Paret> paretsHoritzontals;
    private ArrayList<Sala> sales;
    
     /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public Laberint(){
        amplada = 0;
        llargada = 0;
        nSales=1;
        minimSub=0;
        
    }
    
    
   //GENERACIO ALEATORIA LABERINT
      
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    public void generarLaberint(int ampl, int llarg, int minimSub){
    
        this.minimSub=minimSub;
        amplada = ampl;
        llargada = llarg;
        lab =ferLaberint();
        iGenerarLaberint(1,amplada,1,llargada,'H');
        
    }
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
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
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private void iGenerarLaberint(int esq, int dre, int dalt, int baix, char part){
    // es podrien afegir a les celes si es te paret, pero no sembla estrictament necessari, ja que
    // aquests algorismes son nomes de generacio del laberint
    // fa particions del mateix valor i aixo fa que es generi una altra paret
        Random rand= new Random();
        int particio;
        /*if(dre-esq>=minimSub){
            if(baix-dalt>=minimSub){
                Paret p= new Paret();
                if(part == 'V'){ //ara farem parets verticals
                    particio = rand.nextInt((dre - esq+1)) + esq;
                    for(int i=dalt;i<=baix;i++){
                        p.AfegirCela(lab[i][particio]);
                        //System.out.println(lab[particio][i].posicio().CoordenadaX()+" "+lab[particio][i].posicio().CoordenadaY());
                    }
                    p.mostrar();
                    generarPorta(p,'V');
                    paretsVerticals.add(p);
                    nSales++;
                    iGenerarLaberint(esq,particio,dalt,baix,'H');
                    iGenerarLaberint(particio+1,dre,dalt,baix,'H');
                }
                else { //ara farem parets horitzontals
                    particio = rand.nextInt((baix - dalt+1)) + dalt;
                    for(int i=esq;i<=dre;i++){
                        p.AfegirCela(lab[particio][i]);
                    }
                    generarPorta(p,'H');
                    paretsHoritzontals.add(p);
                    nSales++;
                    iGenerarLaberint(esq,dre,dalt,particio,'V');
                    iGenerarLaberint(esq,dre,particio+1,baix,'V');
                }
                
            }

        }
        */
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
        System.out.println("V "+esPotV+ " H "+esPotH);
        if(part=='V'){
            Paret p = new Paret();
            System.out.println("dre "+dre+" esq "+esq+ " dalt "+dalt+ " baix "+baix+" particio "+part);
            particio=rand.nextInt((dre-esq)-1)+esq+1;
            for(int i=dalt;i<=baix;i++){
                p.AfegirCela(lab[i][particio]);
            }
            
            p.mostrar();
            generarPorta(p,'V');
            paretsVerticals.add(p);
            nSales++;
            iGenerarLaberint(esq,particio,dalt,baix,'H');
            iGenerarLaberint(particio+1,dre,dalt,baix,'H');
        }
        else if (part=='H'){
            Paret p = new Paret();
            System.out.println("dre "+dre+" esq "+esq+ " dalt "+dalt+ " baix "+baix+" particio "+part);
            particio=rand.nextInt((baix-dalt)-1)+dalt+1;
            for(int i=esq;i<=dre;i++){
                p.AfegirCela(lab[particio][i]);
            }
            p.mostrar();
            generarPorta(p,'H');
            paretsHoritzontals.add(p);
            nSales++;
            iGenerarLaberint(esq,dre,dalt,particio,'V');
            iGenerarLaberint(esq,dre,particio+1,baix,'V');
        }

    }
    
    
    
    
    
    /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private void generarPorta( Paret par, char dir){
        
        Random rand = new Random();
        if (par.mida()==0){ 
            System.out.println("aqui tarat");
        }
        int probabilitat = rand.nextInt(100);
        if(probabilitat>40){
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
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
  public  void generarFitxer(String nomFitxer) throws FileNotFoundException, UnsupportedEncodingException{
    
    
    //es generen parets de mida 1 que no serveixen per res
    //System.out.println("n parets horitzontals: "+ paretsHoritzontals.get(0).mida());
    //System.out.println("n parets veticals: "+ paretsVerticals.get(0).mida());
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
        System.out.println("MIDA I: "+i);
        //System.out.println("MIDA 2"+ (paretsHoritzontals.size()));
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
        char orientacio;
        if (portes.get(i).Orientacio()=='V') orientacio='E';
        else orientacio='S';
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
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
  private String generarPortaEntrada(){
      String s="(";
      Random rand = new Random();
      int paret = rand.nextInt(4)+1; //1 =paret Nord, 2=paret Sud, 3=paret Est, 4=paret Oest
      int altura;
      System.out.println(paret);
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
  public void llegirLaberitint(String nomFitxer) throws FileNotFoundException{
    Scanner cin = new Scanner(new File (nomFitxer));
    cin.next();
    llargada= cin.nextInt();
    cin.next();
    amplada=cin.nextInt();
    lab = ferLaberint();
    cin.next();
    String fila = cin.next();
    while(!fila.equals("#")){
        int f = Integer.parseInt(fila);
        String dir = cin.next();
        String paraula= cin.next();
        int ini= extreureNum(paraula);
        int fi= extreureNum(paraula.substring(2));
        afegirParet(f,ini,fi,'H',dir);
        fila=cin.next();
    }
    //llegir parets verticals
    cin.next();
    String columna = cin.next();
    while (!columna.equals("#")){
        int f = Integer.parseInt(columna);
        String dir = cin.next();
        String paraula= cin.next();
        int ini= extreureNum(paraula);
        int fi= extreureNum(paraula.substring(2));
        afegirParet(f,ini,fi,'V',dir);
        columna= cin.next();
    }
    //afegir parets dels voltants
    afegirParet(1,1,llargada,'H',"N");
    afegirParet(1,1,amplada,'V',"O");
    afegirParet(amplada,1,llargada,'H',"S");
    afegirParet(llargada,1,amplada,'V',"E");
    
    numerarSales2();
     for (int i = 1; i<=amplada;i++){
            String fil= new String();
            for(int j = 1; j<=llargada;j++){
                fil = fil + lab[i][j].sala().numeroSala()+" ";
            }
            System.out.println(fil);
        }
    //llegir portes
    cin.next();
    String port = cin.next();
    int pos1; int pos2;
    while(!port.equals("#")){
    
        pos1 = extreureNum(port);
        int indexSub=2;
        System.out.println(port);
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
    p.mostrar();
    System.out.println("fi paret");
  }
  
  
  /**
     @brief
     @pre 
     @post La sala s'ha creat amb una llargada de llarg i una amplada de ampl
     */
    private void afegirPorta(int x, int y, String dir) throws NumberFormatException{
        System.out.println("x "+x+ " y "+y+ " dir "+dir);
        Porta p = new Porta(lab[x][y],dir.charAt(0));
        if (lab[x][y].paret(dir.charAt(0))==null) throw new NumberFormatException("1");
        else lab[x][y].paret(dir.charAt(0)).afegirPorta(p);
        lab[x][y].afegirPorta(p);
        portes.add(p);
        System.out.println("fet");
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
     System.out.println("Estic numerant");
     
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
        String fila="";
        for (int i = 1; i<=llargada;i++){
            fila = fila +"#";
        }
         System.out.println(fila);
        for(int i=1;i<=amplada;i++){
            fila="#";
            for(int j=1;j<=llargada;j++){ // mirar parets verticals
                if(lab[i][j].paret('E')==null) fila=fila+" ";
                else{ 
                    Porta p= lab[i][j].tePorta();
                    if(p!=null){
                        if (p.Estat()=='T') fila=fila+"|";
                        else fila=fila+" ";
                     }
                    else fila = fila+"#";
                }
            }
            fila=fila+"#";
            System.out.println(fila);
            for (int j=1;j<=llargada;j++){
                if(lab[i][j].paret('S')==null) fila=fila+" ";
                else{ 
                        Porta p= lab[i][j].tePorta();
                        if(p!=null){
                            if (p.Estat()=='T') fila=fila+"_";
                            else fila=fila+" ";
                     }
                    else fila = fila+"#";
                }
            }
            fila=fila+"#";
            System.out.println(fila);
            
        }
        for (int i = 1; i<=llargada;i++){
            fila = fila +"#";
        }
         System.out.println(fila);
    }
    
}
