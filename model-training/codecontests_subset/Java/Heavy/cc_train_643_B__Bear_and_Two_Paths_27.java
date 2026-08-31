import java.io.*;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            int k = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int d = in.nextInt();
            if(n == 4 || k < n+1){
                out.println(-1);
                return;
            }
            out.print(a + " " + c + " ");
            boolean flag = false;
            int x = 0;
            for(int i=1;i<=n;i++){
                if(!flag && i != a && i != b && i != c && i != d){
                    x = i;
                    out.print(i + " " + d);
                    flag =true;
                }else if(flag && i != a && i != b && i != c && i != d){
                    out.print(" " + i);
                }
            }
            out.print(" " + b + "\n");
            out.print(c + " " + a + " " + x + " " + b);
            for(int i=n;i>0;i--){
                if(i != a && i != b && i != c && i != d && i != x) {
                    out.print(" " + i);
                }
            }
            out.print(" " + d);
        }
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

    }
}
