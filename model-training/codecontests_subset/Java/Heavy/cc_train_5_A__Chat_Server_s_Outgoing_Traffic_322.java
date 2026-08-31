import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CF5A solver = new CF5A();
        solver.solve(1, in, out);
        out.close();
    }

    static class CF5A {
        public void solve(int testNumber, Scanner in, OutputWriter out) {
            BufferedReader _in = new BufferedReader(new InputStreamReader(System.in));
            String _s;
            int n = 0;
            int res = 0;
            while (in.hasNext()) {
                _s = in.nextLine();
                if (_s.charAt(0) == '+') n++;
                else if (_s.charAt(0) == '-') n--;
                else {
                    res += (_s.length() - _s.indexOf(":") - 1) * n;
                }
            }
            out.println(res);
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void println(int i) {
            writer.println(i);
        }

    }
}

