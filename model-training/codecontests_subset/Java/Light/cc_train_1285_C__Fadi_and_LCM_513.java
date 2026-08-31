import java.util.*;
public class FADI{
   public static void main(String args[]){
     Scanner sc = new Scanner(System.in);
     long x = sc.nextLong();
     long a = (long)Math.pow(x,0.5);
     long b = (long)(x/a) ;
     while(x%a != 0 || gcd(a,b)!=1){
         a--;
         b=(long)(x/a) ;
      }
     System.out.println(a+" "+b);
   }
static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 

}