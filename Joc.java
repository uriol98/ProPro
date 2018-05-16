import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.arraylist;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        
        private ArrayList <personatge> Personatge; 
        private int i; //utilitzada per recorrer arraylist personatges
        private boolean fi;
        
        public int indexPers(){
            return i;
        }
		public void llegirF(){
			List<String> lines = Files.readAllLines(Paths.get("c:\\temp\\testfile.txt"));
			for (String line : lines) {
				
			}
		}
        
}
