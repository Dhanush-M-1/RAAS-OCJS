import javax.xml.parsers.DocumentBuilder;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
         br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int candles = nextInt();
        int quant = nextInt();
        int hours = 0;
        int used = 0;
        for (int i = 0;used>=quant || candles > 0; i++) {
            hours+=candles;
            used+=candles;
            candles=used/quant;
            used=used%quant;
        }
        System.out.println(hours);
    }
    static BufferedReader br;
    static StringTokenizer st;

    static String nextToken() {
        try {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(nextToken());
    }

    static long nextLong() {
        return Long.parseLong(nextToken());
    }

    static double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    static String next() {
        return nextToken();
    }
}