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
    
    static int maxn = (int)1e5*2;
    static long mod=(int)1e9+7;
    static int n,m,k,t;
    
    void solve(PrintWriter out, Reader in) throws IOException{   
        n = in.nextInt();
        k = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int q = in.nextInt();
        
        int[] arra = new int[n+1];
        int[] arrb = new int[n+1];
        long[] BITa = new long[n+1];
        long[] BITb = new long[n+1];
        
        int day=0,orders=0;
        while(q-->0){
            t = in.nextInt();
            
            if(t==1){
                day = in.nextInt();
                orders = in.nextInt();
                
                if(arra[day]<a) {
                    update(BITa,day,Math.min(orders,a-arra[day]));
                    arra[day]+=orders;
                }
                if(arrb[day]<b) {
                    update(BITb,day,Math.min(orders,b-arrb[day]));
                    arrb[day]+=orders;
                }
            }else{
                day = in.nextInt();
                long lo = query(BITb,day-1);
                long hi = query(BITa,n)-query(BITa,Math.min(n,day+k-1));
                out.println(lo+hi);
            }
        }
    }
    
    static void update(long[] BIT,int x,int v){
        for(int i=x;i<=n;i+=(i&-i))
            BIT[i]+=v;
        return;
    }
    
    static long query(long[] BIT,int x){
        long sum=0;
        for(int i=x;i>0;i-=(i&-i))
            sum+=BIT[i];
        return sum;
    }
    
    static class Edge {
        int x,y,w;
        
        Edge(int x,int y,int w){
            this.x = x;
            this.y = y;
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