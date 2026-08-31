import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author xwchen
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            double a = in.nextDouble();
            double b = in.nextDouble();
            double c = in.nextDouble();

            double sq = b * b - 4 * a * c;
            if (eq(a, 0) && eq(b, 0)) {
                if (eq(c, 0)) {
                    out.println(-1);
                } else {
                    out.println(0);
                }
            } else if (eq(a, 0)) {
                out.println(1);
                double y = -c / b;
                out.println(y);
            } else if (sq < -1e-9) {
                out.println(0);
            } else if (Math.abs(sq) < 1e-9) {
                out.println(1);
                double y = -b / 2 / a;
                out.println(y);
            } else {
                sq = Math.sqrt(sq);
                double y1 = (-b - sq) / 2 / a;
                double y2 = (-b + sq) / 2 / a;
                if (y1 > y2) {
                    double t = y1;
                    y1 = y2;
                    y2 = t;
                }
                out.println(2);
                out.println(y1);
                out.println(y2);
            }
        }

        boolean eq(double a, double b) {
            return Math.abs(a - b) < 1e-9;
        }

    }

    static class InputReader {
        final private int BUFFER_SIZE = 1 << 10;
        private DataInputStream in;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;

        public InputReader(InputStream inputStream) {
            this.in = new DataInputStream(inputStream);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() {
            try {
                bytesRead = in.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

    }
}

