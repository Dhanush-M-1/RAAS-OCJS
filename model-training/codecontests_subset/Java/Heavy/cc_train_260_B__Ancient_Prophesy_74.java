import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Round_158_B {

    static TreeMap<String, Integer> M = new TreeMap<String, Integer>();

    static class pair implements Comparable<pair> {

        String name;
        int count;

        public pair(String key, Integer value) {
            name = key;
            count = value;
        }

        @Override
        public int compareTo(pair o) {

            return new Integer(o.count).compareTo(count);
        }

    };

    public static void main(String[] args) {

        String Line;
        InputReader in = new InputReader(System.in);
        Line = in.next();
        gen(Line);
        String ans = "";
        pair[] all = new pair[M.size()];
        int i = 0;
        for (Entry<String, Integer> S : M.entrySet()) {
            all[i++] = new pair(S.getKey(), S.getValue());
        }
        Arrays.sort(all);
        i = 0;
        while (true) {
            ans = all[i++].name;
            if (valid(ans)) {
                System.out.println(ans);
                return;
            }
        }
    }

    private static boolean valid(String ans) {
        try {
            if (ans.charAt(2) != '-' || ans.charAt(5) != '-')
                return false;
            int day = Integer.parseInt(ans.substring(0, 2));
            int month = Integer.parseInt(ans.substring(3, 5));
            int year = Integer.parseInt(ans.substring(6, 10));
            if (year > 2015 || year < 2013)
                return false;
            if (day > 31 || day == 0)
                return false;
            if (month == 2 && day > 28)
                return false;
            if (day > 30) {
                if (month != 1 && month != 3 && month != 5 && month != 7
                        && month != 8 && month != 10 && month != 12)
                    return false;
            }

        } catch (Exception e) {

            return false;
        }

        return true;
    }

    private static void gen(String x) {
        int n = x.length();
        String S;
        for (int i = 0; i <= n - 10; i++) {
            S = x.substring(i, i + 10);
            Integer K = M.get(S.toString());
            if (K == null) {
                M.put(S, 1);
            } else
                M.put(S, K + 1);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
