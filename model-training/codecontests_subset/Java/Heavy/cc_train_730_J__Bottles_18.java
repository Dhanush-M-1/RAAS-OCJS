import java.util.*;
/*

 */
public class J {
	
	public static void main(String[] args) {
		
		Scanner qwe= new Scanner(System.in);
		
		int N = qwe.nextInt();
		
		int[] h = new int[N];
		for (int i = 0; i < h.length; i++) {
			h[i] = qwe.nextInt();
		}
		int[] c = new int[N];
		for (int i = 0; i < c.length; i++) {
			c[i] = qwe.nextInt();
		}
		
		int[][][] dp = new int[2][N+1][10002];
		
		int toadd = 5000;
		
		int oo = 987654321;
		
		//base case
		
		for(int x = 0; x < dp[0][0].length; x++){
			dp[1][0][x] = (x >= toadd) ? 0 : oo;
			for(int k = 1; k <= N; k++) dp[1][k][x] = oo;
		}
		
		for(int i = 0; i < N; i++){
			int prev = 1 - (i & 1);
			
			for(int k = 0; k <= N; k++){
				for(int x = 0; x < dp[0][0].length; x++){
					dp[i&1][k][x] = oo;
					
					if(k > 0){
						int takex = Math.min(x + c[i]-h[i],dp[0][0].length-1);
						int takek = k-1;
						
						dp[i&1][k][x] = dp[prev][takek][takex];
						
					}
					
					int dontx = x-h[i];
					if(dontx >= 0){
						dp[i&1][k][x] = Math.min(dp[i&1][k][x], dp[prev][k][dontx]+h[i]);
					}
					
				}
			}
			
			
		}
		
		int ansk = -1;
		int anscost = -1;
		
		for(int k = N; k >= 1; k--){
			int bestans = oo;
				bestans = Math.min(bestans, dp[(N-1)&1][k][toadd]);
			if(bestans < oo){
				ansk = k;
				anscost = bestans;
			}
		}
		
		System.out.println(ansk + " " + anscost);
		
		qwe.close();
	}

}
