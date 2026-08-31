import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main{
    final boolean isFileIO =  false;
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");
    String delim = " ";

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.initIO();
        m.solve();
        m.in.close();
        m.out.close();
    }

    public void initIO() throws IOException {
        if(!isFileIO) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        } else {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt"); 
        }
    }
  
    String nextToken() throws IOException {
        if(!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken(delim);
    }

    String readLine() throws IOException {
        return in.readLine();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    class Pair {
        public int i;
        public long j;
        public Pair(int i, long j) {
            this.i = i;
            this.j = j;
        }
    }

    public void solve() throws IOException {
        long q = nextLong();
        long temp = q;
        ArrayList<Long> primes = new ArrayList<Long>();
        for(long i = 2; i * i <= q; i++) {
            while(q % i == 0) {
                primes.add(i);
                q /= i;
            }
        }
        if(temp == q) {
            out.println(1);
            out.println(0);
        } else {
            if(q != 1) {
                primes.add(q);
            }
            if(primes.size() <= 2) {
                out.println(2);
            } else {
                out.println(1);
                out.println(primes.get(0) * primes.get(1));
            }
        }
    }

}

class Utils {

    public static long binpow(long a, long exp, long mod) {
        if(exp == 0) {
            return 1;
        }
        if(exp % 2 == 0) {
            long temp = binpow(a, exp / 2, mod);
            return (temp * temp) % mod;
        } else {
            return (binpow(a, exp - 1, mod) * a) % mod;
        }
    }

    public static long inv(long a, long mod) {
        return binpow(a, mod - 2, mod);
    }

    public static long addmod(long a, long b, long mod) {
        return ((a + b) % mod + mod) % mod;
    }

    public static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }

    //mul must be < 10^18
    public static long mulmod(long a, long b, long mod) {
        return (a * b + (((a * b) / mod) + 1) * mod) % mod;
    }
}
