import java.util.*;



import java.io.*;

public class Solution {
static ArrayList<Integer> adj[];
static boolean visited[];
static int a[];
static int distance[];
static long total=0;
static int x0,y0,x1,y1;
static int n;
static TreeMap<Pair,Integer> tm;
	static void solve()
	{
		
		 x0=in.nextInt();
		 y0=in.nextInt();
		 x1=in.nextInt();
		 y1=in.nextInt();
		 n=in.nextInt();
		 tm=new TreeMap<>();
		 int total=0;
		 for(int i=0;i<n;i++)
		 {
			  int r=in.nextInt();
			  int s=in.nextInt();
			  int e=in.nextInt();
			  for(int j=s;j<=e;j++)
			  {if(!tm.containsKey(new Pair(r,j)))
			  {
				  tm.put(new Pair(r,j), total++);
			  }
			  }
		 }
		 adj=new ArrayList[total];
		 for(int i=0;i<total;i++)
			 adj[i]=new ArrayList();
		int sx[]={1, -1, 0, 0, 1, -1, 1, -1};
		int sy[]={0, 0, 1, -1, 1, 1, -1, -1};
		for(Pair p:tm.keySet())
		{
			int c=tm.get(p);
			for(int i=0;i<8;i++)
			{
				Pair distchild=new Pair(p.x+sx[i],p.y+sy[i]);
				Integer child=tm.get(distchild);
				if(child!=null)
					adj[c].add(child);
			}
		}
			  distance=new int[tm.size()];
			  Arrays.fill(distance,Integer.MAX_VALUE);
			  int source=tm.get(new Pair(x0,y0));
			  int destination=tm.get(new Pair(x1,y1));
			 distance[source]=0;
			 Queue<Integer> q=new LinkedList<>();
			 q.add(source);
			 while(!q.isEmpty())
			 {
				 int p=q.poll();
				 for(int i=0;i<adj[p].size();i++)
				 if(distance[p]+1<distance[adj[p].get(i)] )
					{
						distance[adj[p].get(i)]=distance[p]+1;
						q.add(adj[p].get(i));
						
					}
				 
			 }
			 if(distance[destination]==Integer.MAX_VALUE)
				 w.println("-1");
			 else
				 w.println(distance[destination]);
			w.close();
	
	}
	
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(null, new Runnable() {
            public void run() {
                try{
                	 in=new InputReader(System.in);
            		w=new PrintWriter(System.out);
                   solve();
                   w.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }, "1", 1 << 26).start();
    
	}
	
	static InputReader in;
	static PrintWriter w;
	static class Pair implements Comparable<Pair> {
		int x;
		int y;
	
		
		public Pair(int w, int v) {
			this.x = w;
			this.y = v;
		}
		public int compareTo(Pair other) {
			return x == other.x? y - other.y : x - other.x;
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
