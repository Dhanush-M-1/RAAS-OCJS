import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        CWoodcutters solver = new CWoodcutters();
        solver.solve(1, in, out);
        out.close();
    }

    static class CWoodcutters {
        public void solve(int testNumber, InputReader in, OutputWriter out) throws IOException {
            int n = in.nextInt();
            byte isFlipped[] = new byte[n];
            for (int i = 0; i < n; i++)
                isFlipped[i] = 0;
            isFlipped[0] = -1;//Flipped left
            int xh[][] = in.nextIntMatrix(n, 2);
            int countFlipped = 1;
            //out.printLine(xh[0][0]);
            for (int i = 1; i < n; i++) {
                if ((isFlipped[i - 1] == 1 && (xh[i][1] + xh[i - 1][1] < xh[i][0] - xh[i - 1][0])) || ((!(isFlipped[i - 1] == 1)) && (xh[i][1] < xh[i][0] - xh[i - 1][0]))) {
                    isFlipped[i] = -1;
                    countFlipped++;
                    //out.printLine(xh[i][0]+"\t"+xh[i][1]);
                } else if (i == n - 1 || xh[i][1] < xh[i + 1][0] - xh[i][0]) {
                    isFlipped[i] = 1;
                    countFlipped++;
                    //out.printLine(xh[i][0]);
                }
            }
            out.printLine(countFlipped);
        }

    }

    static class InputReader {
        private static final int DEFAULT_BUFFER_SIZE = 1 << 16;
        private static final InputStream DEFAULT_STREAM = System.in;
        private int c;
        private byte[] buf;
        private int bufferSize;
        private int bufIndex;
        private int numBytesRead;
        private InputStream stream;
        private static final byte EOF = -1;
        private static final byte SPACE = 32;
        private static final byte DASH = 45;
        private char[] charBuffer;
        private static byte[] bytes = new byte[58];
        private static int[] ints = new int[58];
        private static char[] chars = new char[128];

        static {
            char ch = ' ';
            int value = 0;
            byte _byte = 0;
            for (int i = 48; i < 58; i++) bytes[i] = _byte++;
            for (int i = 48; i < 58; i++) ints[i] = value++;
            for (int i = 32; i < 128; i++) chars[i] = ch++;
        }

        public InputReader() {
            this(DEFAULT_STREAM, DEFAULT_BUFFER_SIZE);
        }

        public InputReader(int bufferSize) {
            this(DEFAULT_STREAM, bufferSize);
        }

        public InputReader(InputStream stream) {
            this(stream, DEFAULT_BUFFER_SIZE);
        }

        public InputReader(InputStream stream, int bufferSize) {
            if (stream == null || bufferSize <= 0)
                throw new IllegalArgumentException();
            buf = new byte[bufferSize];
            charBuffer = new char[128];
            this.bufferSize = bufferSize;
            this.stream = stream;
        }

        private int readJunk(int token) throws IOException {

            if (numBytesRead == EOF) return EOF;

            // Seek to the first valid position index
            do {

                while (bufIndex < numBytesRead) {
                    if (buf[bufIndex] > token) return 0;
                    bufIndex++;
                }

                // reload buffer
                numBytesRead = stream.read(buf);
                if (numBytesRead == EOF) return EOF;
                bufIndex = 0;

            } while (true);

        }

        public int nextInt() throws IOException {

            if (readJunk(DASH - 1) == EOF) throw new IOException();
            int sgn = 1, res = 0;

            c = buf[bufIndex];
            if (c == DASH) {
                sgn = -1;
                bufIndex++;
            }

            do {

                while (bufIndex < numBytesRead) {
                    if (buf[bufIndex] > SPACE) {
                        res = (res << 3) + (res << 1);
                        res += ints[buf[bufIndex++]];
                    } else {
                        bufIndex++;
                        return res * sgn;
                    }
                }

                // Reload buffer
                numBytesRead = stream.read(buf);
                if (numBytesRead == EOF) return res * sgn;
                bufIndex = 0;

            } while (true);

        }

        public int[][] nextIntMatrix(int rows, int cols) throws IOException {
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    matrix[i][j] = nextInt();
            return matrix;
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
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }
}

