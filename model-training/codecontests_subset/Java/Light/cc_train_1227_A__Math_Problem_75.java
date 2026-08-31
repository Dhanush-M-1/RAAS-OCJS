import java.io.*;
import java.util.*;

public class Solver {
    static ArrayList<Integer> graph[];
    static boolean used[];
    static int mt[];
    static boolean prime[];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = nextInt();
        for (int i = 0; i < t; i++) {
            int n = nextInt();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                int a = nextInt();
                int b = nextInt();
                if (a > max){
                    max = a;
                }
                if (min > b){
                    min = b;
                }
            }
            if(max <= min)pw.println(0);
            else pw.println(Math.abs(max - min));
        }
        pw.close();
    }

    static StringTokenizer st = new StringTokenizer("");
    static BufferedReader br;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}