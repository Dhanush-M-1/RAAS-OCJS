// Magic. Do not touch.
import java.io.*;
import java.math.*;
import java.util.*;

public class Main {
    static class FastReader
    {
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public FastReader() { this(System.in); }public FastReader(InputStream is) { mIs = is;}
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];}
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;}
        public String next(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();}
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;}
        public int i(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;}
        public double d() throws IOException {return Double.parseDouble(next()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; }
        public void scanIntArr(int [] arr){ for(int li=0;li<arr.length;++li){ arr[li]=i();}}
        public void scanIntIndexArr(int [] arr){ for(int li=0;li<arr.length;++li){ arr[li]=i()-1;}}
        public void scanLongArr(long [] arr){for (int i=0;i<arr.length;++i){arr[i]=l();}}
        public void shuffle(int [] arr){ for(int i=arr.length;i>0;--i) { int r=(int)(Math.random()*i); int temp=arr[i-1]; arr[i-1]=arr[r]; arr[r]=temp; } }
        public int swapIntegers(int a,int b){return a;} //Call it like this: a=swapIntegers(b,b=a)
    }

    public static void main(String[] args) throws IOException {

        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        /*
inputCopy
3
2 1 3
3 3 6
99995 9998900031 9998900031
outputCopy
1 2 1
1 3 2 3
1


2
3 1 6
1 1 1

3
3 6 7
3 6 6
3 7 7

4
100000 9999899997 9999900001
100000 9999899998 9999900001
10 87 91
10 86 91

2
10 12 91
10 12 90
         */
        //Press Ctrl+Win+Alt+L for reformatting indentation

        int t = fr.i();
        for (int ti = 0; ti < t; ++ti) {
            int n=fr.i();
            long l=fr.l();
            long r=fr.l();
            long cur=n-1;
            long l2=l;
            while(l2-2L*cur>0 && cur!=0){
                l2-=2L*cur;
                --cur;
            }

            long i=n-cur;
            long rem=(l2-1)/2;
            long i2=i+1+rem;
            long toPrint=r-l+1;
            //System.err.println("i="+i+" i2="+i2+" "+toPrint);
            if(l%2==0)
            {
                pw.print(i2+" ");
                ++i2;
                if(i2>n)
                {
                    ++i;
                    i2=i+1;
                }
                --toPrint;
            }
            for(;i<=n;++i)
            {
                for(;i2<=n && toPrint>0;++i2)
                {
                    if(toPrint>=2) {
                        pw.print(i + " " + i2 + " ");
                        toPrint-=2;
                    }
                    else {
                        pw.print(i + " ");
                        toPrint -= 1;
                    }
                }
                i2=i+2;
            }
            if(toPrint>0)
            {
                pw.print(1+" ");
            }
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}