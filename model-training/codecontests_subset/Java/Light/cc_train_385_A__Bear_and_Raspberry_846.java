/**
 *
 * @author Faruk
 */

import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;


public class tmp {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        
        int n = scan.nextInt();
        int c = scan.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scan.nextInt();
        int rasp = 0;
        for(int i=0; i<n-1; i++)
            if(arr[i]-arr[i+1]-c > rasp)
                rasp = arr[i]-arr[i+1]-c;

        System.out.println(rasp);       
                
                
                
                


        
        

        
        
        
        






        
        
        
        
    }

    
    
    
    
}
