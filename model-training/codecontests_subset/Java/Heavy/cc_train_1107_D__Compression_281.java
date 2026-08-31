import java.io.*;
import java.util.*;

public class D {

	static StringBuilder st = new StringBuilder();
	
	static boolean can(int x , int n , int [][] sum2D)
	{
	    for(int i = 0 ; i < n ; i += x )
	        for(int j = 0 ; j < n ; j +=x )
	        {
	    	    int k = i + x - 1 , l = j + x - 1;

	    	    int curr = sum2D[k][l];

	    	    if (i > 0) curr -= sum2D[i - 1][l];
	    	    if (j > 0) curr -= sum2D[k][j - 1];
	    	    if (i > 0 && j > 0) curr += sum2D[i - 1][j - 1];

	    	
	            if(0 < curr && curr < x * x) return  false ;
	        }

	    return  true ;

	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		
		int n = sc.nextInt();
		
		char [][] mat = new char [n][n] ; 
		int [][] sum2D = new int [n][n] ; 
		
		for(int i = 0 ; i < n ;i++)
		{
			char [] hex = sc.next().toCharArray();
			
			st = new StringBuilder() ; 
			
			for(char x : hex)
			{
				String curr =  Integer.toBinaryString(Integer.parseInt(x+"", 16));
				
				while(curr.length() < 4) curr = "0" + curr ; 
				
				st.append(curr);
				
			}
			
			mat[i] = st.toString().toCharArray() ; 
		
		}
		
		for(int i = 0 ; i < n ;i++)
			for(int j = 0 ;j < n ; j++)
			{
				sum2D[i][j] = mat[i][j] - '0';

	            if (i > 0) sum2D[i][j] += sum2D[i - 1][j];
	            if (j > 0) sum2D[i][j] += sum2D[i][j - 1];
	            if (i > 0 && j > 0) sum2D[i][j] -= sum2D[i - 1][j - 1];
	  
			}
		
		
		int ans = 1 ; 
		
		for(int i = n ; i >= 1 ; i--)
			if(n % i == 0 && can(i, n, sum2D))
			{
				ans = i ; 
				break ; 
			}
		
		out.println(ans);		
		
		out.flush();
		out.close();

	}

	static class Scanner {
		BufferedReader br;
		StringTokenizer st;

		Scanner(InputStream in) {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws Exception {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		int nextInt() throws Exception {
			return Integer.parseInt(next());
		}

		long nextLong() throws Exception {
			return Long.parseLong(next());
		}

		double nextDouble() throws Exception {
			return Double.parseDouble(next());
		}

	}

	static void shuffle(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			int tmp = a[i];
			a[i] = a[r];
			a[r] = tmp;
		}
	}

}