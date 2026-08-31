
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmadla
 */
public class ll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in =new Scanner (System.in);
      
        boolean f=false,f1;
        int n =in.nextInt();
          int arr[]=new int [n];
          long co=0;long ce=0;
        for (int k= 0; k< n; k++) {
         arr[k] =in.nextInt();
         if(arr[k]%2!=0)
             co++;
         else
             ce++;
        }
        boolean f3=true;
        long c=0;
        long sum=0;
   
         if(co>ce)
         {
         f3=false;
         c=co-ce;
         }else
             c=ce-co;
       
          
    
        c-=1;
        Arrays.sort(arr);
    
         for (int i = 0; i < n; i++) {
             
             if(c<=0)
                break;    
   
             if(f3)
            {
            if(arr[i]%2==0)
            {  sum+=arr[i] ;
            c--;
            }
    
            }
            else
            {
             if(arr[i]%2!=0)
             { sum+=arr[i] ;
             c--;  }
            }
                  
           
        }
       
          System.out.println(sum);
    }
}
