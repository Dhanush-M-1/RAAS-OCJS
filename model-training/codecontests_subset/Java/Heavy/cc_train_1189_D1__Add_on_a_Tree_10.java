import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class D {
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static MyScanner sc = new MyScanner();

    public static void main(String[] args) {
        doTask();
        out.flush();
    }

    public static void doTask(){
        int n = sc.nextInt();
        int[] nodes = new int[n + 1];
        int v,u;
        for (int i = 0; i<n-1;i++) {
            v = sc.nextInt();
            u = sc.nextInt();
            nodes[v]++;
            nodes[u]++;
        }
        boolean res = true;
        for (int i = 1; i<=n;i++) {
//            result += Math.max(0, (nodes[i] + 1)/2 - 1);
            if (nodes[i] == 2) {
                res = false;
            }
        }
        out.println(res ? "YES" : "NO");
    }

    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
}