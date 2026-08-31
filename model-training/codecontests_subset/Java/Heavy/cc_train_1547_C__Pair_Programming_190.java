import java.io.*;
import java.util.*;
import static java.lang.System.*;
import static java.lang.Math.*;
public class CodechefCook
{
    void run() {
        int tc=ni();
        StringBuilder sbb = new StringBuilder();
        xD:
        while(tc-->0) {
            int k=ni(),n=ni(),m=ni();
            int[] a=ni(n),b=ni(m);
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            StringBuilder sb = new StringBuilder();
            pq.add(k);
            int i=0,j=0;
            while(i<n && j<m) {
                if(a[i]==0) { pq.add(++k); i++; sb.append("0 "); }
                else if(b[j]==0) { pq.add(++k); j++; sb.append("0 "); }
                else if(a[i]<=b[j] && pq.peek()>=a[i]) sb.append(a[i++]).append(" ");
                else if(pq.peek()>=b[j]) sb.append(b[j++]).append(" ");
                else {
                    sbb.append("-1\n"); continue xD;
                }
            }
            while(i<n) {
                if(a[i]==0) { pq.add(++k); i++; sb.append("0 "); }
                else if(a[i]<=pq.peek()) { sb.append(a[i]).append(" "); i++; }
                else {
                    sbb.append("-1\n");
                    continue xD;
                }
            }
            while(j<m) {
                if(b[j]==0) { pq.add(++k); j++; sb.append("0 "); }
                else if(b[j]<=pq.peek()) { sb.append(b[j]).append(" "); j++; }
                else {
                    sbb.append("-1\n");
                    continue xD;
                }
            }
            sbb.append(sb).append("\n");
        }
        out.println(sbb);
        out.flush(); 
        out.close();
    }

    public static void main(String[] args)throws Exception {
        try { 
            // new Thread(null, new CodechefCook()::run, "1", 1 << 26).start();
            new Thread(null, new CodechefCook("ONLINE_JUDGE")::run, "1", 1 << 26).start();
        } catch(Exception e) {}
    }

    FastReader sc=null;PrintWriter out = null;
    public CodechefCook()throws Exception {
        sc = new FastReader(new FileInputStream("D:\\CP\\input.txt"));
        out = new PrintWriter(new BufferedWriter(new FileWriter("D:\\CP\\output.txt")));
    }
    public CodechefCook(String JUDGE) {
        sc = new FastReader(System.in);
        out = new PrintWriter(System.out);      
    }
    
    String ns() { return sc.next(); }
    int ni() { return sc.nextInt(); }
    long nl() { return sc.nextLong(); }
    int[] ni(int n) {
        int a[]=new int[n];
        for(int i=0;i<n;a[i++]=ni());
        return a;
    }
    long[] nl(int n) {
        long a[]=new long[n];
        for(int i=0;i<n;a[i++]=nl());
        return a;
    }
    
    int[][] ni(int n,int m) {
        int a[][]=new int[n][m];
        for(int i=0;i<n;i++) 
            for(int j=0;j<m;j++)
                a[i][j]=ni();
        return a;
    }
    long[][] nl(int n,int m) {
        long a[][]=new long[n][m];
        for(int i=0;i<n;i++) 
            for(int j=0;j<m;j++)
                a[i][j]=nl();
        return a;
    }
    long gcd(long a, long b) {
        return b==0?a:gcd(b,a%b);
    }
    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;
        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res*1L*10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res *1L* sgn;
        }
        
        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }
    }
}