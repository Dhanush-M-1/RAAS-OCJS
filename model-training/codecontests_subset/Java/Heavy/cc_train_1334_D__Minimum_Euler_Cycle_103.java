

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
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
    static class Pair{
        long x,y,z;
        public Pair(long x,long y,long z){
            this.x=x;
            this.y=y;
            this.z=z;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair key = (Pair) o;
            return x == key.x && y == key.y && z==key.z;
        }
    }
    static class Pair1{
        long x,y;
        public Pair1(long x,long y){
            this.x=x;
            this.y=y;
            
        }
    }
    static PrintWriter w = new PrintWriter(System.out);
    static long mod=998244353L,mod1=1000000007;
   
    public static void main(String [] args){
        InputReader sc=new InputReader(System.in);
        int t=sc.ni();
        int cou=0;
        while(t-->0){
            long n=sc.nl(),l=sc.nl(),r=sc.nl();
            long i=1,num=n-1,sx=1,sy=1,ran=r-l+1;
            while((i+2*num)<l&&num>0){
                i+=2*(num);
                num--;
                sx++;
            }
            sy=sx+1;
            while((i+2)<=l){
                i+=2;
                sy++;
            }
            if(i<l){
                w.print(sy+" ");
                sy++;
                ran--;
            }
            outer:
            while(sx<n){
                while(sy<=n){
                    if(ran>0){
                        w.print(sx+" ");
                        ran--;
                    }
                    else break;
                    if(ran>0){
                        w.print(sy+" ");
                        sy++;
                        ran--;
                    }
                    else break;
                    
                }
                sx++;
                sy=sx+1;
            }
            if(ran>0)w.print(1);
            w.println();
        }
      
        
        
        w.close();
    }
}