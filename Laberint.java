import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author oriol
 */
public class Laberint {
    private Cela[][] lab;
    private int amplada; // amplada j
    private int llargada; // altura i
    private int nSales;
    private int minimSub;
    private ArrayList<Porta> portes;
    private ArrayList<Paret> paretsVerticals;
    private ArrayList<Paret> paretsHoritzontals;
    
     /**
    * @pre 
    * @post
    */
    public Laberint(){
        amplada = 0;
        llargada = 0;
        nSales=0;
        minimSub=0;
        
    }
    
    
   //GENERACIO ALEATORIA LABERINT
        
    public void generarLaberint2(int ampl, int llarg){
    
        minimSub=3;
        amplada = ampl;
        llargada = llarg;
        lab =ferLaberint();
        iGenerarLaberint(1,amplada,1,llargada,'H');
        
        for (int i = 1; i<=llargada;i++){
            String fila= new String();
            for(int j = 1; j<=amplada;j++){
                fila = fila + lab[i][j].numeroSala()+" ";
            }
            System.out.println(fila);
        }
        numerarSales();
        System.out.println("despres de numeracio");
        for (int i = 1; i<=llargada;i++){
            String fila= new String();
            for(int j = 1; j<=amplada;j++){
                fila = fila + lab[i][j].numeroSala()+" ";
            }
            System.out.println(fila);
        }
        
    }
    
    private Cela[][] ferLaberint(){
    
        int numSala=0;
        ArrayList<Paret> paretsV = new ArrayList<>();
        paretsVerticals=paretsV;
        paretsHoritzontals=paretsV;
        ArrayList<Porta> port= new ArrayList<>();
        portes=port;
        
        Cela[][] nouLab = new Cela[amplada+1][llargada+1];
        for (int i = 1; i<=llargada;i++){
            for (int j = 1; j<=amplada;j++){
                nouLab[i][j] = new Cela();
                Posicio p = new Posicio(i,j);
                nouLab[i][j].afegirPosicio(p);
                nouLab[i][j].afegirSala(numSala);
                numSala++;
                
            }
        }
        return nouLab;
    }
    
    private void iGenerarLaberint(int esq, int dre, int dalt, int baix, char part){
    
        Random rand= new Random();
        int particio;
        //falla
        if(dre-esq>=minimSub){
            if(baix-dalt>=minimSub){
                Paret p= new Paret();
                if(part == 'H'){
                    particio = rand.nextInt((dre - esq) + 1) + esq;
                    for(int i=dalt;i<=baix;i++){
                        p.AfegirCela(lab[i][particio]);
                    }
                    generarPorta(p,'V');
                    paretsVerticals.add(p);
                    iGenerarLaberint(esq,particio,dalt,baix,'V');
                    iGenerarLaberint(particio+1,dre,dalt,baix,'V');
                }
                else {
                    particio = rand.nextInt((baix - dalt) + 1) + dalt;
                    for(int i=esq;i<=dre;i++){
                        p.AfegirCela(lab[particio][i]);
                    }
                    generarPorta(p,'H');
                    paretsHoritzontals.add(p);
                    iGenerarLaberint(esq,dre,dalt,particio,'H');
                    iGenerarLaberint(esq,dre,particio+1,baix,'H');
                }
                nSales++;
            }
            else{
                for(int i =dalt; i<=baix;i++){
                for(int j = esq; j<=dre;j++){
                    lab[i][j].afegirSala(nSales);
                }
            }
            nSales++;
            }
        }
    
        else{
            for(int i =dalt; i<=baix;i++){
                for(int j = esq; j<=dre;j++){
                    lab[i][j].afegirSala(nSales);
                }
            }
            nSales++;
        }
    
    }
    
    
    
    
    
