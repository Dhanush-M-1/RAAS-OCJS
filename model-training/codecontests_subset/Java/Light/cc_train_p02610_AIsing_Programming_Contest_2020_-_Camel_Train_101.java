import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    static PrintWriter out;
    static Reader in;
    public static void main(String[] args) throws IOException {
        //out = new PrintWriter(new File("out.txt"));
        //PrintWriter out = new PrintWriter(System.out);
        //in = new Reader(new FileInputStream("in.txt"));
        //Reader in = new Reader();
        input_output();
        Main solver = new Main();
        solver.solve();
        out.flush();
        out.close();
 
    }
 
    static int INF = (int)2e9+5;
    static int maxn = 100;
    static int mod=(int)1e9+7 ;
    static int n, m, t, q, k;
    // read the editorial of the last problem (K).

    void solve() throws IOException{
        t = in.nextInt();

        while (t --> 0) {
            n = in.nextInt();
            long ans = 0;

            ArrayList<Node> arr = new ArrayList<>();
            ArrayList<Node> left = new ArrayList<>(),
                            right = new ArrayList<>();
            int l, r, k;
            for (int i = 0; i < n; i++) {
                k = in.nextInt();
                l = in.nextInt();
                r = in.nextInt();

                if (l >= r) {
                    ans += r;
                    l -= r;
                    r -= r;
                    left.add(new Node (k, l, r));
                } else {
                    ans +=l;
                    r -= l;
                    l -= l;
                    right.add(new Node (k, l, r));
                }
                arr.add(new Node(k, l, r));
            }

            Collections.sort(arr);
            Collections.sort(left);
            Collections.sort(right);



            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i <= n+1; i++) set.add(i);
            Node e;
            int place;

            long[] le = new long[n+1],
                  ri = new long[n+1];
            int cnt = 0;
            long ansl = 0;
            for (int i = 0; i < left.size(); i++) {
                e = left.get(i);
                place = set.floor(e.k);
                if (place > 0) {
                    ansl += e.l;
                    set.remove(place);
                    cnt++;
                }
                le[cnt] = ansl;
            }
            long ansr =0;
            cnt = 0;
            set = new TreeSet<Integer>();
            for (int i = 0; i <= n+1; i++) set.add(i);
            for (int i = 0; i < right.size(); i++) {
                e = right.get(i);
                place = set.ceiling(e.k+1);
                if (place != n+1) {
                    ansr += e.r;
                    cnt++;
                    set.remove(place);
                }
                ri[cnt] = ansr;
            }

            for (int i = 1; i <= n; i++) {
                le[i] = Math.max(le[i], le[i-1]);
                ri[i] = Math.max(ri[i], ri[i-1]);
            }
            long add = 0;
            for (int i = 0; i <= n; i++) {
                add = Math.max(add, le[i]+ri[n-i]);
            }
            out.println(ans+add);
        }

    }
 
    //<>

    static class Node implements Comparable<Node>{
        int k, l, r;

        Node (int k, int l, int r) {
            this.k = k;
            this.l = l;
            this.r = r;
        }

        public int compareTo(Node o) {
            int tmp = Math.max(o.l, o.r)-Math.max(this.l, this.r) ;
            if (tmp != 0) return tmp;
            else return this.k - o.k;
        }
    }

    static class Reader {
 
        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
    
        public Reader() {
            this(System.in);
        }
    
        public Reader(InputStream is) {
            mIs = is;
        }
    
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
    
        }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    
        public String nextLine() {
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
    
        double nextDouble()
        {
            return Double.parseDouble(next());
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
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
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
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
    }
    static void input_output() throws IOException {
        File f = new File("in.txt");
        if(f.exists() && !f.isDirectory()) { 
            in = new Reader(new FileInputStream("in.txt"));
        } else in = new Reader();
        f = new File("out.txt");
        if(f.exists() && !f.isDirectory()) {
            out = new PrintWriter(new File("out.txt"));
        } else out = new PrintWriter(System.out);
    }
}