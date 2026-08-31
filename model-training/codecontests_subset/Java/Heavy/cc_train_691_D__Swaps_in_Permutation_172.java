 
import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import java.math.*;
import java.text.DecimalFormat;
public class Prac{     
    static class InputReader { 
        private final InputStream stream;
	private final byte[] buf = new byte[8192];
	private int curChar, snumChars;
 	public InputReader(InputStream st) {
            this.stream = st;
	} 
	public int read() {
            if (snumChars == -1)
	 	throw new InputMismatchException();
            if (curChar >= snumChars) {
		curChar = 0;
                try {
                    snumChars = stream.read(buf);
		} 
                catch (IOException e) {
                    throw new InputMismatchException();
           	}
		if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
	}
        public int ni() {
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
		res *= 10;
		res += c - '0';
		c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
	} 
	public long nl() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
	} 
	public int[] nia(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
		a[i] = ni();
            }
            return a;
	} 
	public String rs() {
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
	public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
		c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        } 
	public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
	} 
    }
    static PrintWriter w = new PrintWriter(System.out);
    static ArrayList<Integer> arr[];
    static boolean v[];
    static int a[];
    static TreeSet<Integer> pos,val;
    
    public static void main(String[] args) throws IOException {   
        InputReader sc=new InputReader(System.in);
        int n=sc.ni();
        int m=sc.ni();
        pos=new TreeSet<Integer>();
        val=new TreeSet<Integer>();
        v=new boolean[n+1];
        arr=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            arr[i]=new ArrayList<Integer>();
        }
        a=new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=sc.ni();
        }
        for(int i=0;i<m;i++){
            int u=sc.ni();
            int v=sc.ni();
            arr[u].add(v);
            arr[v].add(u);
        }
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=1;i<=n;i++){
            if(!v[i]){
                pos.clear();
                val.clear();
                q.add(i);
                while(!q.isEmpty()){
                    int x=q.poll();
                    if(!v[x]){
                        v[x]=true;
                        pos.add(x);
                        val.add(a[x]);
                        Iterator itr=arr[x].iterator();
                        while(itr.hasNext()){
                            q.add((int)itr.next());
                        }
                    }
                }
                Iterator i1=pos.iterator();
                Iterator i2=val.descendingIterator();
                while(i1.hasNext()&&i2.hasNext()){
                    a[(int)i1.next()]=(int)i2.next();
                }
            }
            
        }
        for(int i=1;i<=n;i++){
            w.print(a[i]+" ");
        }
        w.println();
        w.close();
    }
}



