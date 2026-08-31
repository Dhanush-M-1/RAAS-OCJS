
import com.sun.org.apache.bcel.internal.generic.ALOAD;
import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import javafx.util.Pair;
import jdk.nashorn.internal.ir.BreakNode;
public class Fff {
 
   static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
static   StringBuilder out=new StringBuilder();
 static  BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
 static PrintWriter pw=new PrintWriter(new OutputStreamWriter(System.out));
    static int I(String s) {return Integer.parseInt(s);}
    static long L(String s) {return Long.parseLong(s);}
    static double D(String s) {return Double.parseDouble(s);}
     static String[] SA() throws IOException {return bf.readLine().split(" ");}
    
    public static void main(String[] args) throws IOException {
 
       
        long n = L(bf.readLine());
     long a=0;
     long b=0;
     for(long i=1;i*i<=n;i++){
     if(n%i==0){
         if(lcm(i,n/i,n)){
     a=i;
     b=n/i;
     }}
     }
            System.out.print(a+" "+b);
      
        
    }
    static boolean lcm(long a,long b,long n){
    long gcd=gcd(a, b);
    if((a*b)/gcd==n){return true;}
    else{return false;}
    }
 
  static long gcd(long a,long b){
  
      if(b==0){return a;}
      
      return gcd(b, a%b);
  
  }
 
}