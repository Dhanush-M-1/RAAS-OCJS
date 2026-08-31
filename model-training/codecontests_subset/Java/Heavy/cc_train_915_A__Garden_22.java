import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter ou = new OutputWriter(System.out);
        /*int a=in.nextInt();
        double b=in.nextDouble();
        long c=in.nextLong();
        boolean d=in.nextBoolean();
        String e=in.nextString();
        String f=in.nextLine();*/
        //int aa[]=in.nextIntArray(2);
        /*double bb[]=in.nextDoubleArray(2);
        long cc[]=in.nextLongArray(2);
        boolean dd[]=in.nextBooleanArray(2);
        String ee[]=in.nextStringArray(2);
        String ff[]=in.nextLineArray(2);*/
        //String ee[]=in.nextStringArray(2);
        
        //ou.printLn(f);
        /*for (int i = 0; i < 2; i++) {
            ou.writer.println(aa[i]);
        }
        */
        int n=in.nextInt();
        int k=in.nextInt();
        int cost=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cap=in.nextInt();
            if(k%cap==0){
                cost=Math.min(cost,k/cap);
            }
        }
        ou.writer.println(cost);
        
        
        
        ou.flush();
        ou.close();
    }

    public static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;

        public InputReader(InputStream st) {
            this.stream = st;
        }

        public int read() {
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0) {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String nextString() { //single string
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() { //one entire sentence
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean nextBoolean() {
            return Boolean.parseBoolean(nextString());
        }

        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public double[] nextDoubleArray(int n) {
            double a[] = new double[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;

        }

        public boolean[] nextBooleanArray(int n) {
            boolean a[] = new boolean[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextBoolean();
            }
            return a;
        }

        public String[] nextStringArray(int n) {
            String a[] = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextString();
            }
            return a;
        }

        public String[] nextLineArray(int n) {
            String a[] = new String[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLine();
            }
            return a;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }

    public static class OutputWriter {

        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        /*
        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            writer.flush();
        }

        public void printLn(Object... objects) {
            print(objects);
            writer.println();
            writer.flush();
        }
        */
        

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }
    }

}
