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


    class Book {
        public int number, weight;
        public Book(int number, int weight) {
            this.number = number;
            this.weight = weight;
        }
    }

    public void solve() throws IOException {
        int n, m;
        n = nextInt(); m = nextInt();
        int[] w = new int[n];
        int[] b = new int[m];
        Book[] books = new Book[n];
        for(int i = 0; i < n; i++) {
            w[i] = nextInt();
            books[i] = new Book(i, w[i]);
        }
        for(int i = 0; i < m; i++) {
            b[i] = nextInt();
        }
        LinkedList<Book> ll = new LinkedList<Book>();
        for(int i = 0; i < m; i++) {
            if(!ll.contains(books[b[i] - 1])) {
                ll.addLast(books[b[i] - 1]);
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++) {
            Iterator it = ll.iterator();
            int weight = 0;
            Book cur = null;
            while(it.hasNext()) {
                cur = (Book)it.next();
                if(cur == books[b[i] - 1]) {
                    ans += weight;
                    break;
                } else {
                    weight += cur.weight;
                }
            }
            ll.remove(cur);
            ll.addFirst(cur);
        }
        out.println(ans);
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
