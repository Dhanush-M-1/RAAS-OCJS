import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    
    Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    void gao(char[] s, int base) {
        for (int i = 0; i < 10; ++i) {
            if (base + i >= s.length) return;
            if (i == 2 || i == 5) {
                if (s[i + base] != '-') return;
            } else if (s[i + base] == '-') return;
        }
        int d = (s[0 + base] - '0') * 10 + s[1 + base] - '0';
        int m = (s[3 + base] - '0') * 10 + s[4 + base] - '0';
        int y = (s[6 + base] - '0') * 1000 + (s[7 + base] - '0') * 100
            + (s[8 + base] - '0') * 10 + s[9 + base] - '0';
        if (y < 2013 || y > 2015) return;
        if (m < 1 || m > 12) return;
        if (d < 1 || d > days[m - 1]) return;
        int state = y * 10000 + m * 100 + d;
        Integer num = mp.get(state);
        if (num == null) num = 0;
        mp.put(state, num + 1);
    }
    
    void run(int nT) {
        char[] s = cin.next().toCharArray();
        for (int i = 0; i < s.length; ++i) {
            gao(s, i);
        }
        Integer state = null, num = null;
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            Integer s1 = entry.getKey();
            Integer s2 = entry.getValue();
            //System.out.println(s1 + " " + s2);
            if (num == null || s2 > num) {
                state = s1;
                num = s2;
            }
        }
        int y = state / 10000; state %= 10000;
        int m = state / 100; state %= 100;
        int d = state;
        out.printf("%02d-%02d-%d\n", d, m, y);
    }

    public static void main(String[] argv) {
        Main solved = new Main();
        //solved.init();
        int T = 1;
        //T = solved.cin.nextInt();
        for (int nT = 1; nT <= T; ++nT) {
            solved.run(nT);
        }
        solved.out.close();
    }

    InputReader cin = new InputReader(System.in);
    PrintWriter out = new PrintWriter(System.out);
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
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