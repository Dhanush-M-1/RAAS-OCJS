import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class magic2 {
	public static void main(String[] args) throws Exception {
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		String S = sc.next();
		int A = -(-S.length()+S.replaceAll("1", "").length());
		int B = -(-S.length()+S.replaceAll("2", "").length());
		int C = -(-S.length()+S.replaceAll("3", "").length());
		int N = A+B+C;
		StringBuilder SB = new StringBuilder("");
		for(int a=0;a<N;a++){
			if(A!=0){
				SB.append("1");
				A--;
			}
			else if(B!=0){
				SB.append("2");
				B--;
			}
			else if(C!=0){
				SB.append("3");
				C--;
			}
			if(a!=N-1)SB.append("+");
		}
		
		out.println(SB.toString());
		out.close();
	}


	static class FasterScanner{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		
		public FasterScanner(){
			stream = System.in;
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
		long nextLong(){
			return Long.parseLong(next());
		}
		double nextDouble(){
			return Double.parseDouble(next());
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
	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(InputStream in) throws Exception {
			br = new BufferedReader(new InputStreamReader(in));
			st = new StringTokenizer(br.readLine().trim());
		}

		public int numTokens() throws Exception {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine().trim());
				return numTokens();
			}
			return st.countTokens();
		}

		public boolean hasNext() throws Exception {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine().trim());
				return hasNext();
			}
			return true;
		}

		public String next() throws Exception {
			if (!st.hasMoreTokens()) {
				st = new StringTokenizer(br.readLine().trim());
				return next();
			}
			return st.nextToken();
		}

		public double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

		public float nextFloat() throws Exception {
			return Float.parseFloat(next());
		}

		public long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		public int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		public String nextLine() throws Exception {
			return br.readLine();
		}
	}

}
