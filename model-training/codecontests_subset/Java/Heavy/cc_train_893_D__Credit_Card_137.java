import java.io.*;
import java.util.StringTokenizer;

public class Solution {

    public static void solve(InputReader in, PrintWriter out, DebugWriter debug) throws IOException {
        int n = in.nextInt();
        long d = in.nextInt();
        int[] a = in.nextIntArray(n);

        long[] balance = new long[n];
        balance[0] = a[0];
        if (balance[0] > d){
            out.print(-1);
            return;
        }

        for (int i=1; i<n; i++){
            long al = a[i];
            balance[i] = balance[i-1]+al;
            if (balance[i] > d){
                out.print(-1);
                return;
            }
        }

        long[] sufmax = new long[n];
        sufmax[n-1] = balance[n-1];
        for (int i=n-2; i>=0; i--){
            sufmax[i] = Math.max(balance[i], sufmax[i+1]);
        }

        long income = 0;
        long ans = 0;
        for (int i=0; i<n; i++){
            if (a[i] != 0) continue;
            if (balance[i]+income >= 0) continue;

            long inc = d-(sufmax[i]+income);
            income += inc;
            ans++;
            if (balance[i]+income < 0){
                out.print(-1);
                return;
            }
        }

        out.print(ans);
    }

    public static final String NAME = "";

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
            if (NAME.length() > 0) {
                in = new InputReader(new BufferedReader(new FileReader(NAME + ".in")));
                out = new PrintWriter(new FileWriter(NAME + ".out"));
            } else {
                in = new InputReader(new BufferedReader(new InputStreamReader(System.in)));
                out = new PrintWriter(new OutputStreamWriter(System.out));
            }

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