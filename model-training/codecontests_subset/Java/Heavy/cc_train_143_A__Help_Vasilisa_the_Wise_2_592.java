import java.util.*;
import java.lang.*;
import java.io.*;

	public class FastIO{
			
		BufferedReader br;
		StringTokenizer st;
		
		public FastIO(){ // constructor
			
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next(){
			
			while (st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}
				
				catch (IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt(){
			
			return Integer.parseInt(next());
		}
		
		long nextLong(){
			
			return Long.parseLong(next());
		}
		
		double nextDouble(){
			return Double.parseDouble(next());
		}

		String nextLine(){
			
			String str = "";
			try{
				
				str = br.readLine();
			}
			catch (IOException e){
				
				e.printStackTrace();
			}
			return str;
		}
		
		// int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		// T.C. -> O(log N) N = min(a, b) 
		static int gcd(int a, int b) {
			
			if(b == 0) {
				return a;
			}
			
			return gcd(b, a % b);
		}
		
		static void sort(int[] arr){
			
	        int n = arr.length;
	        
	        Random rnd = new Random();
	        
	        for(int i=0; i<n; ++i){
	            int tmp = arr[i];
	            int randomPos = i + rnd.nextInt(n-i);
	            arr[i] = arr[randomPos];
	            arr[randomPos] = tmp;
	        }
	        
	        Arrays.sort(arr);
	   }
		
	public static void main(String[] args) throws IOException {
		
		FastIO in = new FastIO();
		PrintWriter out = new PrintWriter(System.out);
		
		// int n = in.nextInt(); -> for int
		// double d = in.nextDouble(); -> for double
		// String ch = in.next(); -> for one word
		// String str = in.nextLine(); -> for the entire line
		
		int r1 = in.nextInt();
		int r2 = in.nextInt();
		int c1 = in.nextInt();
		int c2 = in.nextInt();
		int d1 = in.nextInt();
		int d2 = in.nextInt();
		
		for(int a = 1; a <= 9; a++) {
			for(int b = 1; b <= 9; b++) {
				if(b != a) {
					for(int c = 1; c <= 9; c++) {
						if(c != a && c != b) {
							for(int d = 1; d <= 9; d++) {
								if(d != c && d != a && d != b) {
									if(a + b == r1 && c + d == r2 && a + c == c1 && b + d == c2 && a + d == d1 && b + c == d2) {
										System.out.println(a + " " + b);
										System.out.println(c + " " + d);
										return;
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(-1);
		
		out.flush();
		out.close();
	}
}