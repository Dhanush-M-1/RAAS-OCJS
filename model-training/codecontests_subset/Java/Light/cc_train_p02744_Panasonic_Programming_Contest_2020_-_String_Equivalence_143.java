//package AtCoder.Panasonic2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

    static int maxlen;

    static void func(StringBuilder ps, int len) {
        if (len == maxlen) {
            out.println(ps.toString());
            return;
        }
        int maxpos = -1;
        for (int i=0;i<ps.length();i++) {
            maxpos = Integer.max(maxpos, (ps.charAt(i)-'a'));
        }
        StringBuilder nps = new StringBuilder(ps);
        maxpos++;
        for (int i=0;i<=maxpos;i++) {
            if (nps.length() < len+1 ) {
                nps.append((char)('a'+i));
            } else {
                nps.setCharAt(len, (char) ('a' + i));
            }
            func(nps, len+1);
        }
    }

    public static void main(String[] args) {
        int len = in.NI();
        maxlen = len;
        StringBuilder ps = new StringBuilder();
        func(ps, 0);
        out.close();
    }


    static InputStream inputStream = System.in;
    static OutputStream outputStream = System.out;
    static InputReader in = new InputReader(inputStream);
    static PrintWriter out = new PrintWriter(outputStream);

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

        public int NI() {
            return Integer.parseInt(next());
        }

        public long NL() {
            return Long.parseLong(next());
        }

    }
}