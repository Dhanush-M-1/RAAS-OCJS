import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;


public class C {
	static final long thing =100005;
	static final int size = 100005;
	public static void main(String[] args) {
		FasterScanner sc = new FasterScanner();
		PrintWriter out = new PrintWriter(System.out);
		
		int N = sc.nextInt();
		
		Points[] P = new Points[N];
		for(int a=0;a<N;a++){
			P[a]=new Points(sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(P);
		
		
		
		
		int[] X = new int[N];
		int[] Y = new int[N];
		int[] D = new int[N];
		long[] HASH = new long[N];
		
		HashSet<Integer> ROW[] = new HashSet[size];
		HashSet<Integer> COL[]= new HashSet[size];
		HashSet<Long> DIA[] = new HashSet[size*2];
//		for(int a=0;a<size;a++){
//			ROW[a]=new HashSet<Integer>();
//			COL[a]=new HashSet<Integer>();
//		}
//		for(int a=0;a<size*2;a++){
//			DIA[a] = new HashSet<Long>();
//		}
//		
		
		//init
		
		for(int a=0;a<N;a++){
			X[a]=P[a].x;
			Y[a]=P[a].y;
			HASH[a]= HASH(X[a],Y[a]);
			D[a] = diag(X[a],Y[a]);
			
			if(ROW[Y[a]]==null)ROW[Y[a]]=new HashSet<Integer>();
			ROW[Y[a]].add(X[a]);

			if(COL[X[a]]==null)COL[X[a]]=new HashSet<Integer>();
			COL[X[a]].add(Y[a]);

			if(DIA[D[a]]==null)DIA[D[a]]=new HashSet<Long>();
			DIA[D[a]].add(HASH[a]);
		}
		
		
		long count = 0;
		
		for(int a=0;a<N;a++){
			int U = COL[X[a]].size();
			int R = ROW[Y[a]].size();
			int DG = DIA[D[a]].size();
			COL[X[a]].remove(Y[a]);
			ROW[Y[a]].remove(X[a]);
			DIA[D[a]].remove(HASH[a]);
			
			//up
			if(U<=R&&U<=DG){
				for(Integer y : COL[X[a]]){
					if(Y[a]==y)continue;
					int disp = y-Y[a];
					int targetx = X[a]+disp;
					if(X[a]==targetx)continue;
					if(targetx<0||targetx>=size)continue;
					if(ROW[Y[a]].contains(targetx)&&
							DIA[D[a]].contains(HASH(targetx,y)))count++;
				}
			}
			//right
			else if(R<=U&&R<=DG){
				for(Integer x : ROW[Y[a]]){
					if(X[a]==x)continue;
					int disp = x-X[a];
					int targety = Y[a]+disp;
					if(Y[a]==targety)continue;
					if(targety<0||targety>=size)continue;
					if(COL[X[a]].contains(targety)&&
							DIA[D[a]].contains(HASH(x,targety)))count++;
				}
			}
			//dia
			else{
				for(Long H : DIA[D[a]]){
					int[] unhash = UNHASH(H);
					int tx = unhash[0];
					int ty = unhash[1];
					if(X[a]==tx||Y[a]==ty)continue;
					if(COL[X[a]].contains(ty)&&
							(ROW[Y[a]].contains(tx))){
					//	System.out.println(X[a]+","+Y[a]+" "+tx+" "+ty);
						count++;
					}
				}
			}
			
		}
		
		
		
		out.println(count);
		
		
		out.close();
	}
	static class Points implements Comparable<Points>{
		int x,y;
		Points(int xx ,int yy){
			x=xx;
			y=yy;
		}
		@Override
		public int compareTo(Points o) {
			if(this.x==o.x)return this.y-o.y;
			return this.x-o.x;
		}
	}

	private static int diag(int x, int y) {
		return 100001-x+y;
	}

	static long HASH(long x, long y){
		return x*thing + y;
	}
	
	static int[] UNHASH(long x){
		return new int[]{(int)(x/thing), (int)(x%thing)};
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
