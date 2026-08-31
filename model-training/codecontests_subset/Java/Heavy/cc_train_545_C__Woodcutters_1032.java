import java.io.*;
import java.util.*;
public class Solution {

	public void run() throws IOException{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int [] x = new int[n];
		int [] h = new int[n];

		int [] rocc = new int[n];

		int [][] dp = new int[n][3];

		for(int i=0;i<n;i++){
			x[i] = s.nextInt();h[i] = s.nextInt();
			Arrays.fill(dp[i],0);
		}

		Arrays.fill(rocc,Integer.MAX_VALUE);

		if(n==1 || n==2){
			System.out.println(n);
			return;
		}

		int res = 2;
		
		if(x[1] - h[1] > x[0]){
			dp[1][0] = 1;
		}
		if(x[1]+h[1] < x[2]){
			dp[1][1] = 1;
			rocc[1] = x[1]+h[1];
		}

		dp[1][2] = 0;
        //System.out.println(dp[1][1]);

		for(int i=2;i<n-1;i++){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					if(j==0){
						
						
						if(k==1){
							if(rocc[i-1]!=Integer.MAX_VALUE && rocc[i-1]<x[i]-h[i]){
								dp[i][j] = Math.max(dp[i][j],dp[i-1][k]+1);
							}
						}
                        else{
                            if(x[i-1]<x[i]-h[i]){
							     dp[i][j] = Math.max(dp[i][j],dp[i-1][k]+1);
						      }
                        }
						
					}
					else if(j==1 && (x[i]+h[i]<x[i+1])){

						dp[i][j] = Math.max(dp[i][j],dp[i-1][k]+1);
						rocc[i] = x[i]+h[i];
					}
                    else{
                        dp[i][j] = Math.max(dp[i][j],dp[i-1][k]);
                    }
				}
			}
		}

		int max1 = Math.max(dp[n-2][0],dp[n-2][1]);
		max1 = Math.max(max1,dp[n-2][2]);
        
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],0);
        
        Arrays.fill(rocc,Integer.MAX_VALUE);

		if(x[n-2] - h[n-2] > x[n-3]){
			dp[n-2][0] = 1;
			rocc[n-2] = x[n-2]-h[n-2];
		}
		if(x[n-2]+h[n-2] < x[n-1]){
			dp[n-2][1] = 1;
		}
        
       // System.out.println(dp[n-2][0] + " " + dp[n-2][1]);

		for(int i=n-3;i>0;i--){
			for(int j=0;j<3;j++){
				for(int k=0;k<3;k++){
					if(j==1){
						if(k==0){
							if(rocc[i+1]!=Integer.MAX_VALUE && rocc[i+1]>x[i]+h[i]){
								dp[i][j] = Math.max(dp[i][j],dp[i+1][k]+1);
							}
						}
                        else{
                            if(x[i+1]>x[i]+h[i]){
							     dp[i][j] = Math.max(dp[i][j],dp[i+1][k]+1);
							
						     }
                        }
						
					}
					else if(j==0 && (x[i]-h[i]>x[i-1])){

						dp[i][j] = Math.max(dp[i][j],dp[i+1][k]+1);
						rocc[i] = x[i]-h[i];
					}
                    else{
                        	dp[i][j] = Math.max(dp[i][j],dp[i+1][k]);
                    }
				}
			}
		}
        
       // System.out.println(dp[3][0] + " " + dp[3][1] + " " + dp[3][2]);
        //System.out.println(dp[2][0] + " " + dp[2][1] + " " + dp[2][2]);

		int max2 = Math.max(dp[1][0],dp[1][1]);
		max2 = Math.max(max2,dp[1][2]);

		int max = Math.max(max1,max2);

		System.out.println(res+max);
		
		
	}
	public static void main(String [] args) throws IOException{
		new Solution().run();
	}
}
