import java.io.*;
import java.util.*;

public class A {
    public static void main(String[] args) throws Throwable {

        Scanner sc = new Scanner();
        PrintWriter pw = new PrintWriter(System.out);

        n = sc.nextInt();
        damage = new ArrayList[n][4];
        for (int i = 0; i < n; i++)
            for (int j = 1; j <= 3; j++)
                damage[i][j] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            while (k-- > 0) {
                int c = sc.nextInt();
                int d = sc.nextInt();
                damage[i][c].add(d);
            }
        }

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return -Integer.compare(a, b);
            }
        };

        for (int i = 0; i < n; i++)
            for (int j = 1; j <= 3; j++)
                Collections.sort(damage[i][j], com);
        mem = new Long[n][10];
        pw.println(dp(0, 0));
        pw.close();
    }

    static int n;
    static ArrayList<Integer>[][] damage;
    static Long[][] mem;


    static long dp(int i, int j) {
        if (i == n)
            return 0;
        if (mem[i][j] != null)
            return mem[i][j];
        long ans = dp(i + 1, j);

//        Single Card
        for (int k = 1; k <= 3; k++)
            if (damage[i][k].size() > 0) {
                long curAns = dp(i + 1, (j + 1) % 10) + damage[i][k].get(0);
                if (j == 9)
                    curAns += damage[i][k].get(0);
                ans = Math.max(ans, curAns);
            }
//        Two Ones
        if (damage[i][1].size() > 1) {
            long curAns = dp(i + 1, (j + 2) % 10) + damage[i][1].get(0) + damage[i][1].get(1);
            if (j >= 8)
                curAns += damage[i][1].get(0);
            ans = Math.max(ans, curAns);
        }
//        One and Two
        if (damage[i][1].size() > 0 && damage[i][2].size() > 0) {
            long curAns = dp(i + 1, (j + 2) % 10) + damage[i][1].get(0) + damage[i][2].get(0);
            if (j >= 8)
                curAns += Math.max(damage[i][1].get(0), damage[i][2].get(0));
            ans = Math.max(ans, curAns);
        }
//        Three Ones
        if (damage[i][1].size() > 2) {
            long curAns = dp(i + 1, (j + 3) % 10) + damage[i][1].get(0) + damage[i][1].get(1) + damage[i][1].get(2);
            if (j >= 7)
                curAns += damage[i][1].get(0);
            ans = Math.max(ans, curAns);
        }

        return mem[i][j] = ans;
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String s) throws Throwable {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() throws Throwable {
            if (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws Throwable {
            return Integer.parseInt(next());
        }

        long nextLong() throws Throwable {
            return Long.parseLong(next());
        }

    }

}
