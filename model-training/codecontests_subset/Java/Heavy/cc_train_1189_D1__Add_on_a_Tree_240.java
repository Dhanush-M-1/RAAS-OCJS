import java.util.*;
import java.io.*;

public class D572 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        ArrayList<Integer> [] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int x = sc.nextInt(); int y = sc.nextInt();
            adj[x].add(y); adj[y].add(x);
        }
        if (n == 2) {
            out.println("YES");
        } else {
            Set<Integer> par = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                if (adj[i].size() == 1) par.add(adj[i].get(0));
            }
            boolean ok = true;
            for (int i = 1; i <= n; i++) {
                if (adj[i].size() == 2) ok = false;
            }
            out.println(ok ? "YES" :"NO");
        }
        out.close();
    }


    //-----------MyScanner class for faster input----------
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

        String nextLine() {
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