import java.io.*;
import java.util.*;

/**
 * @author Tran Anh Tai
 * @template for CP codes
 * What a trick prob!
 */
public class ProbA {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
    // main solver
    static class Task{
        public void solve(InputReader in, PrintWriter out) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            long delta = (long)b * b - (long)4 * a * c;
            if (delta < 0){
                out.println(0);
            }
            else if (a == 0 || delta == 0) {
                if (a == 0){
                    if (b == 0) {
                        out.println((c == 0) ? -1 : 0);
                    }
                    else {
                        out.println(1);
                        out.println((double)(-c) / b);
                    }
                }
                else{
                    out.println(1);
                    double x = (double)(-b) / (a << 1);
                    out.println(x);
                }
            }
            else{
                double x1 = (-b - Math.sqrt(delta)) / (a << 1);
                double x2 = (-b + Math.sqrt(delta)) / (a << 1);
                out.println(2);
                out.println(Math.min(x1, x2));
                out.println(Math.max(x1, x2));
            }
        }
    }
    // fast input reader class;
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line = null;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
        public double nextDouble(){
            return Double.parseDouble(nextToken());
        }
        public long nextLong(){
            return Long.parseLong(nextToken());
        }
    }
}