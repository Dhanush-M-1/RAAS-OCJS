import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class temp
{	
	void solve()
	{
		FastReader sc =new FastReader();
		int n = sc.nextInt();
		int a[] = new int[n+2];
		
		for(int i=1;i<=n;i++)
			a[i] = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		
		a[0] = 1;
		a[n+1] = 1000000;
		
		for(int i=1;i<=n;i++)
		{
			int time = Math.min(Math.max(a[i] - 1,1000000 - a[i+1]) , Math.max(1000000 - a[i] , a[i-1] - 1));
			min = Math.min(min,time);
		}
		
		System.out.println(min);
	}

    public static void main(String[] args)
    {
        new temp().solve();
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