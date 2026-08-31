import java.io.*;
import java.util.*;
import java.math.*;

public class Timus {
    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer st;
    static Random rnd;
    
    static boolean isPrime(long a) {
        if(a <= 1) return false;
        if(a == 2) return true;
        
        if(a <= 1000) {
            for(long i = 2; i * i <= a; i++) {
                if(a % i == 0)
                    return false;
            }
            
            return true;
        } else {
            return BigInteger.valueOf(a).isProbablePrime(32);
        }
    }

    static void solve() throws IOException {
        long q = nextLong();
        
        if(q == 1 || isPrime(q)) {
            out.println(1);
            out.println(0);
            return;
        }
        
        ArrayList<Long> divs = new ArrayList<Long>();
        
        for(long i = 2; i * i <= q; i++) {
            if(q % i == 0) {
                long j = q / i;
                
                if(i != 1 && i != q && isPrime(i))
                divs.add(i);
                
                if(i != j && j != 1 && j != q && isPrime(j))
                    divs.add(j);
            }
        }
        
        Collections.sort(divs);
        
        long result = Long.MAX_VALUE;
        
        search:
        for(long d1 : divs) {
            for(long d2 : divs) {
                long r = d1 * d2;
                
                if(r != 1 && r < q && q % r == 0) {
                    result = r;
                    break search;
                }
            }
        }
        
        if(result == Long.MAX_VALUE) {
            out.println(2);
        } else {
            out.println(1);
            out.println(result);
        }
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            rnd = new Random();

            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(42);
        }
    }

    static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = in.readLine();

            if (line == null)
                return null;

            st = new StringTokenizer(line);
        }

        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}