import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.*;
import java.io.*;
public class Main{
public static class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private InputReader.SpaceCharFilter filter;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public int read() {
        if (numChars==-1)
            throw new InputMismatchException();
 
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            }
            catch (IOException e) {
                throw new InputMismatchException();
            }
 
            if(numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public int nextInt() {
        int c = read();
 
        while(isSpaceChar(c))
            c = read();
 
        int sgn = 1;
 
        if (c == '-') {
            sgn = -1;
            c = read();
        }
 
        int res = 0;
        do {
            if(c<'0'||c>'9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c));
 
        return res * sgn;
    }
 
    public long nextLong() {
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
        }
        while (!isSpaceChar(c));
        return res * sgn;
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
 
    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        }
        while (!isSpaceChar(c));
 
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public String next() {
        return readString();
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
    public static void main(String[] args) throws Exception
    { 
        
       InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader sc = new InputReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);
            
            int n = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Long> both=new ArrayList<>();
            ArrayList<Long> a=new ArrayList<>();
            ArrayList<Long> b=new ArrayList<>();
            for(int i=0;i<n;i++)
        	{
        	   long tem=sc.nextLong();
        	   long x=sc.nextLong();
        	   long y=sc.nextLong();
        	 if(x==y && x==1)
        	 both.add(tem);
        	 else if(x==0 && y==1)
        	 {
        	  b.add(tem);
        	 }
        	 else if(x==1 && y==0)
        	 {
        	  a.add(tem);
        	 }
        	}
        	Collections.sort(a);
        	Collections.sort(both);
        	Collections.sort(b);
        	if(both.size()+a.size()<k || both.size()+b.size()<k)
            {
                w.println(-1);
            }
            else
		        {
             ArrayList<Long> ab = new ArrayList<>();
		        long sum=0;
		        for(int i=0;i<Math.min(a.size(),b.size());i++)
		        {
		            ab.add(sum+a.get(i)+b.get(i));
		            sum+=a.get(i)+b.get(i);
		        }
		        for(int i=1;i<both.size();i++)
		        both.set(i,both.get(i)+both.get(i-1));
		        long min=Long.MAX_VALUE;
		        sum=0;
		        for(int i=0;i<both.size();i++)
		        {
		            if(i<k)sum+=(long)both.get(i);
		            if(k-i-2>=ab.size() || k-i-2<0) continue;
		            min=Math.min(min,both.get(i)+ab.get(k-i-2));
		        }
		        if(both.size()>=k)min=Math.min(min,both.get(k-1));
		        if(ab.size()>=k) min=Math.min(min,ab.get(k-1));
		        
		        w.println(min);
		            
		        }
		        
		    
    w.close();
    }
 } 
  