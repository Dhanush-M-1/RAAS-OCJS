

import java.io.*;
import java.util.*;

public class Ques2 {

    static class Scan {

        private final InputStream inputStream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public Scan() {
            inputStream = System.in;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = inputStream.read(buffer);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str = "";

            try {
                str = br.readLine();
            }
            catch (IOException e) {
            }
            return str;
        }

        public int nextInt() {
            int ch = read();

            while(isSpaceChar(ch))
                ch = read();

            int sgn = 1;

            if (ch == '-') {
                sgn = -1;
                ch = read();
            }

            int res = 0;
            do {
                if(ch < '0' || ch > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += ch - '0';
                ch = read();
            }
            while (!isSpaceChar(ch));

            return res * sgn;
        }

        public long nextLong() {
            int ch = read();

            while (isSpaceChar(ch))
                ch = read();

            int sgn = 1;

            if (ch == '-') {
                sgn = -1;
                ch = read();
            }

            long res = 0;

            do {
                if (ch < '0' || ch > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += ch - '0';
                ch = read();
            }
            while (!isSpaceChar(ch));

            return res * sgn;
        }

        public double nextDouble() {
            int ch = read();

            while (isSpaceChar(ch))
                ch = read();

            int sgn = 1;
            if (ch == '-') {
                sgn = -1;
                ch = read();
            }

            double res = 0;
            while (!isSpaceChar(ch) && ch != '.') {
                if (ch == 'e' || ch == 'E')
                    return res * Math.pow(10, nextInt());
                if (ch < '0' || ch > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += ch - '0';
                ch = read();
            }
            if (ch == '.') {
                ch = read();
                double m = 1;
                while (!isSpaceChar(ch)) {
                    if (ch == 'e' || ch == 'E')
                        return res * Math.pow(10, nextInt());
                    if (ch < '0' || ch > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (ch - '0') * m;
                    ch = read();
                }
            }

            return res * sgn;
        }

        public String readString() {
            int ch = read();
            while (isSpaceChar(ch))
                ch = read();

            StringBuilder res = new StringBuilder();

            do {
                res.appendCodePoint(ch);
                ch = read();
            }
            while (!isSpaceChar(ch));

            return res.toString();
        }

        public boolean isSpaceChar(int ch) {
            if (filter != null)
                return filter.isSpaceChar(ch);
            return ch == ' ' || ch == '\n' || ch == '\r' || ch == '\t' || ch == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    static class Print {
        private final BufferedWriter bw;

        public Print() {
            this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object)throws IOException {
            bw.append(""+object);
        }

        public void println(Object object)throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close()throws IOException {
            bw.close();
        }
    }

    public static void main(String args[]) throws IOException {
        Scan sc = new Scan();
        Print pr = new Print();

        long ax, ay, bx, by, cx, cy;
        ax=sc.nextInt();
        ay=sc.nextInt();
        bx=sc.nextInt();
        by=sc.nextInt();
        cx=sc.nextInt();
        cy=sc.nextInt();
        
        long ab, bc, ac;
        
        ab = (ax-bx)*(ax-bx) + (ay-by)*(ay-by);
        bc = (bx-cx)*(bx-cx) + (by-cy)*(by-cy);
        ac = (ax-cx)*(ax-cx) + (ay-cy)*(ay-cy);
        
        double arr[] = new double[3];
        arr[0]=ab;
        arr[1]=bc;
        arr[2]=ac;
        
        Arrays.sort(arr);
        
        if((ay-by)*(bx-cx)==(by-cy)*(ax-bx)) 
            pr.println("No");
        else if(ab==bc) 
            pr.println("Yes");
        else
            pr.println("No");
        
        
        pr.close();

    }
}
