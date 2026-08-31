import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        InputReader in = new InputReader();
        int n = in.nextInt();
        int d = in.nextInt();
        int[] trans = new int[n];
        int curr = 0, res = 0;

        for(int i = 0; i < n; ++i) {
            trans[i] = in.nextInt();
            curr += trans[i];

            if(trans[i] == 0) {
                if(curr < 0) curr = 0;
            }

            if(curr > d) {
                System.out.println(-1);
                return;
            }
        }

        curr = 0;
        for(int i = 0; i < n; ++i) {
            curr += trans[i];

            if(trans[i] == 0 && curr < 0) {
                res++;
                curr = d;
            }

            curr = Math.min(curr, d);
        }

        System.out.println(res);
    }
}

class InputReader {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public InputReader() { reader = new BufferedReader(new InputStreamReader(System.in)); }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }
    long nextLong() { return Long.parseLong(next()); }
    double nextDouble() { return Double.parseDouble(next()); }

    String nextLine() {
        String str = "";
        try {
            str = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
