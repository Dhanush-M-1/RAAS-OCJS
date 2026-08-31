import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class Task2 {

    public static void main(String[] args) throws IOException {

        new Task2().solve();

    }

    int mod = 1000000007;

    PrintWriter out;

    int n;
    int m;

    ArrayList<Integer>[] g;

    void solve() throws IOException {

        //Reader in = new Reader("in.txt");
        //out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        Reader in = new Reader();
        PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );

        //BufferedReader br = new BufferedReader( new FileReader("in.txt") );
        //BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = in.nextInt();
        int k = in.nextInt()-1;

        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int cnt = 1;

        while (k >= cnt) {

            k -= cnt;
            cnt += 1;
        }

        out.println(a[k]);
        out.flush();
        out.close();
    }

    class Pair implements Comparable<Pair>{

        int a;
        int b;


        Pair(int a, int b) {

            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {

            if (b > p.b)
                return 1;

            if (b < p.b)
                return -1;

            return 0;
        }

        //		@Override
        //		public boolean equals(Object o) {
        //			Pair p = (Pair) o;
        //			return a == p.a && b == p.b;
        //		}
        //
        //		@Override
        //		public int hashCode() {
        //			return Integer.valueOf(a).hashCode() + Integer.valueOf(b).hashCode();
        //		}

    }

    class Reader {

        BufferedReader  br;
        StringTokenizer tok;

        Reader(String file) throws IOException {
            br = new BufferedReader( new FileReader(file) );
        }

        Reader() throws IOException {
            br = new BufferedReader( new InputStreamReader(System.in) );
        }

        String next() throws IOException {

            while (tok == null || !tok.hasMoreElements())
                tok = new StringTokenizer(br.readLine());
            return tok.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.valueOf(next());
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.valueOf(next());
        }

        double nextDouble() throws NumberFormatException, IOException {
            return Double.valueOf(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

    }

}