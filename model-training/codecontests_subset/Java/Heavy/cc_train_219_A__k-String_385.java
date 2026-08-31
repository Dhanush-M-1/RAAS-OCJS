
import static java.lang.Math.*;
import java.math.*;
import java.text.DecimalFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int n=in.nextInt();
       String s=in.next();
       int[]a=new int[200];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)]++;
        }
        for (int i = 0; i < 200; i++) {
            if (a[i]%n != 0 && a[i] != 0) {
                System.out.println("-1");
                return;
            }
        }
        int c=n;
        while(c>0){
             for (int i = 0; i < a.length; i++) {
            if (a[i]>=n) {
                for (int j = 0; j < a[i]/n; j++) {
                     System.out.print((char)i);
                }
 
               
              
            }
        }c--;
    }
    }


    static int Obe(long a, long b) {
        BigInteger b1 = new BigInteger("" + a);
        BigInteger b2 = new BigInteger("" + b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }

    static int che(int[] w) {
        Set<Integer> list = new LinkedHashSet<>();
        for (int i = 0; i < w.length; i++) {
            list.add(w[i]);
        }
        return list.size();
    }

    private static ArrayList<BigInteger> fibCache = new ArrayList<BigInteger>();

    static {
        fibCache.add(BigInteger.ZERO);
        fibCache.add(BigInteger.ONE);
    }

    public static BigInteger fib(int n) {
        if (n >= fibCache.size()) {
            fibCache.add(n, fib(n - 1).add(fib(n - 2)));
        }

        return fibCache.get(n);
    }

}