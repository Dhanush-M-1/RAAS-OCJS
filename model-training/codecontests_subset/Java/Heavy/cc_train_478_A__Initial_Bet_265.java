import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
		
	public static void main(String[] args) throws IOException {
		new Main().solve();
	}
	
	PrintWriter out;
	int n;
	int m;
	boolean[] use;
	int mod = 1000000007;
	int rv = 0;
	ArrayList<Integer>[] g;
	int[] res;
	int p, q;
	HashMap<Long, Long> map = new HashMap();
	void solve() throws IOException{
		Reader in = new Reader("output.txt");
		out = new PrintWriter( new BufferedWriter(new OutputStreamWriter(System.out)) );
		//out = new PrintWriter(new FileWriter(new File("output.txt"))); 
		
		
		
		int k = 0;
		
		for (int i = 0; i < 5; i++) {
			k += in.nextInt();
		}
		
		if (k%5 == 0 && k/5 != 0) {
			System.out.println(k/5);
		}
		else
			System.out.println(-1);
		
		out.flush();
		out.close();
		
	}
	
	long pow(int x, int m) {
		if (m == 0)
			return 1;
		return x*pow(x, m-1);
	}

	
class Pair implements Comparable<Pair> {
		
		int a;
		int b;
		
		Pair (int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair p) {
			if (a < p.a)
				return -1;
			if (a > p.a)
				return 1;
			
			if (b < p.b)
				return -1;
			
			if (b > p.b)
				return 1;
			
			return 0;
		}
		
	}

	class Item implements Comparable<Item> {

		int a;
		int b;
		long u;
		
		Item(int v, int l, long z) {
			this.a = v;
			this.b = l;
			this.u = z;
		}
		
		@Override
		public int compareTo(Item item) {
			
			if (u > item.u)
				return 1;
			else
			if (u < item.u)
				return -1;
			else {
				return 0;
			}
						
		}
		
	}
	
	class Reader {
	    
	    StringTokenizer token;
	    BufferedReader in;
	    
	    public Reader(String file) throws IOException {
	        //in = new BufferedReader( new FileReader( file ) );
	        in = new BufferedReader( new InputStreamReader( System.in ) );
	    }
	    
	    public byte nextByte() throws IOException {
	        return Byte.parseByte(Next());
	    }
	    
	    public int nextInt() throws IOException {
	        return Integer.parseInt(Next());
	    }
	    
	    public long nextLong() throws IOException {
	        return Long.parseLong(Next());
	    }
	    
	    public String nextString() throws IOException {
	        return in.readLine();
	    }
	    
	    public String Next() throws IOException {
	        while (token == null || !token.hasMoreTokens()) {
	            token = new StringTokenizer(in.readLine());
	        }
	        return token.nextToken();
	    }

	    
	}
	
}
	
	

	