    /**
*
* @pre paret no buida
* @post
*/
    private void generarPorta( Paret par, char dir){
        
        //falta definir porta
        
        int min=0;
        int max=par.mida()-1;
        int pos=0;
        if(par.mida()>0){
            Random rand = new Random();
            pos = rand.nextInt(max+1);
             
        }
        
        Cela c = par.get(pos);
        Porta p = new Porta(c,dir);
        //afegirPorta
        par.afegirPorta(p);
        
        portes.add(p);
        //Acabar de generar la porta 
    }
    
    
    /**
*
* @pre
* @post
*/
    private void numerarSales(){
        ArrayList<Integer> Sales = new ArrayList<Integer>(nSales);
        
        for (int i = 1;i<=llargada;i++){
            for(int j=1;j<=amplada;j++){
                int pos = Sales.indexOf(lab[i][j].numeroSala());
                if(pos==-1){
                    Sales.add(lab[i][j].numeroSala());
                    lab[i][j].afegirSala(Sales.size());
                }
                else{
                    lab[i][j].afegirSala(pos+1);
                }
            }
        }
    }
    
    
    /**
*
* @pre
* @post
*/
  public  void generarFitxer(String nomFitxer) throws FileNotFoundException, UnsupportedEncodingException{
    
    
    System.out.println("n parets horitzontals: "+ paretsHoritzontals.get(0).mida());
    System.out.println("n parets veticals: "+ paretsVerticals.get(0).mida());
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
        altura=paretsHoritzontals.get(i).get(0).posicio().CoordenadaY();
        primer=paretsHoritzontals.get(i).get(0).posicio().CoordenadaX();
        System.out.println("MIDA I: "+i);
        System.out.println("MIDA 2"+ (paretsHoritzontals.size()));
        ultim =paretsHoritzontals.get(i).get(paretsHoritzontals.get(i).mida()-1).posicio().CoordenadaX();
        writer.println(altura + " S " + primer+".."+ultim);
    }
    writer.println("#");
    writer.println("parets_verticals");
    for(int i = 0; i<paretsVerticals.size();i++){
        altura=paretsVerticals.get(i).get(0).posicio().CoordenadaX();
        primer=paretsVerticals.get(i).get(0).posicio().CoordenadaY();
        ultim =paretsVerticals.get(i).get(paretsVerticals.get(i).mida()-1).posicio().CoordenadaY();
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
    writer.close();

        
    }
    
 //MÈTODES DE LECTURA DE LABERINT
  
  void llegirLaberitint(String nomFitxer) throws FileNotFoundException{
  
    Scanner cin = new Scanner(new File (nomFitxer));
    cin.next();
    llargada= cin.nextInt();
    cin.next();
    amplada=cin.nextInt();
    lab = ferLaberint();
    cin.next();
    String fila = cin.next();
    String orientacio= cin.next();
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
    //llegir portes
    cin.next();
    String port = cin.next();
    while(!port.equals("#")){
    
        int pos1 = extreureNum(port);
        int indexSub=2;
        if (pos1>=10) indexSub++;
        int pos2= extreureNum(port.substring(indexSub));
        String dir = cin.next();
        afegirPorta(pos1, pos2, dir);
    }
    //llegir porta entrada
    cin.next();
    int pos1 = extreureNum(port);
    int indexSub=2;
    if (pos1>=10) indexSub++;
    int pos2= extreureNum(port.substring(indexSub));
    String dir = cin.next();
    afegirPorta(pos1, pos2, dir);
    
      
  }
  
  public void afegirParet(int posIni, int ini, int fi, char dir, String orientacio){
  //variar metode per el orientacio 
    Paret p= new Paret();
    if(dir=='H'){
        for(int i=0; i<fi-ini;i++){
            p.AfegirCela(lab[posIni][i]);
            if(orientacio.equals("S")){
                lab[posIni][i].afegirParet(p, 'S');
                lab[posIni+1][i].afegirParet(p, 'N');
            }
            else{
                lab[posIni][i].afegirParet(p, 'N');
                lab[posIni-1][i].afegirParet(p, 'S');
            }  
        }
        paretsHoritzontals.add(p);
    }
    else if (dir=='V'){
        for(int i=0;i<fi-ini;i++){
            p.AfegirCela(lab[i][posIni]);
            if(orientacio.equals("E")){
                lab[i][posIni].afegirParet(p, 'E');
                lab[i][posIni+1].afegirParet(p, 'O');
            }
            else{
            
                lab[i][posIni].afegirParet(p, 'O');
                lab[i][posIni-1].afegirParet(p, 'E');
            }
        }
        paretsVerticals.add(p);
    }
  }
  
    private void afegirPorta(int x, int y, String dir){
    
        Porta p = new Porta(lab[y][x],dir.charAt(0));
        lab[y][x].paret(dir.charAt(0)).afegirPorta(p);
        lab[y][x].afegirPorta(p);
        portes.add(p);
    }
    
    private int extreureNum(String s){
    
        int i =0;
        int numero=-1;
        boolean trobat=false;
        while (!trobat){
            if(s.charAt(i)>='0'){
                if(s.charAt(i)<='9'){
                    trobat=true;
                    numero = s.charAt(i);
                }   
            }
        }
        if(i<s.length()-1){
            if(s.charAt(i+1)>='0'){
                if(s.charAt(i+1)<='9'){
                    numero = numero*10 + s.charAt(i+1);
                }   
            }
        }
        return numero;
    }
    
    private void numerarSales2(){
     nSales=1;
        for(int i = 1;i<=llargada;i++){
            for(int j=1;j<=amplada;j++){
                if(i==1){
                    if  (j==1){
                        lab[i][j].afegirSala(1);
                    }
                            }//primer
                else if(lab[i][j].paret('O')==null){
                    lab[i][j].afegirSala(lab[i][j-1].numeroSala());
                }//mateixa sala que l'anterior(no hi ha paret
                else if(lab[i][j].paret('O')!=null){
                    nSales++;
                    lab[i][j].afegirSala(nSales);
                } //hi ha paret
                
                  
            }
        }
    }
    
}