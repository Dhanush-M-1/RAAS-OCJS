import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

 public class Solution implements Runnable {
	 static Vector<Integer>[] tree;
    public void solve() throws Exception {
    	
//    		int t=sc.nextInt();
//    		while(t-->0)
//    		{
    			int n=sc.nextInt();
    			int arr[][]=new int[n][2];
    			for(int i=0;i<n;i++)
    			{
    				arr[i][0]=sc.nextInt();
    				arr[i][1]=sc.nextInt();
    				
    			}
    			if(n==1)
    			{
    				System.out.println(1);
    				return;
    			}
    			int result=2;
    			for(int i=1;i<n-1;i++)
    			{
    				if(arr[i-1][0]<arr[i][0]-arr[i][1])
    				{
    					result++;
    					
    				}
    				else
    				{
    					if(arr[i+1][0]>arr[i][0]+arr[i][1])
    					{
    						result++;
    						arr[i][0]=arr[i][0]+arr[i][1];
    					}
    				}
    			}
    			
    			System.out.println(result);
    			
//    			
//    		}
    }
    
    
    static Throwable uncaught;

    BufferedReader in;
    FastScanner sc;
    PrintWriter out;

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            solve();
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (Solution.uncaught != null) {
            throw Solution.uncaught;
        }
    }

}

class FastScanner {

    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

}