import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        ArrayList<Integer> both = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int aa = sc.nextInt();
            int bb = sc.nextInt();
            if (aa == 1 && bb == 1) both.add(x);
            else if (aa == 1) a.add(x);
            else if (bb == 1) b.add(x);
        }
        Collections.sort(a);
        Collections.sort(b);
        Collections.sort(both);
        int rem1 = k;
        int rem2 = k;
        int i = 0;
        int j = 0;
        int l = 0;
        long ans = 0;

        while (rem1 > 0 && rem2 > 0 && l < both.size() && i < a.size() && j < b.size()) {

            if (a.get(i) + b.get(j) < both.get(l)) {
                rem1--;
                rem2--;
                ans += a.get(i++) + b.get(j++);
            } else {
                rem1--;
                rem2--;
                ans += both.get(l++);
            }
        }
        if (i == a.size() || j == b.size()) {
            while (l < both.size() && rem1 > 0) {
                ans += both.get(l++);
                rem1--;
                rem2--;
            }
        } else {
            while (rem1 > 0 && i < a.size()) {
                rem1--;
                ans += a.get(i++);
            }
            while (rem2 > 0 && j < b.size()) {
                rem2--;
                ans += b.get(j++);
            }
        }
        if (rem1 > 0 || rem2 > 0) {
            pw.println(-1);
        } else pw.println(ans);

        pw.flush();
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++)
                arr[i] = nextInt();
            return arr;
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}