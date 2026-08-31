/* Author: Ronak Agarwal, reader part not written by me*/
import java.io.* ; import java.util.* ;
import static java.lang.Math.min ; import static java.lang.Math.max ;
import static java.lang.Math.abs ; import static java.lang.Math.log ;
import static java.lang.Math.pow ; import static java.lang.Math.sqrt ;
/* Thread is created here to increase the stack size of the java code so that recursive dfs can be performed */
public class Codeshefcode{
	public static void main(String[] args) throws IOException{
		new Thread(null,new Runnable(){	public void run(){ exec_Code() ;} },"Solver",1l<<27).start() ;
	}
	static void exec_Code(){
		try{
			Solver Machine = new Solver() ;
			Machine.Solve() ; Machine.Finish() ;}
		catch(Exception e){ e.printStackTrace() ; print_and_exit() ;}
		catch(Error e){ e.printStackTrace() ; print_and_exit() ; }
	}
	static void print_and_exit(){ System.out.flush() ; System.exit(-1) ;}
}
/* Implementation of the Reader class */
class Reader { 
	private InputStream mIs;
	private byte[] buf = new byte[1024];
	private int curChar,numChars;
	public Reader() { this(System.in); } 
	public Reader(InputStream is) { mIs = is;} 
	public int read() {
		if (numChars == -1) throw new InputMismatchException();    
		if (curChar >= numChars) {
			curChar = 0;
			try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}
			if (numChars <= 0) return -1;            
		}
		return buf[curChar++];
	} 
	public String nextLine(){
		int c = read();
		while (isSpaceChar(c)) c = read();        
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString() ;
	} 
	public String s(){
		int c = read();
		while (isSpaceChar(c)) c = read();        
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		}while (!isSpaceChar(c));
		return res.toString();
	} 
	public long l(){
		int c = read();
		while (isSpaceChar(c)) c = read();        
		int sgn = 1;
		if (c == '-') { sgn = -1 ; c = read() ; }
		long res = 0;
		do{
			if (c < '0' || c > '9') throw new InputMismatchException();
			res *= 10 ; res += c - '0' ; c = read();
		}while(!isSpaceChar(c));
		return res * sgn;
	} 
	public int i(){
		int c = read() ;
		while (isSpaceChar(c)) c = read();        
		int sgn = 1;
		if (c == '-') { sgn = -1 ; c = read() ; }
		int res = 0;
		do{
			if (c < '0' || c > '9') throw new InputMismatchException();
			res *= 10 ; res += c - '0' ; c = read() ;
		}while(!isSpaceChar(c));
		return res * sgn;
	} 
	public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; } 
	public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; } 
}   
/* All the useful functions,constants,renamings are here*/
class Template{
	/* Constants Section */
	final int INT_MIN = Integer.MIN_VALUE ; final int INT_MAX = Integer.MAX_VALUE ;
	final long LONG_MIN = Long.MIN_VALUE ; final long LONG_MAX = Long.MAX_VALUE ;
	static long MOD = 1000000007 ;
	static Reader ip = new Reader() ;	
	static PrintWriter op = new PrintWriter(System.out) ;
	/* Methods for writing */
	static void p(Object o){ op.print(o) ; }
	static void pln(Object o){ op.println(o) ;}
	static void Finish(){ op.flush(); op.close(); }
	/* Implementation of operations modulo MOD */
	static long inv(long a){ return powM(a,MOD-2) ; }
	static long m(long a,long b){ return (a*b)%MOD ; }
	static long d(long a,long b){ return (a*inv(b))%MOD ; }
	static long powM(long a,long b){
		if(b<0) return powM(inv(a),-b) ;
		long ans=1 ;
		for( ; b!=0 ; a=(a*a)%MOD , b/=2) if((b&1)==1) ans = (ans*a)%MOD ;
		return ans ;
	}
	/* Renaming of some generic utility classes */
	final static class mylist extends ArrayList<Integer>{}
	final static class myset extends TreeSet<pair>{}
	final static class mystack extends Stack<Integer>{}
	final static class mymap extends TreeMap<Integer,Integer>{}
}
/* Implementation of the pair class, useful for every other problem */
class pair implements Comparable<pair>{
	int x ; int y ;
	pair(int _x,int _y){ x=_x ; y=_y ;} 
	public int compareTo(pair p){
		return (this.x<p.x ? -1 : (this.x>p.x ? 1 : (this.y<p.y ? -1 : (this.y>p.y ? 1 : 0)))) ;
	}
}
/* Main code starts here */
class Solver extends Template{
	int n,m,k;
	myset s;
	int d[];
	mylist N[];
	void correctSet(){
		while(!s.isEmpty()){
 			if(s.first().x>=k) break;
 			int u = s.pollFirst().y;
 			for(int v : N[u]) if(s.contains(new pair(d[v],v))){
 				s.remove(new pair(d[v],v));
 				d[v]--;
 				s.add(new pair(d[v],v));
 			}
 		}
	}
 	public void Solve() throws IOException{
 		n = ip.i();
 		m = ip.i();
 		k = ip.i();
 		pair E[] = new pair[m];
 		N = new mylist[n+1];
 		d = new int[n+1];
 		for(int i=1 ; i<=n ; i++) N[i] = new mylist();
 		for(int i=0 ; i<m ; i++){
 			int u = ip.i(); int v = ip.i(); 
 			E[i] = new pair(u,v);
 			N[u].add(v); N[v].add(u);
 			d[u]++; d[v]++;
 		}
 		s = new myset();
 		for(int i=1 ; i<=n ; i++) s.add(new pair(d[i],i));
 		correctSet();
 		mylist res = new mylist();
 		for(int i=(m-1) ; i>=0 ; i--){
 			res.add(s.size());
 			int u = E[i].x; int v = E[i].y;
 			N[u].remove(N[u].size()-1);
 			N[v].remove(N[v].size()-1);
 			boolean uins = s.contains(new pair(d[u],u));
 			boolean vins = s.contains(new pair(d[v],v));
 			if(!uins || !vins) continue;
 			s.remove(new pair(d[u],u));
 			s.remove(new pair(d[v],v));
 			d[u]--; d[v]--;
 			s.add(new pair(d[u],u));
 			s.add(new pair(d[v],v));
 			correctSet();
 		}
 		Collections.reverse(res);
 		for(int elem : res) pln(elem);
 	}
} 
