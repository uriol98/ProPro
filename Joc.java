import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jere
 */
public class Joc{
//Pre:
//Post:
        private ArrayList <personatge> Personatge; 
        private int i; //utilitzada per recorrer arraylist personatges
        private boolean fi;
        private Cela[][] lab = laberint()
        
        public int indexPers(){
            return i;
        }
        
        
        
public void llegirJoc (String nomFitxer){
//Pre:
//Post:

            Scanner cin = new Scanner(new File (nomFitxer));
            cin.next();
            String nomLab = cin.next(); //nom del laberint
            llegirLaberint(nomLab);
            String linia= cin.next();
            int x = extreureNum(linia); //posicio i de la matriu
            int y = extreureNum(linia.substring(2)); //posicio j de la matriu
            afegirTresor(x,y);
            cin.next();
            int capacitatHumans=cin.next();
            cin.next();
            int capacitatObjectes= cin.next();
            cin.next();
            while(!tipus.equals("#")){
                String tipus= cin.next();
                String nom = cin.next();
                String pos= cin.next();
                x=extreureNum(pos);
                y=extreureNum(pos.substring(2));
                CrearPersonatge(tipus,nom,x,y);
                if(tipus.equals("huma")){
                    ArrayList<String> c = new ArrayList();
                    String liniaClaus=cin.next();
                     c= exteureNum2(liniaClaus);
                 }
                 tipus=cin.next();
            }
            cin.next();
            String idClau= cin.next();
            while(!idClau.equals("#")){
            linia=cin.next();
            ArrayList<Posicio> llocClaus= new ArrayList();
            llocClaus= exteureNum2(linia);
 
            }
 
}

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

public ArrayList<String>exteureNum2 (String linia){

     ArrayList<String> vClaus=new ArrayList();
     char c;
     int i=1;
     String id="";
     c=linia.charAt(i);
       while(c!=']'){
       if(c!=','){
         if(c!=')'){
           if(c!='('){
             id=id+c;
           }
         }
         else{
         vClaus.add(id);
         id="";
         }
       }
       else{
         if(linia.charAt(i+1)!='('){
           vClaus.add(id);
           id="";
         }
       }
       i++;
       c=linia.charAt(i);
     }
     return vClaus;
    }

}

  
