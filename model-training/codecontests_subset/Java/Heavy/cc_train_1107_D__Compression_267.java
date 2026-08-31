import java.io.*;
import java.util.InputMismatchException;

public class D {

    public static void main(String args[]) throws Exception {
        String[] a = {"0000",
                "0001",
                "0010",
                "0011",
                "0100",
                "0101",
                "0110",
                "0111",
                "1000",
                "1001",
                "1010",
                "1011",
                "1100",
                "1101",
                "1110",
                "1111"
        };
        int n = scn.nextInt();
        String[] s = new String[n];
        for(int i=0; i<n; i++){
            s[i] = scn.next();
        }
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){

            for(int k=0, j=0; k<s[i].length(); k++) {
                int num;
                if((s[i].charAt(k))>='A'){
                    num = 10+((s[i].charAt(k)-'A'));
                }else{
                    num = (s[i].charAt(k)-'0');
                }

                for (int m=0;m<4;m++,j++) {
                    arr[i][j] = (a[num].charAt(m) - '0');
                }
            }
        }
//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }
        int ans = n;
        for(int i=0; i<n; i++){
            int count = 1;
            int k = arr[i][0];
            for(int j=1; j<n; j++){
                if(arr[i][j]!=k){
                    ans = gcd(ans, count);
                    count = 1;
                    k = arr[i][j];
                }else{
                    count++;
                }
            }
        }
        for(int i=0; i<n; i++){
            int count = 1;
            int k = arr[0][i];
            for(int j=1; j<n; j++){
                if(arr[j][i]!=k){
                    ans = gcd(ans, count);
                    count = 1;
                    k = arr[j][i];
                }else{
                    count++;
                }
            }
        }
        out.println(ans);
        out.close();
    }

    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }

    static class Pair implements Comparable<Pair> {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return this.x + " [" + this.y + "]";
        }
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.x, o.x);
        }
        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair o = (Pair) obj;
                return this.x == o.x && this.y == o.y;
            }
            return false;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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

    public static InputReader scn = new InputReader(System.in);
    public static PrintWriter out = new PrintWriter(System.out);
}