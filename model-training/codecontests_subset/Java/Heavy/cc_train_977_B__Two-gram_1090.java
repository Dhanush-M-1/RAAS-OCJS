import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        String s = sc.next();
        HashMap<String, Integer> map = new HashMap<>();
        String ans = null;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            String sub = s.substring(i, i + 2);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            if (map.get(sub) > max) {
                max = map.get(sub);
                ans = sub;
            }
        }
        out.println(ans);
        out.close();
    }
}
