
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class CR63A {
	
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
		
		FastReader sc = new FastReader();
	    OutputStream outputstream = System.out;
	    PrintWriter out = new PrintWriter(outputstream);
	    
	    int n = sc.nextInt();
	    String str = sc.next();
	    //char min = 'z';
	    /*for(int i = 0; i < str.length(); i++) {
	    	if(str.charAt(i)<min) min = str.charAt(i);
	    }*/
	    boolean flag = false;
	    for(int i = 0; i < n-1; i++) {
	    	if(str.charAt(i)>str.charAt(i+1)) {
	    		flag = true;
	    		out.println("YES");
	    		out.println((i+1) + " " + (i+2));
	    		break;
	    	}
	    }
		if(flag==false) out.println("NO");
		out.close();
	}

}