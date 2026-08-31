import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {


        new Main().solve();
    }

    int mod = 1000000007;

    //15084000000000

    PrintWriter out;

    int n;

    void solve() throws IOException {

        Reader in;

        try {

            in = new Reader("input.txt");
            out = new PrintWriter( new BufferedWriter(new FileWriter("output.txt")) );
        }
        catch (Exception e) {

            in = new Reader();
            out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );
        }

        //BufferedReader br = new BufferedReader( new FileReader("in.txt") );
        //BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        int n = in.nextInt();

        int[] d1 = new int[10010];
        int[] d2 = new int[10010];

        int[] a = new int[n];
        int[] b = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {

            a[i] = in.nextInt();
            sum += a[i];
        }

        for (int i = 0; i < n; i++) {

            b[i] = in.nextInt();
        }

        Arrays.fill(d1, 1000000000);
        d1[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 10000; j >= 0; j--)
                if (j+b[i] <= 10000) {

                    if (d1[j]+1 < d1[j+b[i]]) {
                        d1[j+b[i]] = d1[j]+1;
                        d2[j+b[i]] = d2[j]+a[i];
                    }
                    else
                    if (d1[j]+1 == d1[j+b[i]] && d2[j+b[i]] < d2[j]+a[i])
                    {
                        d2[j+b[i]] = d2[j]+a[i];
                    }
                }
        }

        int k = 10000;
        int min = 0;

        for (int i = sum; i <= 10000; i++) {

            if (d1[i] < k) {
                k = d1[i];
                min = d2[i];
            }
            else
            if (d1[i] == k && min < d2[i]) {
                min = d2[i];
            }
        }

        out.println(k+" "+(sum-min));
        out.flush();
        out.close();
    }

    class Pair implements Comparable<Pair>{

        long a;
        long b;


        Pair(long a, long b) {

            this.a = a;
            this.b = b;
        }

        public int compareTo(Pair p) {

            if (a < p.a)
                return -1;

            if (a > p.a)
                return 1;

            if  (b < p.b)
                return -1;

            if (b > p.b)
                return 1;

            return 0;
        }
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