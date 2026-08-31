import java.io.*;
import java.util.*;

public class Task3 {

    public static void main(String[] args) throws IOException {

        new Task3().solve();
    }

    int mod = 1000000007;

    PrintWriter out;

    int n;
    int m;

    long inf = Long.MAX_VALUE;

    //int[][] g = new int[110][110];

    int max = 0;

    long base = (1L << 63);

    //ArrayList<Integer>[] g;

    void solve() throws IOException {

        //Reader in = new Reader("in.txt");
        //out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        Reader in = new Reader();
        PrintWriter out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );

        //BufferedReader br = new BufferedReader( new FileReader("in.txt") );
        //BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        //int n = in.nextInt();

        int[] z = new int[110];

        String s = in.nextLine();

        int cnt = 0;

        int c1 = 0;
        int c2 = 0;

        StringTokenizer tok = new StringTokenizer(s);

        int n = 0;

        while (tok.hasMoreElements()) {

            String t = tok.nextToken();

            if (t.equals("+")) {
                z[cnt++] = 1;
                c1++;
            }

            if (t.equals("-")) {
                z[cnt++] = 2;
                c2++;
            }

            if (!tok.hasMoreElements())
                n = Integer.valueOf(t);
        }

        if (cnt == 0) {

            System.out.println("Possible");
            System.out.println(n+" = "+n);
            return;
        }

        c1++;

        if (c1*n - c2 < n || c1 - c2*n > n) {

            System.out.println("Impossible");
            return;
        }

        int dif = n - (c1 - c2);

        int[] res = new int[cnt+1];
        Arrays.fill(res, 1);
        int pos = 0;

        while (dif > 0) {

            if (pos == 0 || z[pos-1] == 1) {

                res[pos] += Math.min(dif, n-1);
                dif -= Math.min(dif, n-1);
            }

            pos++;
        }

        while (dif < 0) {

            if (pos > 0 && z[pos-1] == 2) {

                res[pos] += Math.min(Math.abs(dif), n-1);
                dif += Math.min(Math.abs(dif), n-1);
            }

            pos++;
        }


        out.println("Possible");

        for (int i = 0; i < cnt+1; i++)
            if (i == 0)
                out.print(res[i]);
            else {
                out.print(z[i-1] == 1 ? " + " : " - ");
                out.print(res[i]);
            }

        out.print(" = ");
        out.print(n);

        out.flush();
        out.close();
    }

    long gcd(long a, long b) {

        if (b == 0)
            return a;

        return gcd(b, a%b);

    }


    class Item {

        int a;
        int b;
        int c;

        Item(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

    }

    class Pair implements Comparable<Pair>{

        int a;
        int b;
        int i;

        Pair(int a, int b, int i) {

            this.a = a;
            this.b = b;
            this.i = i;
        }

        public int compareTo(Pair p) {

            if (a > p.a)
                return 1;

            if (a < p.a)
                return -1;

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