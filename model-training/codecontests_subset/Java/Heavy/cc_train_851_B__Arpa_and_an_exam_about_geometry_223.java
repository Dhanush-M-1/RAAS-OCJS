
import java.util.*;
import java.lang.*;
import java.io.*;
public class Prac{     
    static class InputReader { 
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        public InputReader(InputStream st) {
            this.stream = st;
        } 
        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } 
                catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public int ni() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        } 
        public long nl() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        } 
        public int[] nia(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public String rs() {
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
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        } 
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        } 
    }
    public static class Key {

        private final int x;
        private final int y;

        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Key)) return false;
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

    }
    
    static PrintWriter w = new PrintWriter(System.out);
    static long mod=998244353L,mod1=1000000007;
    static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static double sqrt(long num){
        int c1=0,c2=0;
        double a=(double)num;
        double ans=0;
        long start=0,end=(long)a;
        while(start<=end){
            c1++;
            long mid=(start+end)/2;
            if((mid*mid)==(long)a){
                ans=mid;
                break;
            }
            else if((mid*mid)<a){
                start=mid+1;
                ans=(double)mid;
            }
            else{
                end=mid-1;
            }
        }   
        double res=ans;
        double res1=0;        
        while(res1!=res){
            c2++;
            res1=res;
            res=(res+(a/res))/2;
        }
        return res; 
    }
    static double dist(long a,long b,long c,long d){
        double ans=sqrt((a-c)*(a-c)+(b-d)*(b-d));
        return ans;
    }
    public static void main(String [] args){
        InputReader sc=new InputReader(System.in);
        long a=sc.ni(),b=sc.ni(),c=sc.ni(),d=sc.ni(),e=sc.ni(),f=sc.ni();
        long r=a*(d-f)-c*(b-f)+e*(b-d);
        long ab=(a-c)*(a-c)+(b-d)*(b-d);
        long bc=(c-e)*(c-e)+(d-f)*(d-f);
        w.println(r!=0&&ab==bc?"YES":"NO");
        w.close();
    }
}