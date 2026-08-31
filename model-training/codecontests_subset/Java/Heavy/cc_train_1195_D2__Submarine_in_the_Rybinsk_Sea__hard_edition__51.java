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
 
    static int INF = (int)1e9;
    static int maxn = (int)1e5*2+1;
    static int mod= 998244353 ;
    static int n,m,k,t,q,x,a,b,y,d;
    
    
    void solve(PrintWriter out, Reader in) throws IOException{
        n = in.nextInt();
        
        int[] lens = new int[11];
        
        String[] arr = new String[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = in.next();
            lens[arr[i].length()]++;
        }
            
        
        int len = arr[1].length();
        
        long ans=0;
        long[] pow = new long[20];
        pow[0]=1;
        for(int i=1;i<=19;i++) pow[i] = (pow[i-1]*10)%mod;
        
        int tmp=0;
        for(int i=1;i<=n;i++){
            len = arr[i].length();
            for(int j=len-1;j>=0;j--){
                tmp = (len-1-j+1)*2;
                for(int z=1;z<=10;z++){
                    tmp = (len-1-j+1)*2;
                    if(z>=len-j){
                        ans  = (ans+ (long)(arr[i].charAt(j)-'0')*(long)(pow[tmp-1])*(long)lens[z])%mod;
                        ans  = (ans+ (long)(arr[i].charAt(j)-'0')*(long)(pow[tmp-2])*(long)lens[z])%mod;
                    }else{
                        tmp=  2*z;
                        tmp+= len-j-z-1;
                        ans  = (ans+ (long)(arr[i].charAt(j)-'0')*(long)(pow[tmp])*(long)(lens[z]*2))%mod;
                    }
                }
            }
        }
        
        out.println(ans);
    }
    
    //<>
    
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