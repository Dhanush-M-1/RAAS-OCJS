import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class CF1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FastReader s = new FastReader();
		int n = s.nextInt();
		int f = s.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = s.nextInt();
		Arrays.sort(arr);
		int m = n/2;
		if(arr[m]==f)
			System.out.println("0");
		else
		{
			int i;
			long ans = Math.abs(arr[m]-f);
			i = m-1;
			while(i>=0 && arr[i]>f)
			{
				ans += arr[i]-f;
				i--;
			}
			i = m+1;
			while(i<n && arr[i]<f)
			{
				ans += f-arr[i];
				i++;
			}
			System.out.println(ans);
		}
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
