import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {
	//Woodcutters
	
	public static void main(String[] args)
	{
		FastReader in = new FastReader();
		int n = in.nextInt();
		int[][] t = new int[n][2];
		for(int i = 0; i < n; i++)
		{
			t[i][0] = in.nextInt();
			t[i][1] = in.nextInt();
		}
		int[][] dp = new int[2][3];
		for(int i = 0; i < n; i++)
		{
			if(i == 0 || t[i-1][0] < t[i][0] - t[i][1])
			{
				dp[1][0] = Math.max(dp[0][0], dp[0][1]);
				if(i == 0 || t[i-1][0] + t[i-1][1] < t[i][0] - t[i][1])
				{
					dp[1][0] = Math.max(dp[1][0], dp[0][2]);
				}
				dp[1][0] += 1;
			}
			dp[1][1] = Math.max(Math.max(dp[1][0], dp[1][1]),dp[1][2]);
			if(i == n-1 || t[i][0] + t[i][1] < t[i+1][0])
			{
				dp[1][2] = Math.max(Math.max(dp[0][0], dp[0][1]),dp[0][2]);
				dp[1][2] += 1;
			}
			dp[0][0] = dp[1][0];
			dp[0][1] = dp[1][1];
			dp[0][2] = dp[1][2];
		}
		System.out.println(Math.max(Math.max(dp[0][0], dp[0][1]),dp[0][2]));
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
