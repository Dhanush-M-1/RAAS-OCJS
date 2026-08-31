import java.util.*;
import java.io.*;
public class Main {
 
	static ArrayList<Integer> adj[];
	static char color[];
	static boolean b[],visited[],possible;
	static Map<Integer,HashSet<Integer>> s;
	static int totalnodes,colored;
	static int count[];
	static long sum[];
	static double ans=0;
	static long[] as=new long[10001];
	public static void main(String[] args) throws IOException {
		
		
		in=new InputReader(System.in);
		w=new PrintWriter(System.out);
    long ax=in.nextLong(),ay=in.nextLong(),bx=in.nextLong(),by=in.nextLong(),cx=in.nextLong(),cy=in.nextLong();
    long da=(bx-ax)*(bx-ax)+(by-ay)*(by-ay);
    long db=(cx-bx)*(cx-bx)+(cy-by)*(cy-by);
    if(Math.abs(ax*(by-cy)+bx*(cy-ay)+cx*(ay-by))>0)
    {
    if(da==db)
    	w.print("Yes");
    else
    	w.print("No");
    }
    else
    	w.print("No");
       w.close();			
		}

	public static void dfs(int v,boolean visited[], ArrayList<Integer>[] g )
	    {
		   
	        visited[v] = true;
	        Iterator<Integer> i = g[v].listIterator();
	        while (i.hasNext())
	        {
	            int n = i.next();
	            if (!visited[n])
	            {
	            	ans++;
	            	dfs(n, visited,g);
	            }
	        }
	    }

	public static String[] subString(String s, int n) 
	{
	    String[] st =new String[(n*n+n)/2];
	    for(int i=0;i<st.length;i++)
	    	st[i]="";
	    int l=0;
	    for (int len = 1; len <= n; len++) 
	    {    
	        // Pick ending point
	        for (int i = 0; i <= n - len; i++) 
	        {
	            //  Print characters from current
	            // starting point to current ending
	            // point.  
	            int j = i + len - 1;            
	            for (int k = i; k <= j; k++) 
	                st[l]+=s.charAt(k);
	      //w.println(st[l]);
	            l++;
	            //cout << endl;
	        }
	    }
	    return st;
	}
	  public static long factorial(long n)
	    {
	        long res = 1, i;
	        for (i=2; i<=n; i++)
	            res *= i;
	        return res;
	    }
	
   
	public static int factors(int n,int start){
		int count = 0;
		int i;
		for(i=1;i*i<n;i++)
			if(n%i == 0){
				if(i>start)	count++;
				if(n/i > start)	count++;
			}
		if(i*i == n && i>start)	count++;
		return count;
	}


 	public static int isPrime(int n){
	    int i;

	    if (n==2)
	        return 1;

	    if (n%2==0)
	        return 0;

	    for (i=3;i<=Math.sqrt(n);i+=2)
	        if (n%i==0)
	            return 0;

	    return 1;
	}

	
	static InputReader in;
	static PrintWriter w;
	public static void seive(long n){
		b = new boolean[(int) (n+1)];
	Arrays.fill(b, true);
		for(int i = 2;i*i<=n;i++){
			if(b[i]){
				sum[i]=count[i];
			//	System.out.println(sum[i]+" wf");
				for(int p = 2*i;p<=n;p+=i){
					b[p] = false;
					sum[i]+=count[p];  
					//System.out.println(sum[i]);
				}
			}
		
		}
	}
	static class Pair implements Comparable<Pair> {
		char c;
		int count;
		public Pair(){
			
		}
		public Pair(char u, int v) {
			this.c = u;
			this.count= v;
			
		}
		public int compareTo(Pair other) {
			
				return 0;
		}
		
		/*public String toString() {
			return "[u=" + u + ", v=" + v + "]";
		}*/
	}
	static class Node2{
		Node2 left = null;
		Node2 right = null;
		Node2 parent = null;
		int data;
	}
	
