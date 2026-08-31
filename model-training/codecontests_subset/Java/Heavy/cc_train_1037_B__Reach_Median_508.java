import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class temp {
	
    void solve() throws IOException
    {
        FastReader sc=new FastReader();
        int n = sc.nextInt();
        long s = sc.nextLong();
        
        long a[] = new long[n];
        
        for(int i=0;i<n;i++)
        	a[i] = sc.nextLong();
        
        Arrays.sort(a);
        
        if(a[n/2]==s)
        	System.out.println("0");
        else if(a[n/2] < s)
        {
        	long ans = (long)(s - a[n/2]);
        	
        	for(int i=n/2+1;i<n;i++)
        	{
        		if(a[i] >= s)
        			break;
        		ans+=(long)(s-a[i]);
        	}
        	
        	System.out.println(ans);
        }
        else
        {
        	long ans = (long)(a[n/2]-s);
        	
        	for(int i=n/2-1;i>=0;i--)
        	{
        		if(a[i] <= s)
        			break;
        		ans+=(long)(a[i]-s);
        	}
        	
        	System.out.println(ans);
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        new temp().solve();
 
    }
   
    class FastReader
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