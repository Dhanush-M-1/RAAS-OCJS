import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Sheref
 */
public class Algo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    
   String s = new String();
   BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
   s = BR.readLine();
   int []array  = new int[(s.length()/2)+1];
   int z = 0;
   for(int  i =0; i<s.length(); i+=2){
       array[z]  = Character.getNumericValue(s.charAt(i));
       z++;
       
   }
    for (int i = 0; i<array.length-1; i++){
    for(int j   = 0; j<array.length-i-1; j++){
        if(array[j] > array[j+1]){
            
            int temp = array[j];
            array[j] = array[j+1];
            array[j+1] = temp;
        }

        
    }
        
        
        
        
        }
            for(int i=0; i<array.length; i++){
            
            System.out.print(array[i]);
            if(i<array.length-1)
                System.out.print("+");
            }    
    }
}
    

