import java.io.*;
import java.util.*;
import java.math.*;

public class Competitive_1 {
		
	public static final int left=0, right=1;
	
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int n=in.nextInt();
		
		int point[] = new int[n];
		int height[] = new int[n];
		int DP[][] = new int[n+1][2];
		
		for(int i=0; i<n; i++){
			point[i] = in.nextInt();
			height[i] = in.nextInt();
		}
		
		DP[0][left] = 1;
		if(n>1)
			DP[0][right] = point[0]+height[0] <= point[1] ? 1 : 0;
		else
			DP[0][right] = 1;
		
		for(int i=1; i<n; i++){
			if(point[i]-height[i] > point[i-1]){
				DP[i][left] = Math.max( DP[i-1][left]+1 , point[i]-height[i]>point[i-1]+height[i-1] ? DP[i-1][right]+1 : DP[i-1][right] );
			}else{
				DP[i][left] = Math.max( DP[i-1][left] , DP[i-1][right] );
			}
			
			if(i!=n-1 && point[i]+height[i] < point[i+1]){
				DP[i][right] = Math.max( DP[i-1][left]+1 , DP[i-1][right]+1 );
			}else if(i==n-1){
				DP[i][right] = Math.max( DP[i-1][left]+1 , DP[i-1][right]+1 );
			}else{
				DP[i][right] = Math.max( DP[i-1][right] , DP[i-1][left] );
			}
		}
		
		System.out.println( Math.max(DP[n-1][left], DP[n-1][right]) );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
}