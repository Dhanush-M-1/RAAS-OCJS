import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        //Scanner sc = new Scanner();
        Reader in = new Reader();
        Main solver = new Main();
        solver.solve(out, in);
        out.flush();
        out.close();
 
    }
 
    //<>
    // 
    
    static int maxn = (int)1e5*2;
    static long mod=998244353 ;
    static int n,m,t;
    
    
    void solve(PrintWriter out, Reader in) throws IOException{   
        n = in.nextInt();
        
        int total=0;
        int[] a = new int[n];
        for(int i=0;i<n;i++) {a[i] = in.nextInt();total+=a[i];}
        
        int[] b = new int[n];
        for(int i=0;i<n;i++) b[i] = in.nextInt();
        
        int[][] dp = new int[10100][n+1];
        for(int i=0;i<10100;i++)
            for(int j=0;j<=n;j++)
                dp[i][j] = -1;
                
        dp[0][0]=0;
        for(int i=0;i<n;i++){
            for(int j=10000;j>=0;j--){
                for(int k=1;k<=n;k++){
                    if(j-a[i]>=0 && dp[j-a[i]][k-1]!=-1) dp[j][k]=Math.max(dp[j][k],dp[j-a[i]][k-1]+b[i]);
                }
            }
        }
        
        int ans=0,idx=0;
        loop:for(int i=1;i<=n;i++){
            for(int j=10000;j>=1;j--){
                if(dp[j][i]>=total){
                    ans = total-j;
                    idx = i;
                    break loop;
                }
            }
        }
        
        out.println(idx+" "+ans);
    }
    
    static class Node implements Comparable<Node>{
        int idx,v;
        
        Node(int idx,int v){
            this.idx = idx;
            this.v = v;
        }
        
        public int compareTo(Node o){
            return this.v-o.v;
        }
    }
    
    static class Edge {
        int d,w;
        
        Edge(int d,int w){
            this.d = d;
            this.w = w;
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
}