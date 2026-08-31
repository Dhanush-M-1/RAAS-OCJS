import java.util.*;
import java.io.*;

public class _1374E {
    static int[] MODS = {1000000007, 998244353, 1000000009};
    static int MOD = MODS[0];

    public static void main(String[] args) {
        sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int k = sc.nextInt();
        PriorityQueue<Integer>[] pq = new PriorityQueue[3];
        for (int i = 0; i < 3; i++) {
            pq[i] = new PriorityQueue<>();
        }
        for (int i = 0; i < n; i++) {
            int time = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x == 1 && y == 1) {
                pq[0].add(time);
            } else if (x == 1) {
                pq[1].add(time);
            } else if (y == 1) {
                pq[2].add(time);
            }
        }
        for (int i = 0; i < 3; i++) {
            pq[i].add(1000000);
        }
        long time = 0;
        int count = 0;
        while (count < k) {
            if (pq[0].peek() >= 1000000 && pq[1].peek() + pq[2].peek() >= 1000000) {
                break;
            }
            int a = pq[0].peek();
            int b = pq[1].peek();
            int c = pq[2].peek();
            if (a <= b + c) {
                time += a;
                pq[0].poll();
            } else {
                time += b + c;
                pq[1].poll();
                pq[2].poll();
            }
            count++;
        }
        if (count < k) {
            out.println(-1);
        } else {
            out.println(time);
        }
        out.close();
    }

    public static int[] sort(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void scan(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static MyScanner sc;
    public static PrintWriter out;

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
