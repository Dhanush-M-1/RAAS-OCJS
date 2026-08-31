import java.io.*;
import java.util.*;
public class d {
    public static void main(String args[]) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = sc.nextInt();
        int friend = 1000000,p=1;
        int sol=0;
        for(int i =0;i<n;i++) {
            int prize = sc.nextInt();
            sol = Math.max(sol, Math.min(prize - p, friend - prize));
        }
        out.print(sol);
        out.close();
    }
    public static boolean isVowel(char c)
    {
        if(c=='a' || c=='e' || c=='i' ||  c=='o' ||c=='u' || c=='y')
        {
            return true;
        }
    return false;
    }

    public static void shuffle(int[] arr) {
        int n = arr.length;
        Random rnd = new Random();
        for (int i = 0; i < n; ++i) {
            int tmp = arr[i];
            int randomPos = i + rnd.nextInt(n - i);
            arr[i] = arr[randomPos];
            arr[randomPos] = tmp;
        }
    }

    public static int gcd(int x, int y) {
        if (y == 0)
            return x;
        return gcd(y, x % y);
    }

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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.valueOf(next());
        }

        public double nextDouble() {
            return Double.valueOf(next());
        }

        String nextLine() throws IOException {
            return reader.readLine();
        }

    }
}