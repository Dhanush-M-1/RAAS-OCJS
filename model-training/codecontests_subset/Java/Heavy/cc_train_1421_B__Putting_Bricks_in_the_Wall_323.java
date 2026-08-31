import java.io.*;
import java.util.*;
public class noob {
    InputReader in;
    final long mod=1000000007;
    StringBuilder sb;
    public static void main(String[] args) throws java.lang.Exception {
        new noob().run();
    }
    void run() throws Exception {
        in=new InputReader(System.in);
        sb = new  StringBuilder();
        int t=i();
        for(int i=1;i<=t;i++)
            solve();
        System.out.print(sb);
    } 
    void solve() {
        int i,j;
        int n=i();
        char s[][]=new char[n][n];
        for(i=0;i<n;i++)
            s[i]=s().toCharArray();
        int p=s[0][1]-'0';
        int q=s[1][0]-'0';
        int x=s[n-1][n-2]-'0';
        int y=s[n-2][n-1]-'0';
        ArrayList<Integer> list=new ArrayList<>();
        if(p==q) {
            if(x==p) {
                list.add(n);
                list.add(n-1);
            }
            if(y==p) {
                list.add(n-1);
                list.add(n);
            }
        }
        else { 
            if(x==y) {
                if(p==x) {
                    list.add(1);
                    list.add(2);
                }
                else {
                    list.add(2);
                    list.add(1);
                }
            }
            else { // fix p, alter q
                list.add(2);
                list.add(1);
                if(x==p) {
                    list.add(n);
                    list.add(n-1);
                }
                else {
                    list.add(n-1);
                    list.add(n);
                }
            }
        }
        //System.out.println(list);
        sb.append((list.size()/2)+"\n");
        for(i=0;i<list.size();i+=2)
            sb.append(list.get(i)+" "+list.get(i+1)+"\n");
    }
    long power(long x, long y, long p) {  
        long res = 1;       
        x = x % p;  
        if (x == 0) return 0;   
        while (y > 0) {
            if((y & 1)==1) 
                res = (res * x) % p;  
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res%p; 
    } 
    int gcd(int a, int b) {
        return (b==0)?a:gcd(b,a%b);
    }
    String s(){return in.next();}
    int i(){return in.nextInt();}
    long l(){return in.nextLong();}
    double d(){return in.nextDouble();}
    class InputReader {
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
            while (x-->0)
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