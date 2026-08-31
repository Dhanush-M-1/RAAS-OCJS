import java.math.BigInteger;
import java.util.Scanner;
import java.lang.Math;
import java.util.StringTokenizer;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
   
        int n = scan.nextInt();
        if( n== 1){
            System.out.println(1); return;
        }
        if( n== 2){
            System.out.println(2); return;
        }
        if( n== 3){
            System.out.println(6); return;
        }
        if( n== 4){
            System.out.println(12); return;
        }
            long a = n;
           long b = n-1;
            long c = n-2;
        
     
        
            while( !(gcd(a,c) ==1 && gcd(b,c) == 1) ){
                c--;
            }
            long val1 = a*b*c;
            
            
            a--; b--;
            c = n-3;
            
            while( !(gcd(a,c) ==1 && gcd(b,c) == 1) ){
                c--;
            }
             long val2 = a*b*c;
        System.out.println(Math.max(val1,val2));
            
       
    }
    
    
    public static long gcd(long a, long b){
        if( a<b){
         long temp = a;
         a = b;
         b =temp;
        }
        
        long x = a; long y = b;
        while(y!=0){
            long r = x % y;
            x = y;
            y = r;
        }
        
        return x;
    }
    
    

}