import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }
}

class TaskB {
    public void solve(InputReader in, PrintWriter out) {
        double a = in.nextInt();
        double b = in.nextInt();
        double c = in.nextInt();
        if (a == 0 && b == 0) {
            if (c == 0) {
                out.println(-1);
                return;
            } else {
                out.println(0);
                return;
            }
        }
        if(a==0){
            out.println(1);
            out.printf("%.12f\n",((-c*1.0)/b));
            return;
        }
        double d = b * b - 4 * a * c;
        if (d < 0) {
            out.println(0);
        } else {
            int roots = (d == 0) ? 1 : 2;
            out.println(roots);
            d = Math.sqrt(d);
            double r[] = {(-d - b) / 2. / a, (d - b) / 2. / a};
            Arrays.sort(r);
            for (int i = 0; i < roots; i++) {
                out.printf("%.12f\n", r[i]);
            }
        }

    }
}

class InputReader {
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