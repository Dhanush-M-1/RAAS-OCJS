import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author sumit
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskD solver = new TaskD();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskD {
        ArrayList<Integer>[] list;
        boolean[] vis;
        ArrayList<Integer> tempList;

        void dfs(int par) {
            vis[par] = true;
            tempList.add(par);
            for (int temp : list[par]) {
                if (!vis[temp])
                    dfs(temp);
            }
        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] perm = in.nextIntArray(n);
            Pair[] pair = new Pair[m];
            for (int i = 0; i < m; i++) {
                pair[i] = new Pair(in.nextInt() - 1, in.nextInt() - 1);
            }
            list = new ArrayList[n];
            for (int i = 0; i < n; i++)
                list[i] = new ArrayList();
            vis = new boolean[n];


            for (int i = 0; i < m; i++) {
                list[pair[i].x].add(pair[i].y);
                list[pair[i].y].add(pair[i].x);
            }

            for (int i = 0; i < n; i++) {
                tempList = new ArrayList();
                if (!vis[i]) {
                    dfs(i);
                }
                if (tempList.size() > 0) {
                    ArrayList<Integer> temp = new ArrayList();
                    for (int t : tempList) {
                        temp.add(perm[t]);
                    }
                    Collections.sort(temp, Collections.reverseOrder());
                    Collections.sort(tempList);
                    for (int j = 0; j < temp.size(); j++) {
                        perm[tempList.get(j)] = temp.get(j);
                    }

                }
            }

            for (int i = 0; i < n; i++)
                out.print(perm[i] + " ");


        }

        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }

            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();

                res *= 10;
                res += c & 15;

                c = read();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];

            for (int i = 0; i < arraySize; i++)
                array[i] = nextInt();

            return array;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
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

        public void close() {
            writer.close();
        }

    }
}

