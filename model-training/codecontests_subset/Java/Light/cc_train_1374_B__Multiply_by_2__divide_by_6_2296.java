import java.lang.*;
import java.math.*;
import java.util.*;

public class Solution{
    static int number(int n){
      int ans = 0;
      if(n==1){
          return 0;
      }
      while(n > 1){
         while(n % 6 == 0){
            n /= 6;
            ans++;
         }
         if(n % 3 == 0){
            n *= 2;
            ans++;
         }
         else{
            if(n == 1){
               return ans;
            }
            else{
                return -1;
            }
         }
     
    }
    return -1;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int n = sc.nextInt();
            System.out.println(number(n));
            t--;
        }
       sc.close(); 
    }
    
    
    
}