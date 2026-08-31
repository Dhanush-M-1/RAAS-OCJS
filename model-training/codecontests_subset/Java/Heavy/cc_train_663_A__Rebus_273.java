//package Codeforces;

import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class P663A {
    void solve(InputReader in, PrintWriter out) {
        String s;
        List<Integer> sign = new ArrayList<>();
        int plus = 1, minus = 0;
        sign.add(1);
        while (true) {
            s = in.next();
            if (s.equals("=")) break;
            else if (s.equals("+")) {
                sign.add(1);
                plus++;
            }
            else if (s.equals("-")) {
                sign.add(-1);
                minus++;
            }
        }
        int num = Integer.parseInt(in.next());
        int minimum = plus - num * minus;
        int maximum = num * plus - minus;
        if (minimum > num || maximum < num) {
            out.println("Impossible");
            return;
        }
        out.println("Possible");
        int sofar = 0;
        boolean flag = true;
        for (int current : sign) {
            if (current == -1) minus--;
            else plus--;
            for (int x = 1; x <= num; x++) {
                int min_left = sofar + current * x + plus - num * minus;
                int max_left = sofar + current * x + num * plus - minus;
                if (min_left <= num && num <= max_left) {
                    sofar += x * current;
                    if (!flag) out.print((current == -1 ? " - " : " + ") + x);
                    else out.print(x * current);
                    break;
                }
            }
            flag = false;
        }
        out.println(" = " + num);
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        new P663A().solve(in, out);
        out.flush();
        out.close();
    }

    static class InputReader {
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
    }
}
