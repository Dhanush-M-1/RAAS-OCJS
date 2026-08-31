
    import java.io.*;
    import java.util.*;

    public class Main {
    
    public static void main(String[] args) throws IOException {
        //FastScanner in = new FastScanner(new FileInputStream(new File("phi.in")));
        //PrintWriter out = new PrintWriter(new File("output.txt"));
        FastScanner in = new FastScanner(System.in);
        new Main().solve(in);
    }
    
    /* begin() */
    
    void solve(FastScanner in){
        int st = 1;
        int ed = (int)1e6;
        int n = in.nextInt();
        int pos[] = new int[n];
        for(int i=0; i<n; i++) pos[i] = in.nextInt();
        Arrays.sort(pos);
        int i = 0;
        int j = n-1;
        int ans = 0;
        while(i<=j){
            if(pos[i] - st < ed - pos[j]){
                int head = pos[i] - st;
                i++;
                ans += head;
                st += head;
                ed -= head;
            }else{
                int head = ed - pos[i];
                j--;
                ans += head;
                st += head;
                ed -= head;
            }
        }
        System.out.println(ans);
    }
        
    /* end() */
    
    private static class FastScanner {

        private final InputStream stream;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }


        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
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

        public String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}