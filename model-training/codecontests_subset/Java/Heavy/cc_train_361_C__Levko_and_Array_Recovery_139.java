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
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] T = new int[M];
		int[] L = new int[M];
		int[] R = new int[M];
		int[] O = new int[M];
		
		int[] array = new int[N];
		int[] add = new int[N];
		Arrays.fill(add,1000000000);
		
		for(int a=0;a<M;a++){
			T[a]=sc.nextInt();
			L[a]=sc.nextInt()-1;
			R[a]=sc.nextInt()-1;
			O[a]=sc.nextInt();
			
			if(T[a]==1){
				for(int b=L[a];b<=R[a];b++)
					array[b]+=O[a];
			}
			else{
				for(int b=L[a];b<=R[a];b++)
					add[b]=Math.min(add[b], O[a]-array[b]);
			}
		}
		
		int[] temp = add.clone();
		for(int a=0;a<M;a++){
			if(T[a]==1){
				for(int b=L[a];b<=R[a];b++)
					temp[b]+=O[a];
			}
			else{
				int largest = Integer.MIN_VALUE;
				for(int b=L[a];b<=R[a];b++)
					largest=Math.max(temp[b], largest);
				if(largest!=O[a]){
					out.println("NO");
					out.close();
				}
			}
		}
		out.println("YES");
		for(int a=0;a<N;a++)
			out.print(add[a]+" ");
	
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
