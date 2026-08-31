import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
public class test
{ 
	static class FastReader 
	{ 
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
				catch (IOException e) 
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
	//static int[][] dp;
	static int solve(long[] arr,long[] h,int i){
		if(i == 0 && arr.length > 1)return 1 + solve(arr,h,i+1);
		else if(i == 0)return 1;
		if(i == arr.length-1)return 1;
		if(arr[i] - h[i] > arr[i-1])return 1 +solve(arr,h,i+1);
		else if(arr[i] + h[i] < arr[i+1]){
				arr[i] += h[i];
				return 1 + solve(arr,h,i+1);	
		}else{
			return solve(arr,h,i+1);	
		}
	}
	public static void main(String[] args) 
	{ 
		FastReader scan =new FastReader(); 
		int n = scan.nextInt();
		long[] arr = new long[n];
		long[] h = new long[n];
		for(int i=0;i<n;i++){
			arr[i] = scan.nextLong();
			h[i] = scan.nextLong();
		}
		// dp = new int[n+1][3];
		System.out.println(solve(arr,h,0));
		
	} 
}
