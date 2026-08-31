
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faisal_alshmrani
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
// TODO code application logic here        
        
        String [] s1;
        s1 = new Scanner (System.in).next().split("\\+");
        
        Arrays.sort(s1);
        
        for (int i = 0; i < s1.length; i++) {
            System.out.print(s1[i]);
            if (i != s1.length -1)
            System.out.print("+");
        }
        
        
    }
    
}
