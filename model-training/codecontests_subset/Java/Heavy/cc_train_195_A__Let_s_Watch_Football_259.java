import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        try {
            (new Main()).run();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void run() throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        out.println(((a - b) * c + b - 1) / b);
        out.close();
    }

    private int sumOfDigits(long n) {
        int res = 0;
        while (n > 0) {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    private class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastScanner(InputStream inputStream) {
            this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        FastScanner(File file) throws IOException {
            this.bufferedReader = new BufferedReader(new FileReader(file));
        }

        public String next() throws IOException {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                String line = bufferedReader.readLine();
                if (line == null) return null;
                stringTokenizer = new StringTokenizer(line);
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(this.next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(this.next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(this.next());
        }

    }
}
