import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Scanner;
import java.io.PrintWriter;

public class TaskD {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    public void solve(int testNumber, Scanner in, PrintWriter out) {

        int n = in.nextInt();
        int k = in.nextInt();

        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        if(k < n + 1) {
            out.println(-1);
            return;
        }

        if(n == 4) {
            out.println(-1);
            return;
        }

        int e = 0;
        for(int i = 1; i <=n ; i ++) {
            if(i != a && i!= b&& i != c && i!= d) {
                e = i;
            }
        }


        List<Integer> pathAC = new ArrayList<Integer>();

        for(int i =1 ; i <= n ; i ++) {
            if(i != a && i!= b&& i != c && i!= d && i != e) {
                pathAC.add(i);
            }
        }


        out.print(a+ " ");
        for(int i =0 ; i < pathAC.size(); i ++) {
            out.print(pathAC.get(i) + " ");
        }

        out.print(c + " ");
        out.print(e + " " );
        out.print(d + " ");
        out.println(b);


        out.print(c + " ");
        for(int i = pathAC.size() -1; i >=0;  i--) {
            out.print(pathAC.get(i) + " ");

        }
        out.print(a + " ");
        out.print(e + " ") ;
        out.print(b + " ");
        out.print(d);
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
            return Long.parseLong(next());
        }

    }
}
