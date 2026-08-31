import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class CF_GoodBye2014_C {

    static int INFINITY = 2000000000;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        sc = new StringTokenizer("");
        sb = new StringBuilder();

        int n = nxtInt();
        int m = nxtInt();

        int books[] = new int[n];
        books = nxtIntArr(n);
        int days[] = new int[m];
        for (int i = 0; i < m; i++) {
            days[i] = nxtInt() - 1;
        }

        int stack[] = new int[n];
        boolean taken[] = new boolean[n];

        int j = 0;
        for (int i = 0; i < m; i++) {
            if (!taken[days[i]]) {
                stack[j] = days[i];
                j++;
            }
            taken[days[i]] = true;
        }
//
//      for (int i = 0; i < n; i++) {
//          System.out.println(stack[i]);
//      }

        long weight = 0;
        for (int i = 0; i < m; i++) {
            int book = stack[0];
            j = 0;
            while (book != days[i]) {
                weight += books[book];
                int temp=book;
                book = stack[j + 1];
                stack[j + 1] = temp;
                j++;
            }
            stack[0] = book;
        }
        System.out.println(weight);

    }// end Main.

    static BufferedReader br;
    static StringTokenizer sc;
    static PrintWriter out;
    static StringBuilder sb;

    static String nxtTok() throws IOException {
        while (!sc.hasMoreTokens()) {
            String s = br.readLine();
            if (s == null)
                return null;
            sc = new StringTokenizer(s.trim());
        }
        return sc.nextToken();
    }

    static int nxtInt() throws IOException {
        return Integer.parseInt(nxtTok());
    }

    static long nxtLng() throws IOException {
        return Long.parseLong(nxtTok());
    }

    static double nxtDbl() throws IOException {
        return Double.parseDouble(nxtTok());
    }

    static int[] nxtIntArr(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nxtInt();
        return a;
    }

    static long[] nxtLngArr(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++)
            a[i] = nxtLng();
        return a;
    }

    static char[] nxtCharArr() throws IOException {
        return nxtTok().toCharArray();
    }

}// end class
