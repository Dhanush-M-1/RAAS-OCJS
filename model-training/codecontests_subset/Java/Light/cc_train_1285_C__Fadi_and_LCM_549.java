import java.math.BigInteger;
import java.util.*;
public class rc{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in) ;
    long n = sc.nextLong();
    long i,a=0;
    for(i=(int)Math.sqrt(n); i>0; --i){
        if(n%i==0){
           a = n/i;
           if(BigInteger.valueOf(i).gcd(BigInteger.valueOf(a)).equals(new BigInteger("1")))
               break;
        }      
    }
    System.out.println(i+" "+a);
  }
}