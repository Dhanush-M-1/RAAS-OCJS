
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Stones {
	
	static FastReader sc = new FastReader();
    static OutputStream outputstream = System.out;
    static PrintWriter out = new PrintWriter(outputstream);

	static class FastReader { 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException  e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	}

	public static void main(String[] args) {
		
	    int t = sc.nextInt();
	    while(t--!=0) {
	    	int a = sc.nextInt();
	    	int b = sc.nextInt();
	    	int c = sc.nextInt();
	    	int ta = a;
	    	int tb = b;
	    	int tc = c;
	    	while(b!=0 && c>=2) {
	    		b--;
	    		c -= 2;
	    	}
	    	while(a!=0 && b>=2) {
	    		a--;
	    		b -= 2;
	    	}
	    	int ans = ta-a+tb-b+tc-c;
	    	out.println(ans);
	    }
	    out.close();
	    
	}

}
