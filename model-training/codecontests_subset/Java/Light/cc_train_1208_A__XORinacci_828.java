
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TwoNums {
    
   

    
    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         int t= s.nextInt();
          
         for(int i=1;i<=t;i++){
             
             int a = s.nextInt();
           int b = s.nextInt();
         int n = s.nextInt();
         switch (n%3){
         
             case 0: System.out.println(a);
             break;
             case 1: System.out.println(b);
             break;
             case 2: System.out.println(xor(a,b));
             break;
         
         
         }
         }
        
         
              
    }

    private static int xor(int x, int y) {
     
        int res = 0;
        int i=0;
        int max;
        if (x>=y) max=x;
        else max=y;
        while(max>0)
        {
        
            if ((y % 2) + (x % 2)==1){
            res += Math.pow(2, i);
            }
            i++;
            x=x/2;
            y=y/2;
            max=max/2;
            
        
        }
        return res;
        
    }
}
