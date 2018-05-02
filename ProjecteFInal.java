

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author oriol
 */
public class ProjecteFInal {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        
        Laberint lab = new Laberint();
        lab.generarLaberint2(10,10);
        lab.generarFitxer("prova.txt");
    }
    
}
