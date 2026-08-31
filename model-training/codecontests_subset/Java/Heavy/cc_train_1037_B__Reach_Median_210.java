/*input
5 0
5 5 8 8 2

*/

import java.util.*;
import java.io.*;
import java.math.*;
public class MCFB
{
	public static void main(String[] args) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		Bolt sc = new Bolt(System.in);	
		int n=sc.nextInt();
        long s=sc.nextLong();
        long[] arr=new long[n];
        int prev=0;
        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextLong();
            pq.add(arr[i]);
        }
        int c=0;
        for(int i=0;i<n/2;i++)
        {
            arr[c++] = (pq.poll());
        }
        arr[c] = pq.poll();
        int x=c;
        for(int i=c+1;i<n;i++)
            arr[i]=pq.poll();
        long sum=0;
        // System.out.println(arr[c]);
        if(arr[c]<s)
        {
            for(int i=c;i<n;i++)
            {
                if(arr[i]>=s)
                    break;
                sum+=s-arr[i];
            }
        }
        else if(arr[c]>s)
        {
            for(int i=c;i>=0;i--)
            {
                if(arr[i]<=s)
                    break;
                sum+=arr[i]-s;
            }
        }
        // int next=pq.poll();
        // int ans=Math.abs(s-x);
        System.out.println(sum);

        // System.out.println(sb);

    }
}

class Bolt
{
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
 
        public Bolt(InputStream stream) {
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
