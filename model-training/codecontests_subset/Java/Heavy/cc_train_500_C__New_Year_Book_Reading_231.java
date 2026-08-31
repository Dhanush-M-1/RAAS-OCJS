import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;


public class A {
	static int N,M;
	static int[] Q;
	public static void main(String[] args) throws Exception{
		FasterScanner sc = new FasterScanner();
		
		 N  = sc.nextInt();
		M = sc.nextInt();
		LinkedList<Book> AL = new LinkedList<Book>();
		int[] W = new int[N];
		for(int a=0;a<N;a++){
			W[a]=sc.nextInt();
			AL.add(new Book(W[a],a));
		}
//		Collections.sort(AL);
		Q = new int[M];
		for(int a=0;a<M;a++){
			Q[a] = sc.nextInt()-1;
		}
		for(int a=M-1;a>=0;a--){
			int find = Q[a];
			int i = 0;
			for(Book x : AL){
				if(x.i==find){
					break;
				}
				i++;
			}
			AL.addLast(AL.remove(i));
		}
//		for(Book x : AL){
//			System.err.print(x.i+" ");
//		}

		System.out.println(magic((LinkedList<Book>)AL.clone()));
		
		
	}
	private static long magic(LinkedList<Book> AL) {
		long total = 0;
		for(int a=0;a<M;a++){
			int find = Q[a];
			int i = 0;
			int t  = -1;
			for(Book x : AL){
				if(t!=-1){
					total+=x.w;
				}
				if(x.i==find){
					t=i;
				}
				i++;
			}
			AL.addLast(AL.remove(t));
		}
		return total;
	}
	static class Book implements Comparable<Book>{
		int w,i;
		Book(int a, int b){
			w=a;
			i=b;
		}
		@Override
		public int compareTo(Book i) {
			return -Integer.compare(this.w,i.w);
		}
	}
	
	static class DisjointSet {
		int[] p, r;

		DisjointSet(int s) {
			p = new int[s];
			r = new int[s];
			for (int i = 0; i < s; i++)
				p[i] = i;

		}
		
		void union(int x, int y) {
			int a = find(x);
			int b = find(y);
			if (a == b)
				return;
			if (r[a] == r[b])
				r[p[b] = a]++;
			else
				p[a] = p[b] = r[a] < r[b] ? b : a;
		}

		int find(int x) {
			return p[x] = p[x] == x ? x : find(p[x]);
		}

	}

	static class FasterScanner{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		
		public FasterScanner(){
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
}
