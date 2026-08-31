

import java.util.Scanner;


public class B {
    
    public static void main(String[] args){
      
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        int a = in.nextInt()/2;
        int b = in.nextInt();
        int c = in.nextInt();
        
        int ans = 0;
        
        for( int k = 0; k <= Math.min( n/2 , c ) ; k++){
           int r = n - 2*k;
           if( a + b < r){
             continue;
           }
           
           int p = Math.min(a, r);
           int q  = Math.min(b, r);
           
           
           ans = ans + Math.min(p, q) + 1;
           ans = ans - (r - Math.max(p, q));
        }
        
        System.out.println(ans);
    }
}
