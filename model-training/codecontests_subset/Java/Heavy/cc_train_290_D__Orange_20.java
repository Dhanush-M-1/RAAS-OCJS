import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
 
    static final double eps = 1e-8;
    static final int mod = 1000 * 1000 * 1000 + 7;
    static final BigInteger modB = BigInteger.valueOf(mod);
    static int n;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        pw = new PrintWriter(System.out);
        try {
           String s = sc.next();
           String k = "";
           int n = sc.nextInt();
           s=s.toLowerCase();
           for (int i=0;i<s.length();i++)
           {
               if ((int)s.charAt(i)<n+97)
               {
                   k+=Character.toUpperCase(s.charAt(i));
               }else
               {
                   k+=Character.toLowerCase(s.charAt(i));
               }
           }
           pw.println(k);
        }
        
        finally {
            
            pw.close();
        }
    }


     
     
    


    static StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st ;
    static PrintWriter pw;
    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }
    static long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }
    static double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }
    static String next() throws IOException {
        in.nextToken();
        return in.sval;
    }
    static void outArray(int[] O) {
        for(int i = 0; i < O.length - 1; i++)
            pw.print(O[i] + " ");
        pw.println(O[O.length - 1]);
    }
    static void exit(Object arg)
    {
        pw.println(arg);
        pw.flush();
        System.exit(0);
    }
}