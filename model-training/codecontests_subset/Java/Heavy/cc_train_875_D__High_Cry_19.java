import java.util.*;
import java.io.*;
import java.math.*;
/*

7
4 4 4 2 4 4 4

5
4 4 2 4 4

 */
public class d {


    public static void main(String[] args) throws IOException {
    	JoltyScanner in = new JoltyScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        	arr[i] = in.nextInt();

        int[] bigLeft = new int[n];
        int[] bigRight = new int[n];
        int[] difLeft = new int[n];
        int[] difRight = new int[n];
        
        int[] locs = new int[30];
        Arrays.fill(locs, -1);
        //difLeft[0] = -1;
        for (int i = 0; i < n; i++) {
        	difLeft[i] = -1;
        	for (int j = 0; j < 30; j++) {
        		int bit = 1 << j;
        		if ((bit & arr[i]) != 0) {
        			locs[j] = i;
        		} else {
        			difLeft[i] = Math.max(locs[j], difLeft[i]);
        		}
        	}
        }
        
        Arrays.fill(locs, n);
        //difLeft[0] = -1;
        for (int i = n - 1; i >= 0; i--) {
        	difRight[i] = n;
        	for (int j = 0; j < 30; j++) {
        		int bit = 1 << j;
        		if ((bit & arr[i]) != 0) {
        			locs[j] = i;
        		} else {
        			difRight[i] = Math.min(locs[j], difRight[i]);
        		}
        	}
        }

        Pair[] ps = new Pair[n];
        for (int i = 0; i < n; i++) {
        	ps[i] = new Pair(i, arr[i]);
        }
        Arrays.sort(ps);
        {
        	TreeSet<Integer> set = new TreeSet<>();
        	for (Pair p : ps) {
        		Integer r = set.higher(p.idx);
        		Integer l = set.lower(p.idx);
        		bigLeft[p.idx] = l == null ? -1 : l.intValue();
        		bigRight[p.idx] = r == null ? n : r.intValue();
        		set.add(p.idx);
        	}
        }
        //out.println(Arrays.toString(bigLeft));
        //out.println(Arrays.toString(bigRight));
        long ans = 0;
        for (int i = 0; i < n; i++) {
        	int bl = bigLeft[i];
        	int br = bigRight[i];
        	int dl = difLeft[i];
        	int dr = difRight[i];
        	if (dl < bl && dl != -1)
        		dl = bl;
        	if (dl == -1 && dr == n)
        		continue;
        	if (dl == -1) {
        		long left = i - bl;
        		long right = br - dr;
        		ans += left * right;
        	} else if (dr == n) {
        		long right = br - i;
        		long left = dl - bl;
        		ans += left * right;
        	} else {
        		{
        			long left = i - bl;
            		long right = br - dr;
            		ans += left * right;
        		}
        		{
        			long right = br - i;
            		long left = dl - bl;
            		ans += left * right;
        		}
        		{
        			long left = dl - bl;
        			long right = br - dr;
        			ans -= left * right;
        		}
        	}
        	//System.out.printf("%d:  %d, %d   %d, %d     %d\n", i, bl, br, dl, dr, add);
        }
        
        out.println(ans);
        out.close();
    }

    static class Pair implements Comparable<Pair> {
    	int idx, val;
    	public Pair(int idxx, int vall) {
    		idx = idxx; val = vall;
    	}
    	
    	public int compareTo(Pair p) {
    		if (val == p.val)
    			return Integer.compare(idx, p.idx);
    		return Integer.compare(p.val, val);
    	}
    	
    }

