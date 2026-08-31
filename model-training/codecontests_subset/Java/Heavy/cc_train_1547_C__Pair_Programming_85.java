import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        SolveQue solveQue = new SolveQue();
        solveQue.ques();
    }
}

class SolveQue {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    private static final FastScanner fs = new FastScanner();
    private static final Scanner sc = new Scanner(System.in);
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = (long) (1e9 + 7);
    private static PrintWriter out = new PrintWriter(System.out);
    private static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int iInf = Integer.MAX_VALUE - (int) (1e6);
    private static final long lInf = Long.MAX_VALUE - (long) (1e6);
    private static int[] phi;

    /** Optimal(Maximum,Minimum) Answers
     * 1. Binary search
     * 2. Prefix Suffix
     * 3. Greedy (sorting searching)
     * 4. DP
     **/
    void solve(int T) throws IOException {
        int k = fs.nextInt();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];

        for (int i = 0; i < n; i++) {
            a[i] = fs.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = fs.nextInt();
        }
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (a[i] == 0) {
                ans.add(a[i]);
                k++;
                i++;
                continue;
            }
            if (b[j] == 0) {
                ans.add(b[j]);
                k++;
                j++;
                continue;
            }
            if (a[i] > 0 && b[j] > 0) {
                if (a[i] <= b[j]) {
                    if (a[i] > k) {
                        System.out.println(-1);
                        return;
                    }
                    ans.add(a[i]);
                    i++;
                }
                else {
                    if (b[j] > k) {
                        System.out.println(-1);
                        return;
                    }
                    ans.add(b[j]);
                    j++;
                }
            }
        }
        while (i < n) {
            if (a[i] > k) {
                System.out.println(-1);
                return;
            }
            if (a[i] == 0) k++;
            ans.add(a[i++]);
        }
        while (j < m) {
            if (b[j] > k) {
                System.out.println(-1);
                return;
            }
            if (b[j] == 0) k++;
            ans.add(b[j++]);
        }
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    void ques() throws IOException {
        int t = 1;
//        t = sc.nextInt();
        t = fs.nextInt();
//        t = Integer.parseInt(br.readLine());
        int tt = 1;
        while (t-- > 0) {
            solve(tt);
            tt++;
        }
        System.gc();
    }
}