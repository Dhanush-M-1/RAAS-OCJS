import java.io.*;
import java.util.StringTokenizer;

public class D {
    public static void main(String[] args) throws IOException {
        try (Input input = new StandardInput(); PrintWriter writer = new PrintWriter(System.out)) {
            class RequestWriter {
                int c, d;
                private void request(int c, int d) {
                    writer.printf("? %d %d\n", c, d);
                    this.c = c;
                    this.d = d;
                    writer.flush();
                }
                private void answer(int a, int b) {
                    writer.printf("! %d %d\n", a, b);
                    writer.flush();
                }
            }
            final int NUMBER_OF_BITS = 30;
            RequestWriter requestWriter = new RequestWriter();
            class TestInput {
                private final boolean debugMode;
                private final int a, b;

                private TestInput(boolean debugMode, int a, int b) {
                    this.debugMode = debugMode;
                    this.a = a;
                    this.b = b;
                }

                int getSign() throws IOException {
                    if (debugMode) {
                        int v = (a ^ requestWriter.c) - (b ^ requestWriter.d);
                        if (v == 0) {
                            return 0;
                        }
                        return v > 0 ? 1 : -1;
                    }
                    return input.nextInt();
                }
            }
            TestInput testInput = new TestInput(false, 33322222, 333335);
            class Helper {
                // query for currentPosition returned 0
                // prefix has bit set to 1 if this bit is different in a and b
                private int getSuffix(int prefix, int currentPosition) throws IOException {
                    int suffix = 0;
                    for (int i = 0; i <= currentPosition; i++) {
                        requestWriter.request(prefix + (1 << i), 0);
                        if (testInput.getSign() == -1) {
                            suffix += 1 << i;
                        }
                    }
                    return suffix;
                }
            }
            requestWriter.request(0, 0);
            int sign = testInput.getSign();
            if (sign == 0) {
                int a = new Helper().getSuffix(0, NUMBER_OF_BITS - 1);
                requestWriter.answer(a, a);
            } else {
                int a = 0, b = 0;
                int prefix = 0;
                for (int k = NUMBER_OF_BITS - 1; k >= 0; k--) {
                    requestWriter.request(prefix + (1 << k), 1 << k);
                    int reply = testInput.getSign();
                    if (reply == 0) {
                        int suffix = new Helper().getSuffix(prefix, k);
                        requestWriter.answer(a + suffix, b + suffix);
                        return;
                    }
                    if (reply == sign) { // same bits
                        requestWriter.request(prefix + (1 << k), 0);
                        if (testInput.getSign() == -1) {
                            a += 1 << k;
                            b += 1 << k;
                        }
                    } else { // different bits
                        prefix += 1 << k;
                        if (reply == 1) {
                            b += 1 << k;
                        } else {
                            a += 1 << k;
                        }
                        // what's a new sign?
                        requestWriter.request(prefix, 0);
                        sign = testInput.getSign();
                    }
                }
                requestWriter.answer(a, b);
            }
        }
    }

    interface Input extends Closeable {
        String next() throws IOException;

        default int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        default long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }

    private static class StandardInput implements Input {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        private StringTokenizer stringTokenizer;

        @Override
        public void close() throws IOException {
            reader.close();
        }

        @Override
        public String next() throws IOException {
            if (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                stringTokenizer = new StringTokenizer(reader.readLine());
            }
            return stringTokenizer.nextToken();
        }
    }
}