	//binaryStree
	static class BinarySearchTree{
		Node2 root = null;
		int height = 0;
		int max = 0;
		int cnt = 1;
		ArrayList<Integer> parent = new ArrayList<Integer>();
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		public void insert(int x){
			Node2 n = new Node2();
			n.data = x;
			if(root==null){
				root = n;
			}
			else{
				Node2 temp = root,temp2 = null;
				while(temp!=null){
					temp2 = temp;
					if(x>temp.data) temp = temp.right;
					else temp = temp.left;
				}
				if(x>temp2.data) temp2.right = n;
				else temp2.left = n;
				n.parent = temp2;
				parent.add(temp2.data);
			}
		}
		public Node2 getSomething(int x, int y, Node2 n){
			if(n.data==x || n.data==y) return n;
			else if(n.data>x && n.data<y) return n;
			else if(n.data<x && n.data<y) return getSomething(x,y,n.right);
			else return getSomething(x,y,n.left);
		}
		public Node2 search(int x,Node2 n){
			if(x==n.data){
				max = Math.max(max, n.data);
				return n;
			}
			if(x>n.data){
				max = Math.max(max, n.data);
				return search(x,n.right);
			}
			else{
				max = Math.max(max, n.data);
				return search(x,n.left);
			}
		}
		public int getHeight(Node2 n){
			if(n==null) return 0;
			height = 1+ Math.max(getHeight(n.left), getHeight(n.right));
			return height;
		}
	}
public static void debug(Object... o) {
	System.out.println(Arrays.deepToString(o));
}
 
public static String rev(String s)
{
	StringBuilder sb=new StringBuilder(s);
	sb.reverse();
	return sb.toString();
}
 
static long lcm(long a, long b)
{
    return a * (b / gcd(a, b));
}
 
static long gcd(long a, long b)
{
    while (b > 0)
    {
        long temp = b;
        b = a % b; // % is remainder
        a = temp;
    }
    return a;
}
 
public static long max(long x, long y, long z){
		if(x>=y && x>=z) return x;
		if(y>=x && y>=z) return y;
		return z;
	}
	static int[] sieve(int n,int[] arr)
	{
	for(int i=2;i*i<=n;i++)
	{
		if(arr[i]==0)
		{
			for(int j=i*2;j<=n;j+=i)
				arr[j]=1;
		}
	}
	return arr;
	}
 
 
 
 
static class InputReader {
 
private final InputStream stream;
private final byte[] buf = new byte[8192];
private int curChar, snumChars;
private SpaceCharFilter filter;
 
public InputReader(InputStream stream) {
  this.stream = stream;
}
 
public int snext() {
  if (snumChars == -1)
    throw new InputMismatchException();
  if (curChar >= snumChars) {
    curChar = 0;
    try {
      snumChars = stream.read(buf);
    } catch (IOException e) {
      throw new InputMismatchException();
    }
    if (snumChars <= 0)
      return -1;
  }
  return buf[curChar++];
}
 
public int nextInt() {
  int c = snext();
  while (isSpaceChar(c)) {
    c = snext();
  }
  int sgn = 1;
  if (c == '-') {
    sgn = -1;
    c = snext();
  }
  int res = 0;
  do {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = snext();
  } while (!isSpaceChar(c));
  return res * sgn;
}
 
public long nextLong() {
  int c = snext();
  while (isSpaceChar(c)) {
    c = snext();
  }
  int sgn = 1;
  if (c == '-') {
    sgn = -1;
    c = snext();
  }
  long res = 0;
  do {
    if (c < '0' || c > '9')
      throw new InputMismatchException();
    res *= 10;
    res += c - '0';
    c = snext();
  } while (!isSpaceChar(c));
  return res * sgn;
}
 
public int[] nextIntArray(int n) {
	 return nextIntArray(n, 0);
	    }
	    
public int[] nextIntArray(int n, int off) {
	 int[] arr = new int[n + off];
	   for (int i = 0; i < n; i++) {
	    arr[i + off] = nextInt();
	    }
	    return arr;
	    }
	    
public long[] nextLongArray(int n) {
return nextLongArray(n, 0);
	    }
        
	public long[] nextLongArray(int n, int off) {
	 long[] arr = new long[n + off];
	 for (int i = 0; i < n; i++) {
		  arr[i + off] = nextLong();
		 }
 return arr;
	}
 
 
public String readString() {
  int c = snext();
  while (isSpaceChar(c)) {
    c = snext();
  }
  StringBuilder res = new StringBuilder();
  do {
    res.appendCodePoint(c);
    c = snext();
  } while (!isSpaceChar(c));
  return res.toString();
}
 
public String nextLine() {
  int c = snext();
  while (isSpaceChar(c))
    c = snext();
  StringBuilder res = new StringBuilder();
  do {
    res.appendCodePoint(c);
    c = snext();
  } while (!isEndOfLine(c));
  return res.toString();
}
 
public boolean isSpaceChar(int c) {
  if (filter != null)
    return filter.isSpaceChar(c);
  return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}
 
private boolean isEndOfLine(int c) {
  return c == '\n' || c == '\r' || c == -1;
}
 
public interface SpaceCharFilter {
  public boolean isSpaceChar(int ch);
}
}
	
}