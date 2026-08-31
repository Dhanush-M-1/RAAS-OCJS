import java.io.* ;
import java.math.* ;
import java.text.DecimalFormat;
import java.util.* ;
public class Codeshefcode {
	final static long r = 1000000007 ;
	static FasterScanner ip = new FasterScanner() ;
	static PrintWriter op = new PrintWriter(System.out) ; 
	public static void main(String[] args) throws IOException{
		int n = ip.i() ;
		int m = ip.i() ;
		int p[] = new int[n+1] ;
		for(int i=1 ; i<=n ; i++)
			p[i]=ip.i() ;
		MyList[] adj = new MyList[n+1] ;
		for(int i=0 ; i<n+1 ; i++)
			adj[i]=new MyList() ;
		for(int i=0 ; i<m ; i++){
			int a = ip.i() ;
			int b = ip.i() ;
			adj[a].add(b) ;
			adj[b].add(a) ;
		}
		int id[] = new int[n+1] ;
		int e=0 ;
		for(int i=1 ; i<=n ; i++){
			if(id[i]==0){
				e++ ;
				Stack<Integer> S = new Stack<Integer>() ;
				S.add(i) ;
				while(!S.isEmpty()){
					int node = S.pop() ;
					id[node]=e ;
					MyList ngs = adj[node] ;
					for(int nnode : ngs)
						if(id[nnode]==0)
							S.add(nnode) ;				
				}				
			}
		}
		MyList cmp[] = new MyList[e+1] ;
		for(int i=0 ; i<=e ; i++)
			cmp[i]=new MyList() ;
		for(int i=1 ; i<=n ; i++)
			cmp[id[i]].add(i) ;
		for(int i=1 ; i<=e ; i++){
			MyList cpt = cmp[i] ;
			MyList nodes = new MyList() ;
			for(int j : cpt)
				nodes.add(p[j]) ;
			Collections.sort(nodes) ;
			Collections.sort(cpt) ;
			int len = cpt.size() ;
			for(int j=0 ; j<len ; j++){
				int ind = cpt.get(len-j-1) ;
				int val = nodes.get(j) ;
				p[ind]=val ;
			}			
		}
		for(int i=1 ; i<=n ; i++)
			op.print(p[i]+" ") ;	
		Finish() ;	
	}
	static void Finish(){
		op.flush(); 
		op.close();
	}
}
@SuppressWarnings("serial") 
class MyList extends ArrayList<Integer>{
	
}
class MyDouble implements Comparable<MyDouble>{
	BigDecimal b ;
    MyDouble a(MyDouble m){
		return new MyDouble((this.b).add(m.b,MathContext.DECIMAL128)) ;
	}
	MyDouble s(MyDouble m){
		return new MyDouble((this.b).subtract(m.b,MathContext.DECIMAL128)) ;
	}
	MyDouble m(MyDouble d){
		return new MyDouble((this.b).multiply(d.b,MathContext.DECIMAL128)) ;
	}
	MyDouble d(MyDouble m){
		return new MyDouble((this.b).divide(m.b,MathContext.DECIMAL128)) ;
	}
	MyDouble(String s){
		b=new BigDecimal(s,MathContext.DECIMAL128) ;
	}
	MyDouble(BigDecimal e){
		b=e ;
	}
	public int compareTo(MyDouble md){
		return this.b.compareTo(md.b) ;
	} 
}
class pair implements Comparable<pair>{
	private long x ;
	private int y ;
	pair(long a,int b){
		x=a ;
		y=b ;		
	}
	public long x(){
		return x ;
	}
	public int y(){
		return y ;
	}
	public int compareTo(pair p){
		int l = Long.compare(this.x,p.x) ;
		if(l!=0)
			return l ;
		return Integer.compare(this.y,p.y) ;
	}
}
class FasterScanner {
 
    private InputStream mIs;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
 
    public FasterScanner() {
        this(System.in);
    }
 
    public FasterScanner(InputStream is) {
        mIs = is;
    }
 
    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
    
    }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = mIs.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }
 
    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }
 
    public String S() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public long l() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public int i() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    } 
} 