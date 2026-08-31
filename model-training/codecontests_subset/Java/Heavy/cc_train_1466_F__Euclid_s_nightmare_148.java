import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;

public class Main {
    static PrintWriter out;
    static Reader in;
    public static void main(String[] args) throws IOException {
        input_output();
        //out = new PrintWriter(System.out);
        //in = new Reader(new FileInputStream("card.in"));
        Main solver = new Main();
        solver.solve();
        out.close(); 
        out.flush(); 
    }

    static int INF = (int)1e9;
    static int maxn = (int)1e3+5;
    static int mod = (int)1e9+7;
    static int n, m, q, t, k;
    static double pi = 3.141592653589;

    void solve() throws IOException{
    	n = in.nextInt();
    	m = in.nextInt();

    	List<Integer> ans = new ArrayList<>();

    	par = new int[m+1];
    	rank = new int[m+1];
    	single = new boolean[m+1];
    	for (int i = 1; i <= m; i++) {
    		par[i] = i;
    		rank[i] = 1;
    		single[i] = false;
    	}

    	int x, y;
    	for (int i = 0; i < n; i++) {
    		int size = in.nextInt();

    		if (size == 2) {
    			x = in.nextInt();
    			y = in.nextInt();

    			int rootx = find(x),
    				rooty = find(y);
    			if (rootx == rooty || (single[rootx] && single[rooty]))  continue;
    			ans.add(i+1);
    			union(rootx, rooty);
    		} else {
    			x = in.nextInt();
    			int rootx = find(x);

    			if (single[rootx]) continue;
    			ans.add(i+1);
    			single[rootx] = true;
    		}
    	}

    	long cnt = 1;
    	for (int i = 1; i <= ans.size(); i++) cnt = (cnt*2)%mod;

    	out.println(cnt+" "+ans.size());
    	for (int i = 0; i < ans.size(); i++) out.print(ans.get(i)+" ");
    	out.println();
   	}

    //<>

   	static int[] par, rank;
   	static boolean[] single;
    static int find(int x) {
    	if (par[x] != x) par[x] = find(par[x]);
    	return par[x];
    }

    static void union(int x, int y) {
		int rootx = find(x),
			rooty = find(y);

		if (rootx == rooty) return;
		if (rank[x] < rank[y]) {
			par[x] = par[y];
			single[y] |= single[x];
		} else if (rank[y] < rank[x]) {
			par[y] = par[x];
			single[x] |= single[y];
		} else {
			par[x] = par[y];
			single[y] |= single[x];
			rank[y]++;
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