import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class D {

    static int NUM_PEOPLE, NUM_KEYS, OFFICE_POS;
    static int[] personPos, keyPos;
    static long[][] memo;

    static long dp (int person, int key) {
        if (NUM_PEOPLE - person > NUM_KEYS - key) return (long)1e16;
        if (person == NUM_PEOPLE) return 0;
        if (memo[person][key] != -1) return memo[person][key];

        long res = (long)1e16;
        // take
        if ((personPos[person] - keyPos[key] > 0 ? 1 : -1) != (personPos[person] - OFFICE_POS > 0 ? 1 : - 1))
            res = Math.max(2 * Math.abs(personPos[person] - keyPos[key]) + Math.abs(personPos[person] - OFFICE_POS)
                    , dp(person + 1, key + 1));
        else
             if (Math.abs(personPos[person] - keyPos[key]) < Math.abs(personPos[person] - OFFICE_POS))
                 res = Math.max(Math.abs(personPos[person] - OFFICE_POS), dp(person + 1, key + 1));
        else res = Math.max(Math.abs(personPos[person] - keyPos[key]) + Math.abs(OFFICE_POS - keyPos[key]), dp(person + 1, key + 1));
        // leave
        res = Math.min(res, dp(person, key + 1));
        return memo[person][key] = res;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        NUM_PEOPLE = sc.nextInt();
        NUM_KEYS = sc.nextInt();
        OFFICE_POS = sc.nextInt();
        personPos = new int[NUM_PEOPLE];
        keyPos = new int[NUM_KEYS];
        for (int i = 0; i < NUM_PEOPLE; i++) personPos[i] = sc.nextInt();
        for (int i = 0; i < NUM_KEYS; i++) keyPos[i] = sc.nextInt();

        Arrays.sort(personPos); Arrays.sort(keyPos);
        memo = new long[NUM_PEOPLE][NUM_KEYS];
        for (long[] m : memo) Arrays.fill(m, -1);
        out.println(dp(0, 0));
        out.flush();
        out.close();
    }

























    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
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
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }

        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}