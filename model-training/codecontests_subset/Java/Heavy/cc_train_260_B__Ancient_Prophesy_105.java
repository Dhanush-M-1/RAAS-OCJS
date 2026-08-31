
import java.util.*;
import java.lang.*;
import java.io.*;

public class CO_260B
{
	static int imax=Integer.MAX_VALUE,imin=Integer.MIN_VALUE;
	static long lmax=Long.MAX_VALUE,lmin=Long.MIN_VALUE;
	static long mod=(long)1e9+7;
	public static void main (String[] args) throws java.lang.Exception
	{
	
	//	Scanner scan=new Scanner(System.in);
		InputReader in =new InputReader(System.in);
		PrintWriter out=new PrintWriter(System.out);
//		int t=in.nextInt();
 		int t=1;
		while(t-->0){
			int i=0,j=0;	
			int arr[]={31,28,31,30,31,30,31,31,30,31,30,31};
			int data[][][]=new int[3][12][31];
			String str=in.next();
			int n=str.length();
			int max=0;
			int ansy=0,ansm=0,ansd=0;
			for(i=0;i<=n-10;i++){
				if(str.charAt(i)>='0'&&str.charAt(i)<='9' &&
				   str.charAt(i+1)>='0'&&str.charAt(i+1)<='9' &&
				   str.charAt(i+2)=='-' &&
				   str.charAt(i+3)>='0'&&str.charAt(i+3)<='9' &&
				   str.charAt(i+4)>='0'&&str.charAt(i+4)<='9' &&
				   str.charAt(i+5)=='-' &&
				   str.charAt(i+6)>='0'&&str.charAt(i+6)<='9' &&
				   str.charAt(i+7)>='0'&&str.charAt(i+7)<='9' &&
				   str.charAt(i+8)>='0'&&str.charAt(i+8)<='9' &&
				   str.charAt(i+9)>='0'&&str.charAt(i+9)<='9'){
				   int year=Integer.parseInt(str.substring(i+6,i+10));
//				   System.out/.println(year);
				   if(year>=2013&&year<=2015){
//					   System.out.print(year+" ");
					   int mth=Integer.parseInt(str.substring(i+3,i+5));
					   if(mth>=1&&mth<=12){
//						   System.out.print(mth+" math "+arr[mth-1]+" ");
						   int date=Integer.parseInt(str.substring(i,i+2));
//						   System.out.println(date+" ");
						   if(date>=1&&date<=arr[mth-1]){
							   	int cnt=++data[year-2013][mth-1][date-1];
							   	if(cnt>max){
							   		ansy=year;ansd=date;ansm=mth;
							   		max=cnt;
							   	}
						   }
					   }
				   }
				}
			}
			if(ansd<10&&ansm<10)
				out.println("0"+ansd+"-0"+ansm+"-"+ansy);
			else if(ansm<10)
				out.println(ansd+"-0"+ansm+"-"+ansy);
			else if(ansd<10)
				out.println("0"+ansd+"-"+ansm+"-"+ansy);
			else
				out.println(ansd+"-"+ansm+"-"+ansy);
				
		}
	out.close();
	}
	
	static void print(int arr[],int len){
		for(int i=0;i<len;i++)
		System.out.print(arr[i]+" ");
		System.out.println();
	}
	static class InputReader
	{
	 
	    private InputStream stream;
	    private byte[] buf = new byte[1024];
	    private int curChar;
	    private int numChars;
	 
	    public InputReader(InputStream stream) {
	        this.stream = stream;
	    }
	 
	    public int read() {
	        if (numChars == -1)
	            throw new InputMismatchException();
	        if (curChar >= numChars) {
	            curChar = 0;
	            try {
	                numChars = stream.read(buf);
	            } catch (IOException e) {
	                throw new InputMismatchException();
	            }
	            if (numChars <= 0)
	                return -1;
	        }
	        return buf[curChar++];
	    }
	 
	    public int nextInt() {
	        int c = read();
	        while (isSpaceChar(c))
	            c = read();
	        int sgn = 1;
	        if (c == '-') {
	            sgn = -1;
	            c = read();
	        }
	        int res = 0;
	        do {
	            if (c < '0' || c > '9')
	                throw new InputMismatchException();
	            res *= 10;
	            res += c & 15;
	            c = read();
	        } while (!isSpaceChar(c));
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
	            res += c & 15;
	            c = read();
	        } while (!isSpaceChar(c));
	        return res * sgn;
	    }
	 
	    public String next() {
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
	 
	    public String nextLine() {
	        int c = read();
	        //while (c != '\n' && c != '\r' && c != '\t' && c != -1)
	        //c = read();
	        StringBuilder res = new StringBuilder();
	        do {
	            res.appendCodePoint(c);
	            c = read();
	        } while (c != '\n' && c != '\r' && c != '\t' && c != -1);
	        return res.toString();
	    }
	 
	    public static boolean isSpaceChar(int c) {
	        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	    }
	 
	}   

}
