import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E1_ReadingBooks_1600 {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] data = new int[n][3];
        PriorityQueue<Integer> both = new PriorityQueue<>();
        PriorityQueue<Integer> alice = new PriorityQueue<>();
        PriorityQueue<Integer> bob = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = sc.nextInt();
            }
            if (data[i][1] == data[i][2] && data[i][1] == 1) {
                both.add(data[i][0]);
            } else if (data[i][1] == 1) {
                alice.add(data[i][0]);
            } else if (data[i][2] == 1) {
                bob.add(data[i][0]);
            }
        }
        while (!alice.isEmpty() && !bob.isEmpty()) {
            int x = alice.poll();
            int y = bob.poll();
            both.add(x + y);
        }
        if (both.size() < k) {
            out.println(-1);
        } else {
            int result = 0;
            for (int i = 0; i < k; i++) {
                result += both.poll();
            }
            out.println(result);
        }
        out.close();
    }


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


