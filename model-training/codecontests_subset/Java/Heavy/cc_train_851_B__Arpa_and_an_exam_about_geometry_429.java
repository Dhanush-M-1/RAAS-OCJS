/**
 * @author Siddhraj Sisodiya
 */

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
import java.io.InputStream;

public class Main 
{
    public static void main(String[] args) 
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }

    static class TaskB 
    {
        public void solve(int testNumber, InputReader in, OutputWriter out) 
        {
            int a1 = in.nextInt(), a2 = in.nextInt(), b1 = in.nextInt(), b2 = in.nextInt(), c1 = in.nextInt(), c2 = in.nextInt();
            if (distance(a1, a2, b1, b2) != distance(b1, b2, c1, c2)) 
            {
                out.println("No");
            } else 
            {
                if ((a2 - b2) == (b2 - c2) && (a1 - b1) == (b1 - c1))
                    out.println("No");
                else
                    out.println("Yes");
            }
        }

        static long distance(int x1, int y1, int x2, int y2) 
        {
            return (long) ((long) (x1 - x2) * (x1 - x2) + (long) (y1 - y2) * (y1 - y2));
        }

    }

    static class InputReader 
    {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) 
        {
            this.stream = stream;
        }

        public int read() 
        {
            if (numChars == -1) 
            {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) 
            {
                curChar = 0;
                try 
                {
                    numChars = stream.read(buf);
                } catch (IOException e) 
                {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) 
                {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() 
        {
            int c = read();
            while (isSpaceChar(c)) 
            {
                c = read();
            }
            int sgn = 1;
            if (c == '-') 
            {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do 
            {
                if (c < '0' || c > '9') 
                {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) 
        {
            if (filter != null) 
            {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) 
        {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter 
        {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter 
    {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) 
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) 
        {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) 
        {
            for (int i = 0; i < objects.length; i++) 
            {
                if (i != 0) 
                {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) 
        {
            print(objects);
            writer.println();
        }

        public void close() 
        {
            writer.close();
        }

    }
}

