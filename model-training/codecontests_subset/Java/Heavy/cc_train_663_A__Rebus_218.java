/*
 * PDPM IIITDM Jabalpur
 * Asutosh Rana
 */

import java.util.*;
import java.io.*;
import java.math.*;

public class Main
{
    static long MOD = 1000000007;
    public static void main (String[] args) throws java.lang.Exception
    {
        InputReader in=new InputReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int t = 1;//in.readInt();

        while(t-->0){
            char[] S = br.readLine().toCharArray();
            int count0 = 1,count1 =0,rev = 0,n = 0;
            int j=S.length-1;
            	while(Character.isDigit(S[j])){
            		rev = rev*10 + (S[j]-'0');
            		j--;
            	}
            	//out.println(rev);
            	while(j<S.length-1){
            		n = n*10 + (rev%10);
            		rev/=10;j++;
            	}
            //out.println(n);
            for(int i=0;i<S.length;i++)
            	if(S[i]=='+'){
            		count0++;
            	}
            	else if(S[i]=='-'){
            		count1++;
            	}
            if(count0*n-count1<n)
            	out.println("Impossible");
            else if(count0-count1*n > n)
            	out.println("Impossible");
            else{
            	out.println("Possible");
            	int req = n - count0 + count1;
            	//out.println(req+ " "+count0+" "+count1);
            	if(req>=n-1){
            		out.print(n);
            		req -= (n-1);
            	}
            	else if(req>0){
            		out.print(req+1);
            		req=0;
            	}
            	else{
            		out.print("1");
            	}
            	for(int i=1;i<S.length;i++){
            		if(S[i]=='?' && S[i-2]=='-'){
            			if(req<0-(n-1)){
                    		out.print(n);
                    		req +=(n-1);
            			}
                    	else if(req<0){
                    		out.print(0-req+1);
                    		req=0;
                    	}
                    	else{
                    		out.print("1");
                    	}
            		}
            		else if(S[i]=='?' && S[i-2]=='+'){
            			if(req>=n-1){
                    		out.print(n);
                    		req-=(n-1);
            			}
                    	else if(req>0){
                    		out.print(req+1);
                    		req=0;
                    	}
                    	else{
                    		out.print("1");
                    	}
            		}	
            		else
            			out.print(S[i]);
            	}
            	out.println();
            }
        }
        out.flush();
        out.close();
    }


}

class InputReader{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream){this.stream = stream;}
    public int read(){
        if (numChars==-1) throw new InputMismatchException();
        if (curChar >= numChars){
            curChar = 0;
            try {numChars = stream.read(buf);}
            catch (IOException e){throw new InputMismatchException();}
            if(numChars <= 0) return -1;
        }
        return buf[curChar++];
    }

    public int readInt(){
        int c = read();
        while(isSpaceChar(c)) c = read();
        int sgn = 1;
        if (c == '-') {sgn = -1;c = read();}
        int res = 0;
        do {
            if(c<'0'||c>'9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        }
        while (!isSpaceChar(c)); return res * sgn;
    }

    public void readInt(int[] A){
        for(int i=0;i<A.length;i++)
            A[i] = readInt();
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
        }
        while (!isSpaceChar(c));
        return res * sgn;
    }

    public void readLong(long[] A){
        for(int i=0;i<A.length;i++)
            A[i] = readLong();
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

    public char[] readCharA(){
        return readString().toCharArray();
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
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