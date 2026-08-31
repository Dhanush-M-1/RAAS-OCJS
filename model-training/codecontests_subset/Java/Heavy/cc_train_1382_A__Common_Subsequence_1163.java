import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.geom.*;

import static java.lang.Math.*;

public class Solution implements Runnable {
    
    
     
    
    public void solve() throws Exception {
    	int t=sc.nextInt();
    	while(t-->0)
    	{
    		int n=sc.nextInt();
    		int m=sc.nextInt();
    		int arr[]=new int[n];
    		int brr[]=new int[m];
    		int crr[]=new int[1001];
    		for(int i=0;i<n;i++)
    		{
    			arr[i]=sc.nextInt();
    			if(crr[arr[i]]==0)
    			crr[arr[i]]++;
    		}
    		for(int i=0;i<m;i++)
    		{
    			brr[i]=sc.nextInt();
    			if(crr[brr[i]]==1)
    			crr[brr[i]]++;
    		}
    		boolean flag=false;
    		for(int i=1;i<=1000;i++)
    		{
    			if(crr[i]>1)
    			{
    				flag=true;
    				System.out.println("YES");
    				System.out.println(1+" "+i);
    				break;
    			}
    		}
    		if(!flag)
    			System.out.println("NO");
    			
    		
    	
    	}
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