/*
 * Date Created : 19/10/2020
 * Have A Good Day !
 */

import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.io.Writer;
import java.io.OutputStreamWriter;
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
        BPuttingBricksInTheWall solver = new BPuttingBricksInTheWall();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }
    
    static class BPuttingBricksInTheWall {
        public void solve(int testNumber, FastReader r, OutputWriter out) {
            int n = r.nextInt();
            char[][] grid = r.nextCharMatrix(n, n);
            int sa = grid[1][0] - '0', sb = grid[0][1] - '0';
            int fa = grid[n - 1][n - 2] - '0', fb = grid[n - 2][n - 1] - '0';
            ArrayList<Point> moves = new ArrayList<>();
            if (sa == 0 && sb == 0) {
                if (fa == 0 && fb == 0) {
                    moves.add(new Point(n, n - 1));
                    moves.add(new Point(n - 1, n));
                } else if (fa == 0 && fb == 1) {
                    moves.add(new Point(n, n - 1));
                } else if (fa == 1 && fb == 0) {
                    moves.add(new Point(n - 1, n));
                }
            } else if (sa == 1 && sb == 1) {
                if (fa == 1 && fb == 1) {
                    moves.add(new Point(n, n - 1));
                    moves.add(new Point(n - 1, n));
                } else if (fa == 0 && fb == 1) {
                    moves.add(new Point(n - 1, n));
                } else if (fa == 1 && fb == 0) {
                    moves.add(new Point(n, n - 1));
                }
            } else if (sa == 0 && sb == 1) {
                if (fa == 1 && fb == 1) {
                    moves.add(new Point(1, 2));
                } else if (fa == 0 && fb == 0) {
                    moves.add(new Point(2, 1));
                } else if (fa == 0 && fb == 1) {
                    moves.add(new Point(1, 2));
                    moves.add(new Point(n, n - 1));
                } else if (fa == 1 && fb == 0) {
                    moves.add(new Point(1, 2));
                    moves.add(new Point(n - 1, n));
                }
            } else if (sa == 1 && sb == 0) {
                if (fa == 1 && fb == 1) {
                    moves.add(new Point(2, 1));
                } else if (fa == 0 && fb == 0) {
                    moves.add(new Point(1, 2));
                } else if (fa == 0 && fb == 1) {
                    moves.add(new Point(1, 2));
                    moves.add(new Point(n - 1, n));
                } else if (fa == 1 && fb == 0) {
                    moves.add(new Point(1, 2));
                    moves.add(new Point(n, n - 1));
                }
            }
            out.println(moves.size());
            for (Point p : moves) out.println(p);
        }
        
        class Point implements Comparable<Point> {
            int x;
            int y;
            
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
            
            public String toString() {
                return (x + " " + y);
            }
            
            public int compareTo(Point o) {
                if (x == o.x) {
                    return (y - o.y);
                }
                return (x - o.x);
            }
            
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
        
        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
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
        
        public String next() {
            return nextString();
        }
        
        public char[][] nextCharMatrix(int n, int m) {
            char[][] mat = new char[n][m];
            for (int i = 0; i < n; i++) mat[i] = next().toCharArray();
            return mat;
        }
        
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
            
        }
        
    }
}

