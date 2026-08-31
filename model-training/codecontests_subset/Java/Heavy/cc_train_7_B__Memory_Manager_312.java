import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main
{
	private InputStream stream;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
	private SpaceCharFilter filter;
	private PrintWriter pw;
	private long mod = 1000000000 + 7;
	
	private StringBuilder ans_sb;
	private void soln()
	{	
		int m = nextInt();
		int t = nextInt();
		boolean[] arr = new boolean[t];
		int k = 1;
		HashMap<Integer,Integer> set = new HashMap<>();
		HashMap<Integer, Integer> set1 = new HashMap<>();
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for(int i=0;i<m;i++) {
			String[] s = nextLine().split(" ");
			if(s[0].charAt(0)=='a') {
				int tot = Integer.parseInt(s[1]);
				int i1 = 0;
				boolean f = false;
				for(i1=0;i1<=t-tot;i1++) {
					int j1 = 0;
					for(j1 = 0; j1<tot;j1++) {
						if(arr[j1+i1])
							break;
					}
					if(j1==tot) {
						f = true;
						break;
					}
				}
				if(!f || tot <= 0) {
					pw.println("NULL");
				}else {
					pw.println(k++);
					set.put(k-1,i1);
					set1.put(k-1, tot);
					map.put(i1, k-1);
					for(int j1=0;j1<tot;j1++)
						arr[i1+j1] = true;
				}
			}else if(s[0].charAt(0)=='e') {
				int num = Integer.parseInt(s[1]);
				if(set.containsKey(num)) {
					int i1 = set.get(num);
					int tot = set1.get(num);
					set.remove(num);
					set1.remove(num);
					map.remove(i1);
					for(int j1=0;j1<tot;j1++)
						arr[i1+j1] = false;
				}else {
					pw.println("ILLEGAL_ERASE_ARGUMENT");
				}
			}else {
				Arrays.fill(arr,false);
				int st = 0;
				for(int i1:map.keySet()) {
					int key = map.get(i1);
					int tot = set1.get(key);
					set.put(key, st);
					st += tot;
				}
				for(int j1=0;j1<st;j1++)
					arr[j1] = true;
				map.clear();
				for(int key:set.keySet()) {
					int sta = set.get(key);
					map.put(sta, key);
				}
			}
		//	debug(arr);
			//debug(set);
			//debug(set1);
			//debug(map);
			//System.out.println();
		}
	}
	private class Node implements Comparable<Node>{
		int node;
		int dist;

		@Override
		public int compareTo(Node arg0)
		{
			if(this.dist != arg0.dist)
				return (int) (this.dist - arg0.dist);
			return this.node - arg0.node;
		}
		public boolean equals(Object o){
			if(o instanceof Node){
				Node c = (Node)o;
				return this.node == c.node && this.dist == c.dist;
			}
			return false;
		}
		public String toString() {
			return this.node+", "+this.dist;
		}
	}
	
	private void debug(Object... o) {
		System.out.println(Arrays.deepToString(o));
	}
	
	private long pow(long a, long b, long c)
	{
		if (b == 0)
			return 1;
		long p = pow(a, b / 2, c);
		p = (p * p) % c;
		return (b % 2 == 0) ? p : (a * p) % c;
	}

	private long gcd(long n, long l)
	{
		if (l == 0)
			return n;
		return gcd(l, n % l);
	}
	public static void main(String[] args) throws Exception
	{
		new Thread(null, new Runnable()
		{
			@Override
			public void run()
			{
				new Main().solve();
			}
		}, "1", 1 << 26).start();
	}
	public StringBuilder solve(){
		InputReader(System.in);
		/*try { 
			InputReader(new FileInputStream("C:\\Users\\hardik\\Desktop\\in.txt"));
		} catch(FileNotFoundException e) {}
		*/
		pw = new PrintWriter(System.out);
		ans_sb = new StringBuilder();
		soln();
		
		pw.close();
		//System.out.println(ans_sb);
		return ans_sb;
	}
	public void InputReader(InputStream stream1)
	{
		stream = stream1;
	}

	private boolean isWhitespace(int c)
	{
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}

	private boolean isEndOfLine(int c)
	{
		return c == '\n' || c == '\r' || c == -1;
	}

	private int read()
	{
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars)
		{
			curChar = 0;
			try
			{
				numChars = stream.read(buf);
			} catch (IOException e)
			{
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}

	private int nextInt()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-')
		{
			sgn = -1;
			c = read();
		}
		int res = 0;
		do
		{
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private long nextLong()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-')
		{
			sgn = -1;
			c = read();
		}
		long res = 0;
		do
		{
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}

	private String nextToken()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do
		{
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}

	private String nextLine()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do
		{
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}

	private int[] nextIntArray(int n)
	{
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = nextInt();
		}
		return arr;
	}

	private long[] nextLongArray(int n)
	{
		long[] arr = new long[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = nextLong();
		}
		return arr;
	}

	private void pArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private void pArray(long[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		return;
	}

	private boolean isSpaceChar(int c)
	{
		if (filter != null)
			return filter.isSpaceChar(c);
		return isWhitespace(c);
	}

	private char nextChar()
	{
		int c = read();
		while (isSpaceChar(c))
			c = read();
		char c1 = (char) c;
		while (!isSpaceChar(c))
			c = read();
		return c1;
	}

	private interface SpaceCharFilter
	{
		public boolean isSpaceChar(int ch);
	}
}