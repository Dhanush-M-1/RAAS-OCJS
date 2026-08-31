import java.io.*;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

import java.util.InputMismatchException;

public class Solution {
public static void main(String[] args){
 InputReader in=new InputReader(System.in);
 PrintWriter pw=new PrintWriter(System.out);
 int n=in.readInt();
 int m=in.readInt();
 if(n==m){
	 pw.println(n);
 }
 else
 pw.println(2);
 pw.close();
 
}
static long fib(long n)
{
long F[][] = new long[][]{{1,1},{1,0}};
if (n == 0)
    return 0;
power(F, n-1);
 
   return F[0][0];
}
  
 /* Helper function that multiplies 2 matrices F and M of size 2*2, and
 puts the multiplication result back to F[][] */
static void multiply(long F[][], long M[][])
{
long x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
long y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
long z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
long w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
  
F[0][0] = x%1000000007;
F[0][1] = y%1000000007;
F[1][0] = z%1000000007;
F[1][1] = w%1000000007;
}


static void power(long F[][], long n)
{
long i;
long M[][] = new long[][]{{1,1},{1,0}};
 
// n - 1 times multiply the matrix to {{1,0},{0,1}}
for (i = 2; i <= n; i++)
    multiply(F, M);
}
static long modulo(long a,long b,long c) {
	long x=1;
	long y=a;
	while(b > 0){
		if(b%2 == 1){
			x=(x*y)%c;
		}
		y = (y*y)%c; // squaring the base
		b /= 2;
	}
	return  x%c;
}
static long gcd(long x, long y)
{
	if(x==0)
		return y;
	if(y==0)
		return x;
	long r=0, a, b;
	a = (x > y) ? x : y; // a is greater number
	b = (x < y) ? x : y; // b is smaller number
	r = b;
	while(a % b != 0)
	{
		r = a % b;
		a = b;
		b = r;
	}
	return r;
}
static class Pair implements Comparable<Pair>{
	int x,y;
	Pair(int xx,int yy){
		x=xx;y=yy;
	}
	@Override
	public int compareTo(Pair o) {
		if(Integer.compare(o.y, this.y)==0){
			return Integer.compare(this.x, o.x);
		}
		else{
			return Integer.compare(this.y, o.y);
		}
	}
}
static  class InputReader
{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream)
    {
        this.stream = stream;
    }
 
    public int read()
    {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars)
        {
            curChar = 0;
            try
            {
                numChars = stream.read(buf);
            } catch (IOException e)
            {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int readInt()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-')
        {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do
        {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String readString()
    {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do
        {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
    public String readLine() {
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
    
 
    public double readDouble() {
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
                return res * Math.pow(10, readInt());
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
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }
    public long readLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
    public boolean isSpaceChar(int c)
    {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next()
    {
        return readString();
    }
 
    public interface SpaceCharFilter
    {
        public boolean isSpaceChar(int ch);
    }
    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
}
