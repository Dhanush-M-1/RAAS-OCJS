import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author real
 */
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
            long a = 0;
            long b = 0;
            long greater = 0;
            System.out.println("? " + a + " " + b);
            System.out.flush();
            greater = in.nextInt();
            System.out.flush();
            for (int i = 29; i >= 0; i--) {
                long power2 = 1 << i;
                if (greater >= 0) {
                    System.out.println("? " + (a + power2) + " " + (b + power2));
                    System.out.flush();
                    int val = in.nextInt();
                    System.out.flush();
                    if (val < 0) {
                        a = a + power2;
                         System.out.println("? " + (a) + " " + (b));
                        System.out.flush();
                        greater = in.nextInt();
                        System.out.flush();
                    } else {
                        System.out.println("? " + (a + power2) + " " + b);
                        System.out.flush();
                        val = in.nextInt();
                        System.out.flush();
                        if (val < 0) {
                            a = a + power2;
                            b = b + power2;
                        } else {

                        }
                    }
                } else {
                    System.out.println("? " + (a + power2) + " " + (b + power2));
                    System.out.flush();
                    int val = in.nextInt();
                    System.out.flush();
                    if (val > 0) {
                        b = b + power2;
                        System.out.println("? " + (a) + " " + (b));
                        System.out.flush();
                        greater = in.nextInt();
                        System.out.flush();
                    } else {
                        System.out.println("? " + (a) + " " + (b + power2));
                        System.out.flush();
                        val = in.nextInt();
                        System.out.flush();
                        if (val > 0) {
                            a = a + power2;
                            b = b + power2;
                        } else {

                        }
                    }

                }
            }
            System.out.println("! " + a + " " + b);
            System.out.flush();
        }

    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;

        public InputReader(InputStream st) {
            this.stream = st;
        }

        public int read() {
            //*-*------clare------
//remeber while comparing 2 non primitive data type not to use ==
//remember Arrays.sort for primitive data has worst time case complexity of 0(n^2) bcoz it uses quick sort
//again silly mistakes ,yr kb tk krta rhega ye mistakes
//try to write simple codes ,break it into simple things
            // for test cases make sure println(); ;)
//knowledge>rating
        /*
        public class Main
        implements Runnable{
    public static void main(String[] args) {
        new Thread(null,new Main(),"Main",1<<26).start();

    }
    public void run() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskC solver = new TaskC();//chenge the name of task
        solver.solve(1, in, out);
        out.close();
    }
         */

            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}