import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            Map<Integer, ArrayList<Camel>> map = new HashMap<>();
            for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
            Camel[] c = new Camel[n];
            long base = 0;
            for (int i = 0; i < n; i++) {
                int split = sc.nextInt();
                long l = sc.nextInt();
                long r = sc.nextInt();
                c[i] = new Camel(l - r, split - 1);
                map.get(c[i].split).add(c[i]);
                base += Math.min(l, r);
            }
            Arrays.sort(c, Comparator.comparingInt(a -> a.split));
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                for (Camel camel : map.get(i)) {
                    if (camel.dif < 0) continue;
                    pq.add(camel.dif);
                    base += camel.dif;
                }
                while (pq.size() > i + 1) {
                    long bestRemove = pq.poll();
                    base -= bestRemove;
                }
            }
            pq = new PriorityQueue<>();
            for (int i = n - 1; i >= 0; i--) {
                for (Camel camel : map.get(i)) {
                    if (camel.dif >= 0) continue;
                    pq.add(-camel.dif);
                    base += -camel.dif;
                }
                while (pq.size() > n - i - 1) {
                    long bestRemove = pq.poll();
                    base -= bestRemove;
                }
            }
            out.println(base);
            t--;
        }
        out.close();
    }

    static class Camel {
        long dif; int split;
        Camel(long dif, int split) {
            this.dif = dif; this.split =split;
        }
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