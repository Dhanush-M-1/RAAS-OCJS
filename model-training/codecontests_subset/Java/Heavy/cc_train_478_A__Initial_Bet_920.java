import java.io.*;
import java.util.*;
import java.util.List;

public class B {
    private static StringTokenizer st;
    private static BufferedReader br;
    public static int MOD = 1000000007;
    public static long tenFive = 100000;

    public static void print(Object x) {
        System.out.println(x + "");
    }
    public static void printArr(int[] x) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            s.append(x[i] + " ");
        }
        print(s);
    }
    public static String join(List<?> x, String space) {
        StringBuilder sb = new StringBuilder();
        for (Object elt : x) {
            sb.append(elt);
            sb.append(space);
        }
        return sb.toString();
    }

    public static String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            st = new StringTokenizer(line.trim());
        }
        return st.nextToken();
    }
    public static int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public static long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public static List<Integer> nextInts(int N) throws IOException {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            ret.add(nextInt() - 1);
        }
        return ret;
    }

    public static int rep(int x, int[] parents) {
        if (parents[x] == -1) return x;
        return rep(parents[x], parents);
    }

    public static void union(int x, int y, int[] parents) {
        x = rep(x, parents);
        y = rep(y, parents);
        if (x == y) return;
        parents[x] = y;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        for (int i = 0; i < 5; i++) total += nextInt();
        if (total < 5) print(-1);
        else if (total % 5 != 0) print(-1);
        else print(total / 5);
    }
}
