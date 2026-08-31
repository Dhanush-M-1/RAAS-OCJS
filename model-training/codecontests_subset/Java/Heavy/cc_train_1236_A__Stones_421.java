import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
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
    static PrintWriter w = new PrintWriter(System.out);
    
        
        
    
    public static void main(String[] args) throws IOException {   
        InputReader sc=new InputReader(System.in);
        int t=sc.ni();
        while(t-->0){
            int a=sc.ni();
            int b=sc.ni();
            int c=sc.ni();
            int a1=a;
            int b1=b;
            int c1=c;
            
            int sum=0,sum1=0;
            if(b/2>=a)
            {
                sum+=(3*a);
                b-=(2*a);
            }
            else{
                int num=b/2;
                sum+=(3*(num));
                b=0;
            }
            if(c/2>=b)
            {
                sum+=(3*b);
                c-=(2*b);
            }
            else{
                int num=c/2;
                sum+=(3*(num));
                c=0;
            }
            
            
            if(c1/2>=b1)
            {
                sum1+=(3*b1);
                c1-=(2*b1);
                b1=0;
            }
            else{
                int num=c1/2;
                sum1+=(3*(num));
                c1=0;
                b1-=num;
            }
            if(b1/2>=a1)
            {
                sum1+=(3*a1);
                b1-=(2*a1);
            }
            else{
                int num=b1/2;
                sum1+=(3*(num));
                
            }
            w.println(Math.max(sum,sum1));
        }
        w.close();
    }
}