    static Random rand = new Random();
    static void sort(int[] a) {
        lsbRadixSort(a, true);
    }
    static void sort(long[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            long tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static void sort(double[] a) {
        int n = a.length;
        for (int i = a.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            double tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
    static void lsbRadixSort(int[] a, boolean signed) {
        int s = 0, n = a.length;
        int[] p = new int[257], b = new int[n];
        int sb = 1 << 31;
        if(signed) for(int i=0;i<n;i++)  a[i] ^= sb;
        while (s < 32) {
            Arrays.fill(p, 0);
            for (int i = 0; i < n; i++)
                p[((a[i] >>> s) & 255)+1]++;
            for(int i=2;i<256;i++)
                p[i] += p[i-1];
            for (int i = 0; i < n; i++)
                b[p[(a[i] >>> s) & 255]++] = a[i];
            int[] tmp = b;  b = a;  a = tmp;
            s += 8;
        }
        if(signed) for(int i=0;i<n;i++)  a[i] ^= sb;
    }
    static long gcd(long a, long b) { return b == 0 ? a : gcd(b, a % b); }
    static long lcm(long a, long b) { return a / gcd(a, b) * b; }
    static long[] eEuclid(long a, long b) {
        if (b == 0) return new long[] { a, 1, 0 };
        long[] ans = eEuclid(b, a % b);
        long temp = ans[1] - ans[2] * (a / b);
        ans[1] = ans[2];  ans[2] = temp;
        return ans;
    }
    static long modInverse(long a, long m) {
        return ((eEuclid(a, m)[1] % m) + m) % m;
    }
    static class IntList {
        static int[] EMPTY = {};
        int[] a = EMPTY;
        int n = 0;
        void add(int v) {
            if (n >= a.length)
                a = Arrays.copyOf(a, (n << 2) + 8);
            a[n++] = v;
        }
        int get(int idx) {
            return a[idx];
        }
        int size() {
            return n;
        }
    }
    static class DisjointSet {
        int[] s;
	
        public DisjointSet(int n) {
            Arrays.fill(s = new int[n], -1);
        }	
        public int find(int i) {
            return s[i] < 0 ? i : (s[i] = find(s[i]));
        }	
        public boolean union(int a, int b) {
            if ((a = find(a)) == (b = find(b))) return false;
            if(s[a] == s[b]) s[a]--;
            if(s[a] <= s[b]) s[b] = a; else s[a] = b;
            return true;
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        public FastScanner(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }
        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        public int[] nextOffsetIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt() - 1;
            return arr;
        }
        public int[] nextIntArray(int n) throws IOException {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextInt();
            return arr;
        }
        public int[][] nextIntArray(int n, int m) throws IOException {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
        public long[] nextLongArray(int n) throws IOException {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }
        public long[][] nextLongArray(int n, int m) throws IOException {
            long[][] arr = new long[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextLong();
            return arr;
        }
        public double[] nextDoubleArray(int n) throws IOException {
            double[] arr = new double[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextDouble();
            return arr;
        }
        public double[][] nextDoubleArray(int n, int m) throws IOException {
            double[][] arr = new double[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextDouble();
            return arr;
        }
        public char[][] nextCharArray(int n, int m) throws IOException {
            char[][] arr = new char[n][];
            for (int i = 0; i < n; i++)
                arr[i] = next().toCharArray();
            return arr;
        }
    }
    
  //@
    static class JoltyScanner 
    {
    	public static final int BUFFER_SIZE = 1 << 16;
    	public static final char NULL_CHAR = (char) -1;
    	byte[] buffer = new byte[BUFFER_SIZE];
    	boolean EOF_FLAG = false;
    	int bufferIdx = 0, size = 0;
    	char c = NULL_CHAR;
    	BufferedInputStream in;
    	public JoltyScanner(InputStream in) 
    	{
    		this.in = new BufferedInputStream(in, BUFFER_SIZE);
    	}
    	public int nextInt() 
    	{
    		long x = nextLong();
    		if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) 
    		{
    			throw new ArithmeticException("Scanned value overflows integer");
    		}
    		return (int) x;
    	}
    	public long nextLong() 
    	{
    		boolean negative = false;
    		if (c == NULL_CHAR) 
    		{
    			c = nextChar();
    		}
    		for (; !EOF_FLAG && (c < '0' || c > '9'); c = nextChar()) 
    		{
    			if (c == '-') 
    			{
    				negative = true;
    			}				
    		}
    		checkEOF();
    		long res = 0;
    		for (; c >= '0' && c <= '9'; c = nextChar()) 
    		{
    			res = (res << 3) + (res << 1) + c - '0';
    		}
    		return negative ? -res : res;
    	}
    	public char nextChar() 
    	{
    		if (EOF_FLAG) 
    		{
    			return NULL_CHAR;
    		}
    		while (bufferIdx == size) 
    		{
    			try 
    			{
    				size = in.read(buffer);
    				if (size == -1) 
    				{
    					throw new Exception();
    				}
    			} 
    			catch (Exception e) 
    			{
    				EOF_FLAG = true;
    				return NULL_CHAR;
    			}
    			if (size == -1) 
    			{
    				size = BUFFER_SIZE;
    			}
    			bufferIdx = 0;
    		}
    		return (char) buffer[bufferIdx++];
    	}
    	public void checkEOF() 
    	{
    		if (EOF_FLAG) 
    		{
    			throw new EndOfFileException();
    		}
    	}
    	public class EndOfFileException extends RuntimeException 
    	{
    	}
    }
}