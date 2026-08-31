/**
 *
 * @author Faruk
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;


public class tmp {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int [] c1 = new int[101];
        int [] c2 = new int[101];
        int out=0;
    
        for(int i=0; i<n; i++){
            c1[scan.nextInt()]++;
            c2[scan.nextInt()]++;
        }
        for(int i = 0; i < 101; i++)
            out += c1[i]*c2[i];
        System.out.println(out);
        

        

        
        
         
        
            
        
        
        
        
        
        
    }
    

}
