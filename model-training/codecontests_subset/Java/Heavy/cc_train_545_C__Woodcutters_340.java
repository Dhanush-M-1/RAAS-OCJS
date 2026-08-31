import java.text.*;
import java.util.*;
import java.io.*;
import java.math.*;

public class CWoodcutters {
    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;


    void solve() throws IOException {
        int n = nextInt();
        if(n == 1){
            out.println(1);
            return;
        }
        long[][] a = new long[n][2];
        for(int i = 0; i < n; i++){
            a[i][0] = nextLong();
            a[i][1] = nextLong();
        }
        long maxRange = a[0][0];
        int maxCut = 1;
        for(int i = 1; i < n-1 ; i++){
            long negSide = a[i][0] - a[i][1];
            long posSide = a[i][0] + a[i][1];
            if(negSide > a[i-1][0] && negSide > maxRange){
                maxCut++;
                maxRange = a[i][0];
                continue;
            }
            else if(posSide < a[i+1][0]){
                maxCut++;
                maxRange = posSide;
                continue;
            }
            else{
                continue;
            }
        }
        out.println(maxCut+1);
    }

    CWoodcutters() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        solve();
        out.close();
    }

    int[] readIntArray(int n) throws IOException {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    long[] readLongArray(int n) throws IOException {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextLong();
        }
        return a;
    }

    void hello() {
        System.out.println("HELLO?");
    }

    int[] charToIntArray(char[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] - '0';
        }
        return b;
    }

    public static void printDoubleArray(int[][] a, int ab, int cd) {
        System.out.print("  ");
        for (int i = 0; i < cd; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < ab; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < cd; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        new CWoodcutters();
    }

    String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }

    String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
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
}