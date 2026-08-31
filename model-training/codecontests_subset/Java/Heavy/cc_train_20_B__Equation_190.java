import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.PriorityQueue;


public class B {
	public static void main(String[] args) {
		MScanner sc = new MScanner();
		PrintWriter out = new PrintWriter(System.out);
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		double C = sc.nextDouble();
		if(A==0&&B==0&C==0)out.println("-1");
		else if(A==0&&B==0)out.println("0");
		else if(A==0)out.printf("1\n%.9f",-C/B);
		else {
			double D = B*B - 4*A*C;
			if(D<0)out.println("0");
			else if(D==0)out.printf("1\n%.9f", -B/(2*A));
			else{
				double N = (-B-Math.sqrt(D))/(2*A);
				double P = (-B+Math.sqrt(D))/(2*A);
				out.printf("2\n%.9f\n%.9f",Math.min(N,P),Math.max(P, N));
			}
		}
		out.close();
	}



	static class MScanner{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		
		public MScanner(){
			stream = System.in;
			//stream = new FileInputStream(new File("dec.in"));

		}
		int read(){
			if(numChars==-1)
				throw new InputMismatchException();
			if(curChar>=numChars){
				curChar = 0;
				try{
					numChars = stream.read(buf);
				} catch (IOException e){
					throw new InputMismatchException();
				}
				if(numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
		
		boolean isSpaceChar(int c){
			return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
		}
		boolean isEndline(int c){
			return c=='\n'||c=='\r'||c==-1;
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
		int[] nextIntArray(int N){
			int[] ret = new int[N];
			for(int a=0;a<N;a++)
				ret[a] = nextInt();
			return ret;
		}
		long nextLong(){
			return Long.parseLong(next());
		}
		long[] nextLongArray(int N){
			long[] ret = new long[N];
			for(int a=0;a<N;a++)
				ret[a] = nextLong();
			return ret;
		}
		double nextDouble(){
			return Double.parseDouble(next());
		}
		double[] nextDoubleArray(int N){
			double[] ret = new double[N];
			for(int a=0;a<N;a++)
				ret[a] = nextDouble();
			return ret;
		}
		String next(){
			int c = read();
			while(isSpaceChar(c))
				c=read();
			StringBuilder res = new StringBuilder();
			do{
				res.appendCodePoint(c);
				c=read();
			} while(!isSpaceChar(c));
			return res.toString();
		}
		String[] nextArray(int N){
			String[] ret = new String[N];
			for(int a=0;a<N;a++)
				ret[a] = next();
			return ret;
		}
		String nextLine(){
			int c = read();
			while(isEndline(c))
				c=read();
			StringBuilder res = new StringBuilder();
			do{
				res.appendCodePoint(c);
				c = read();
			}while(!isEndline(c));
			return res.toString();
		}
		
	}
}
