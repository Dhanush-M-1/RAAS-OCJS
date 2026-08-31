import java.io.*;
import java.util.*;

public class D {

	static int ar[];
	static int dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++) {
			
			int n = Integer.parseInt(br.readLine());
			
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line);
			
			ar = new int[n];
			dp = new int[n];
			
			for(int j = 0; j < n; j++) {
				
				ar[j] = Integer.parseInt(st.nextToken());
				
			}
			
			build(0, n, 0);
			
			for(int iv : dp) {
				
				System.out.print(iv + " ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	public static void build(int l, int r, int d) {
		
		//System.out.println(l + " " + r);
		
		int mv = -1;
		int mind = -1;
		
		if(r - l <= 1) {
			
			dp[l] = d;
			return;
			
		}
		
		for(int i = l; i < r; i++) {
			
			if(ar[i] > mv) {
				mv = ar[i];
				mind = i;				
			}				
			
		}
		
		//System.out.println("SET: " + mind + " to " + d);
		dp[mind] = d;
		
		if(mind > l) {
			
			build(l, mind, d+1);
			
		}
		
		if(mind < r-1) {
			
			build(mind+1, r, d+1);
			
		}
		
	}

}