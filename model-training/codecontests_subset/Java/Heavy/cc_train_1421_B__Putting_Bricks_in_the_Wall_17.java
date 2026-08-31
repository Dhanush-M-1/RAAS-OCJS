

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
        public int[] nia1(int n) {
            int a[] = new int[n+1];
            for (int i = 1; i <=n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public long[] nla(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public long[] nla1(int n) {
            long a[] = new long[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public Long[] nLa(int n) {
            Long a[] = new Long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public Long[] nLa1(int n) {
            Long a[] = new Long[n+1];
            for (int i = 1; i <= n; i++) {
                a[i] = nl();
            }
            return a;
        } 
        public Integer[] nIa(int n) {
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        } 
        public Integer[] nIa1(int n) {
            Integer a[] = new Integer[n+1];
            for (int i = 1; i <= n; i++) {
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
        private final int x, y;
        public Key(int x, int y) {
            this.x = x; this.y = y;
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
            int x,y;
            Pair(int a,int b){
                    x=a;y=b;
            }
//            @Override
//            public int compareTo(Pair p) {
//                    if(x==p.x) return y-p.y;
//                    return x-p.x;
//            }
    }
    static void shuffleArray(int temp[]){
        int n = temp.length;
        Random rnd = new Random();
        for(int i=0; i<n; ++i){
            int tmp = temp[i];
            int randomPos = i + rnd.nextInt(n-i);
            temp[i] = temp[randomPos];
            temp[randomPos] = tmp;
        }   
    }
    static long gcd(long a,long b){ return b==0?a:gcd(b,a%b);}
    static long lcm(long a,long b){return (a/gcd(a,b))*b;}
    static PrintWriter ww = new PrintWriter(System.out);
    static long mod=998244353L,mod1=1000000007;
    //static int r[]={0,1,0,-1}, c[]={1,0,-1,0};
    static long modInverse(long a, long m){
        long num=m;
        long x=1;
        long power=a%mod;
        while(num>0){
              if(num%2==1){
                  x=(x*power)%mod;
            }
            num>>=1;
            power=(power*power)%mod;         
        }
        return x;
    }
    static long fact[]=new long[1000005];
    public static void findFact(){
        fact[0]=1;
        for(int i=1;i<=1000000;i++){
            fact[i]=(i*fact[i-1])%mod;
        }
    } 
    static long ncrWithMod(int n,int r){
        if(n<r)return 0L;

        return (fact[n]*modInverse((fact[r]*fact[n-r])%mod,mod-2))%mod;
    }

    public static void main(String [] args){
        InputReader sc=new InputReader(System.in); 
        int tt = sc.ni();
        while(tt -- > 0){
            int n = sc.ni();
            char arr[][] = new char[n][n];
            for(int i = 0 ; i < n ; i ++){
                arr[i] = sc.nextLine().toCharArray();
            }
            int a = arr[0][1] - '0';
            int b = arr[1][0] - '0';
            int c = arr[n - 1][n - 2] - '0';
            int d = arr[n - 2][n - 1] - '0';
            if(a == b && b == c && c == d){
                ww.println(2);
                ww.println(1+" "+2);
                ww.println(2+" "+1);
            }
            else if(a == b && c == d){
                ww.println(0);
            }
            else{
                if((a + b + c + d) == 2){
                    ww.println(2);
                    if(a == 0)ww.println(1 +" "+2);
                    else ww.println(2 +" "+1);
                    if(c == 1)ww.println((n) +" "+(n -1));
                    else ww.println((n - 1) +" "+(n));
                }
                else{
                    ww.println(1);
                    if(a == b){
                        if(a == c){
                            ww.println((n) +" "+(n -1));
                        }
                        else{
                            ww.println((n - 1) +" "+(n));
                        }
                    }
                    else{
                        if(a == c){
                            ww.println(1 +" "+2);
                        }
                        else{
                            ww.println(2+" "+1);
                        }
                    }
                }
            }
        }
        
        ww.close();
    }
}
    