import java.io.*;
import java.util.StringTokenizer;

public class ProblemA {

    public static void solve(InputReader in, PrintWriter out, DebugWriter debug) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] w = in.nextIntArray(n);
        int[] b = in.nextIntArray(m);

        int[] books = new int[n];
        int posBooks = 0;
        int posB = 0;
        while (posBooks < n && posB < m){
            boolean find = false;
            for (int i=0; i<posBooks; i++){
                if (books[i] == b[posB]){
                    find = true;
                    break;
                }
            }

            if (!find){
                books[posBooks] = b[posB];
                posBooks++;
            }

            posB++;
        }

        for (int j = 0; j<books.length; j++) debug.print(books[j] + " ");
        debug.println("");

        long sum = 0;
        for (int i=0; i<b.length; i++){
            sum += read(books, w, b[i]);
            for (int j = 0; j<books.length; j++) debug.print(books[j] + " ");
            debug.println(" = " + sum);
        }

        out.print(sum);
    }

    public static int read(int[] books, int[] w, int number){
        int pos = -1;
        int sum = 0;
        for (int i=0; i<books.length; i++){
            if (books[i] == number){
                pos = i;
                break;
            }
            sum += w[books[i]-1];
        }

        for (int i=pos; i>0; i--){
            books[i] = books[i-1];
        }
        books[0] = number;

        return sum;
    }

    public static void main(String[] args) throws IOException{
        InputReader in;
        PrintWriter out;
        DebugWriter debug;

        if (args.length > 0 && args[0].equals("file")) {
            in = new InputReader(new BufferedReader(new FileReader("input.txt")));
            out = new PrintWriter(new FileWriter("output.txt"));
            debug = new DebugWriter(true);

            int sampleNumber = 1;
            do {
                String nextSample = "Sample #" + sampleNumber++ + ": ";
                out.println(nextSample);
                debug.println(nextSample);

                solve(in, out, debug);

                out.println("");
                debug.println("");
            } while (in.reader.readLine() != null);
        } else {
            in = new InputReader(new BufferedReader(new InputStreamReader(System.in)));
            out = new PrintWriter(new OutputStreamWriter(System.out));
            debug = new DebugWriter(false);

            solve(in, out, debug);
        }

        in.reader.close();
        out.close();
    }

    public static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(BufferedReader reader) {
            this.reader = reader;
            tokenizer = null;
        }

        public String next() throws IOException{
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }

            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) throws IOException{
            int[] array = new int[n];
            for (int i=0; i<n; i++){
                array[i] = nextInt();
            }

            return array;
        }
    }

    public static class DebugWriter {
        public boolean enable;

        public DebugWriter(boolean enable){
            this.enable = enable;
        }

        public void print(Object o){
            if (enable) System.out.print(o);
        }

        public void println(Object o){
            if (enable) System.out.println(o);
        }
    }

}
