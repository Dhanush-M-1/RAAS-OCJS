//package math_codet;

import java.io.*;
import java.util.*;
import java.math.*;
 /**************
*    AUTHOR:         AMAN KUMAR SINGH        *
*    INSTITUITION:   KALYANI GOVERNMENT ENGINEERING COLLEGE  *
**************/
public class lets_do {
    InputReader in;
    PrintWriter out;
    Helper_class h;
    final long mod=1000000007;
    final int N=200005;
    int MAX_Ai=100005;
    public static void main(String[] args) throws java.lang.Exception{
        new lets_do().run();
    }
    void run() throws Exception{
        in=new InputReader(System.in);
        out = new PrintWriter(System.out);
        h = new Helper_class();
        int t = 1;
        while(t-->0){
            solve();
        }
        out.flush();    
        out.close();
    }
    TreeMap<Long,Integer> tmap = new TreeMap<Long,Integer>();
    void solve(){
        int n = h.ni();
        long reqd = h.nl();
        long[] arr = new long[n];
        int i = 0;
        for(i = 0; i < n; i++)
            arr[i] = h.nl();
        Arrays.sort(arr);
        long x = arr[n/2];
        long sum=0;
        if(x<reqd){
            for(i=n/2;i<n;i++){
                if(arr[i]>=reqd)
                    break;
                sum+=reqd-arr[i];
            }
        }
        else{
            for(i=n/2;i>=0;i--){
                if(arr[i]<=reqd)
                    break;
                sum+=arr[i]-reqd;
            }
        }
        h.pn(sum);

    }
    void put_map(long x){
        Integer c = tmap.get(x);
        if(c == null)
            tmap.put(x, 1);
        else
            tmap.put(x, ++c);
    }
    void remove_map(long x){
        Integer c = tmap.get(x);
        if(c == 1)
            tmap.remove(x);
        else
            tmap.put(x, --c);
    }

    

    final Comparator<Entity> com=new Comparator<Entity>(){
        public int compare(Entity x, Entity y){
            int xx=Integer.compare(y.b, x.b);
            if(xx==0){
                int xxx=Integer.compare(x.a,y.a);
                return xxx;
            }
            else
                return xx;
        }
    };
    class Entity{
        int a;
        int b;
        Entity(int p, int q){
            a=p;
            b=q;
        }
    }
    

    class Helper_class{
        long gcd(long a, long b){return (b==0)?a:gcd(b,a%b);}
        int gcd(int a, int b){return (b==0)?a:gcd(b,a%b);}
        long gcd1(long a, long b){return (b==0)?a:gcd(b,a%b);}
        int bitcount(long n){return (n==0)?0:(1+bitcount(n&(n-1)));}
        void p(Object o){out.print(o);}
        void pn(Object o){out.println(o);}
        void pni(Object o){out.println(o);out.flush();}
        String n(){return in.next();}
        String nln(){return in.nextLine();}
        int ni(){return in.nextInt();}
        long nl(){return in.nextLong();}
        double nd(){return in.nextDouble();}

        long mul(long a,long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            a*=b;
            if(a>=mod)a%=mod;
            return a;
        }
        long modPow(long a, long p){
            long o = 1;
            while(p>0){
                if((p&1)==1)o = mul(o,a);
                a = mul(a,a);
                p>>=1;
            }
            return o;
        }
        long add(long a, long b){
            if(a>=mod)a%=mod;
            if(b>=mod)b%=mod;
            if(b<0)b+=mod;
            a+=b;
            if(a>=mod)a-=mod;
            return a;
        }
    }

    class InputReader{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
 
        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
 
        public int peek() {
            if (numChars == -1)
                return -1;
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    return -1;
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar];
        }
 
        public void skip(int x) {
            while (x-- > 0)
                read();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public String nextString() {
            return next();
        }
 
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
 
            return res.toString();
        }
 
        public String nextLine() {
            StringBuffer buf = new StringBuffer();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
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
 
        public boolean hasNext() {
            int value;
            while (isSpaceChar(value = peek()) && value != -1)
                read();
            return value != -1;
        }
 
        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}