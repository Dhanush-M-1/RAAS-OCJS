import java.io.*;
import java.util.*;
public class Main{
      
      public static long gcd(long a, long b){
          if (a == 0)
              return b;
          return gcd(b % a, a);
      }

      public static long lcm(long a,long b){
        return (a*b)/gcd(a, b);
      }
      
      public static void main(String args[]) throws IOException{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            long x=Long.parseLong(br.readLine());
            long a=1,b=x,c=1,d=x,min=x;
            for(long i=1;i*i<=x;i++){
                if(x%i==0 && i*i!=x){
                    c=i;
                    d=x/i;
                    long l=lcm(c,d);
                    if(l==x){
                          if(Math.max(c,d)<min && Math.max(c,d)!=1){
                              a=c;
                              b=d;
                              min=Math.max(a,b);
                          }
                    }
                }
            }
            System.out.println(a+" "+b);
      }
}