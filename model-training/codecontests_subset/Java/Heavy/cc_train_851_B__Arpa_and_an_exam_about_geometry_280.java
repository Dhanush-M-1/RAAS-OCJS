import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.util.Scanner;
import java.io.OutputStreamWriter;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Debabrata
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        Arpa solver = new Arpa();
        solver.solve(1, in, out);
        out.close();
    }

    static class Arpa {
        public void solve(int testNumber, Scanner scan, OutputWriter out) {
            long x1 = scan.nextLong();
            long y1 = scan.nextLong();
            long x2 = scan.nextLong();
            long y2 = scan.nextLong();
            long x3 = scan.nextLong();
            long y3 = scan.nextLong();
            if ((y2 - y1) * (x3 - x1) == (x2 - x1) * (y3 - y1)) {
                out.println("No");
                return;
            }
            x1 -= x2;
            y1 -= y2;
            x3 -= x2;
            y3 -= y2;

            if (!check(x1, y1, x3, y3)) {
                out.println("No");
                return;
            }
            out.println("Yes");
        }

        static boolean check(long x, long y, long xx, long yy) {
            return (x * x) + (y * y) == (xx * xx) + (yy * yy);
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

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

