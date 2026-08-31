import java.io.*;
import java.util.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import java.math.*;

public class Main implements Runnable {
    static Scanner in;
    static PrintWriter out;    

    public void run() {
        int n = in.nextInt(), a = in.nextInt(), b = in.nextInt(), c = in.nextInt(), x, r = 0;
        for (int i = 0; i <= b; i++) {
            for (int j = 0; j <= c; j++) {
                x = n - i - 2 * j;
                if (x >= 0 && 2 * x <= a) r++;
            }
        }
        out.println(r);
        out.close();
    }
    
    int[] array (int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return a;
    }

    int[][] matrix (int n, int m) {
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        //final String FILENAME = "cubroot"; in = new Scanner(new File(FILENAME + ".in")); out = new PrintWriter(new File(FILENAME + ".out"));
        in = new Scanner (System.in); out = new PrintWriter (System.out);
        new Main().run();
    }
}