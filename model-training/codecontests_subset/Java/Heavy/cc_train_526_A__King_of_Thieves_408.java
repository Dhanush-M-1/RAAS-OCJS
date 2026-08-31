import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;


public class A {
	public static void main(String[] args) throws Exception {
		FinalScanner sc = new FinalScanner();
		PrintWriter out = new PrintWriter(System.out);
		int N = sc.nextInt();
		String in = sc.next();
		boolean OK = false;
		for(int a=0;a<N;a++){
			for(int s =1;s<N;s++){
				boolean cool = true;
				for(int b=0;b<5;b++){
					if(a+s*b>=N){
						cool=false;
						break;
					}
					cool &= in.charAt(a+(s*b))=='*';
				}
				OK|=cool;
			}
		}
		
		
		out.println(OK?"yes":"no");
		out.close();
	}
	
	static class FinalScanner{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		
		public FinalScanner(){
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
		int[] nextInt(int v){
			int[] temp = new int[v];
			for(int a=0;a<v;a++)temp[a]=nextInt();
			return temp;
		}
		long nextLong(){
			return Long.parseLong(next());
		}
		long[] nextLong(int v){
			long[] temp = new long[v];
			for(int a=0;a<v;a++)temp[a]=nextLong();
			return temp;
		}
		double nextDouble(){
			return Double.parseDouble(next());
		}
		double[] nextDouble(int v){
			double[] temp = new double[v];
			for(int a=0;a<v;a++)temp[a]=nextDouble();
			return temp;
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
		String[] next(int v){
			String[] temp = new String[v];
			for(int a=0;a<v;a++)temp[a]=next();
			return temp;
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
		String[] nextLine(int v){
			String[] temp = new String[v];
			for(int a=0;a<v;a++)temp[a]=nextLine();
			return temp;
		}
		
		
	}
}
