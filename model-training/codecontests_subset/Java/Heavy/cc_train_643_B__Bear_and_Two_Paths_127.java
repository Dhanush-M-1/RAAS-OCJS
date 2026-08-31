import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

public class Main {
    private static StreamTokenizer in;
    private static Scanner ins;
    private static PrintWriter out;
    private int[] nearLeft;
    private int[] nearRight;
    private int left;
    private int right;

    public static void main(String[] args) {

        try {
            in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
            ins = new Scanner(System.in);
            out = new PrintWriter(System.out);
            try {
                if (System.getProperty("xDx") != null) {
                    in = new StreamTokenizer(new BufferedReader(new FileReader("input.txt")));
                    ins = new Scanner(new FileReader("input.txt"));
                    out = new PrintWriter(new FileWriter("output.txt"));
                }
            } catch (Exception e) {
                in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
                ins = new Scanner(System.in);
                out = new PrintWriter(System.out);
            }
            new Main().run();
            out.close();
        } catch (Throwable e) {
//            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    private long nextLong() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    private double nextDouble() throws IOException {
        in.nextToken();
        return in.nval;
    }


    private String nextString() throws IOException {
        in.nextToken();
        return in.sval;
    }

    private char nextChar() throws IOException {
        in.nextToken();
        return (char) in.ttype;
    }


    private void run() throws Exception {
        int n = nextInt();
        int k = nextInt();

        int a = nextInt();
        int b = nextInt();
        int c = nextInt();
        int d = nextInt();

        if (n <= 4 || k < n + 1) {
            out.print(-1);
            return;
        }

        int[] path = new int[n];

        path[0] = a;
        path[1] = c;
        path[n - 2] = d;
        path[n - 1] = b;

        int cur = 1;
        for (int i = 2; i < n - 2; i++) {
            while (cur == a || cur == b || cur == c || cur == d) {
                cur++;
            }
            path[i] = cur++;
        }

        for (int i = 0; i < n; i++) {
            out.print(path[i] + " ");
        }

        out.println();

        path[0] = c;
        path[1] = a;
        path[n - 2] = b;
        path[n - 1] = d;

        for (int i = 0; i < n; i++) {
            out.print(path[i] + " ");
        }

    }

    private int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            int k = a % b;
            a = b;
            b = k;
        }

        return a | b;
    }


}