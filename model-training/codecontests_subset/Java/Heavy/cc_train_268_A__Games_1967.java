

import java.util.Scanner;


public class JavaApplication1 {

    
    public static void main(String[] args) {
        
        int n; 
        
        Scanner sc = new Scanner(System.in);
        
         n = sc.nextInt();
         
         int h[] = new int [n];
         int a[] = new int [n];
         
         for(int i = 0; i<n; i++) {
             h[i] = sc.nextInt();
             a[i] = sc.nextInt();
         }
          int t = n*(n-1);
          int c =0;
         for(int i =0; i<n; i++) {
             for(int j = 0; j<n; j++){
                 if(i==j){
                     continue;
                 } else{
                     if(h[i] == a[j]){
                     c++;
                     }
                 }
                 
             }
             
         }
         
          System.out.println(c);  
         
    }
    
}
