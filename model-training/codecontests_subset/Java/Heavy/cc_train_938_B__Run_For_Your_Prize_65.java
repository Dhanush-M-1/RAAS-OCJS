import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Question {

    public static void main(String[] args) {
        new Question(System.in, System.out);

        for (int i = 0; i < 10; i++)
            System.out.println("i : " + i + ", (ch) I : " + ((char) i));

    }

    static class Solver {
        int n;
        int[] a;
        InputReader in;
        PrintWriter out;
        void solve() throws IOException {
            n = in.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i]=in.nextInt();
            }
            int ans=0;
            int pos1 = 1,pos2 =1000000;
            int p=-1,index=-1;
            for (int i = 0; i < n; i++) {
                if(a[i]-pos1<pos2-a[i])
                {index=i;
                    p=a[i];}
                else
                    break;

               /* if(a[i]-pos1<pos2-a[i]) {
                    pos2 -= pos1 - a[i];
                    pos1 = a[i];
                }
                else if(a[i]-pos1>pos2-a[i]) {
                    pos1 +=pos2-a[i];
                    pos2 = a[i];
                }
                else {
                    int x = pos1 - 1, y = 1000000 - pos2;
                    if (x + a[i] - pos1 < y + pos2 - a[i]) {
                        pos2 -= pos1 - a[i];
                        pos1 = a[i];
                    } else {
                        pos1 +=pos2-a[i];
                        pos2 = a[i];
                    }
                }*/
            }
            if(p==-1)ans=pos2-a[0];
            else{
                if(index==n-1)
                    ans= p-pos1;
                else
                {
                    if(p-pos1>pos2-a[index+1])
                        ans = p-pos1;
                    else
                        ans = pos2-a[index+1];
                }
            }

           // ans = ((long)(pos1-1))>(long)(1000000-pos2)?(long)(pos1-1):(long)(1000000-pos2);
            out.print(ans);
        }
        Solver(InputReader in, PrintWriter out) {
            this.in = in;
            this.out = out;
        }
    }


    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

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

        public long nextLong() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sign = 1;

            if (c == '-') {
                sign = -1;

                c = read();
            }

            long result = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();

                result *= 10;
                result += c & 15;

                c = read();
            } while (!isSpaceChar(c));

            return result * sign;
        }

        public long[] nextLongArray(int arraySize) {
            long array[] = new long[arraySize];

            for (int i = 0; i < arraySize; i++)
                array[i] = nextLong();

            return array;
        }

        public float nextFloat() {
            float result, div;
            byte c;

            result = 0;
            div = 1;
            c = (byte) read();

            while (c <= ' ')
                c = (byte) read();

            boolean isNegative = (c == '-');

            if (isNegative)
                c = (byte) read();

            do {
                result = result * 10 + c - '0';
            } while ((c = (byte) read()) >= '0' && c <= '9');

            if (c == '.')
                while ((c = (byte) read()) >= '0' && c <= '9')
                    result += (c - '0') / (div *= 10);

            if (isNegative)
                return -result;

            return result;
        }

        public double nextDouble() {
            double ret = 0, div = 1;
            byte c = (byte) read();

            while (c <= ' ')
                c = (byte) read();

            boolean neg = (c == '-');

            if (neg)
                c = (byte) read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = (byte) read()) >= '0' && c <= '9');

            if (c == '.')
                while ((c = (byte) read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);

            if (neg)
                return -ret;

            return ret;
        }

        public String next() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(c);

                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String nextLine() {
            int c = read();

            StringBuilder result = new StringBuilder();

            do {
                result.appendCodePoint(c);

                c = read();
            } while (!isNewLine(c));

            return result.toString();
        }

        public boolean isNewLine(int c) {
            return c == '\n';
        }

        public void close() {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

    }

    Question(InputStream inputStream, OutputStream outputStream) {
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solver solver = new Solver(in, out);

        try {
            solver.solve();
        } catch (IOException e) {
            e.printStackTrace();
        }
        in.close();
        out.flush();
        out.close();
    }

}