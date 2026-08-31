import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
/* * */

public class _731C implements Runnable{
    public static void main(String[] args) {
        new Thread(null, new _731C(),"Main",1<<27).start();
    }
    @Override
    public void run() {
        FastReader fd = new FastReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = fd.nextInt();
        for(; t > 0;--t){
            int lines = fd.nextInt();
            int n = fd.nextInt();
            int m = fd.nextInt();

            int[] mono = getArray(n,false,fd);
            int[] poly = getArray(m,false,fd);
            int i = 0, j = 0;
            ArrayList<Integer> ans = new ArrayList<>();
            boolean possible = true;
            while(i < n && j < m && possible){
                if(mono[i] == 0){ ans.add(0);i++; lines++;}
                else if(poly[j] == 0){ans.add(0);j++; lines++;}
                else if(mono[i] > lines && poly[j] > lines)possible = false;
                else{
                    if(poly[j] <= lines){ ans.add(poly[j]); j++; }
                    else if(mono[i] <= lines){ ans.add(mono[i]); i++; }
                }

            }
            while(i < n){
                if(mono[i] == 0){ ans.add(0); lines++;}
                else if(mono[i] > lines)possible = false;
                else{
                   ans.add(mono[i]);
                }
                i++;
            }
            while(j < m){
                if(poly[j] == 0){ ans.add(0); lines++;}
                else if(poly[j] > lines)possible = false;
                else{
                    ans.add(poly[j]);
                }
                j++;
            }
            if(possible) {
                for (int q : ans) out.print(q + " ");
                out.println();
            }
            else
                out.println(-1);

        }

        out.close();
    }

    void preproccess(int[][] matrix){
        int size = matrix.length;
        int cnt = 1;
        int j = 0;
        int k = 0;
        for(int i = 0; i < size; i++) {
            j = 0; k = i;
            while(j<size && k>=0) matrix[j++][k--]=cnt++;
        }


    }

    //Helper functions
    static int[] getArray(int n,boolean isSorted, FastReader fd){
        int[] data = new int[n];
        for(int i = 0; i < data.length; i++){ data[i] = fd.nextInt(); }
        if(isSorted) Arrays.sort(data);
        return data;
    }
    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int lcm(int a, int b) {
        return (a*b)/gcd(a, b);
    }


    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }

                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();

            while(isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}
