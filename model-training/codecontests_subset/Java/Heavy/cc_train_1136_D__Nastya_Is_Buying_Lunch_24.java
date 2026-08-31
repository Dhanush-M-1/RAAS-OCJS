/*
 * Date Created : 7/1/2021
 * Have A Good Day !
 */

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Arpit
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        DNastyaIsBuyingLunch solver = new DNastyaIsBuyingLunch();
        solver.solve(1, in, out);
        out.close();
    }
    
    static class DNastyaIsBuyingLunch {
        public void solve(int testNumber, FastReader r, OutputWriter out) {
            int n = r.nextInt(), m = r.nextInt();
            int[] arr = r.nextIntArray(n);
            HashSet<Integer>[] moves = new HashSet[n + 1];
            for (int i = 1; i <= n; i++) moves[i] = new HashSet<>();
            for (int i = 1; i <= m; i++) moves[r.nextInt()].add(r.nextInt());
            HashSet<Integer> toCheck = new HashSet<>();
            toCheck.add(arr[n - 1]);
            int ans = 0;
//        for (int i = 1; i <= n; i++) if (moves[i].size() > 0) out.println(i + " -> " + moves[i]);
            for (int i = n - 2; i >= 0; i--) {
//            out.debug("arr[i]", arr[i]);
//            out.debugln("toCheck", toCheck);
                if (moves[arr[i]].size() >= toCheck.size()) {
                    boolean flag = true;
                    for (int ele : toCheck) {
                        if (!moves[arr[i]].contains(ele)) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) ans++;
                    else toCheck.add(arr[i]);
                } else toCheck.add(arr[i]);
            }
            out.println(ans);
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
                writer.print(objects[i]);
                if (i != objects.length - 1) writer.print(" ");
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
    
    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;
        
        public FastReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
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
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }
        
        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; ++i) array[i] = nextInt();
            return array;
        }
        
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
            
        }
        
    }
}

