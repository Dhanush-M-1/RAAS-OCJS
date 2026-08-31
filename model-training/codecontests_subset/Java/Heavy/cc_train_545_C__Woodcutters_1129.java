

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main
{
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String n() 
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
  
        int ni() 
        { 
            return Integer.parseInt(n()); 
        } 
  
        long nl() 
        { 
            return Long.parseLong(n()); 
        } 
  
        double nd() 
        { 
            return Double.parseDouble(n()); 
        } 
  
        String nline() 
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

   
     public static long[] randomize(long arr[])
    {
        Random rand = new Random();
for (int i = 0; i < arr.length; ++i) {
   int index = rand.nextInt(arr.length - i);
   long tmp = arr[arr.length - 1 - i];
   arr[arr.length - 1 - i] = arr[index];
   arr[index] = tmp;
}

return arr;
    } 

    static long mod = 1000000007;

  
    public static void main (String[] args) throws java.lang.Exception
    {
        FastReader sc = new FastReader();
        StringBuilder fo = new StringBuilder();

        int n = sc.ni();

        long points[] = new long[n];
        long h[] = new long[n];
        
        for(int i=0;i<n;i++)
        {
            points[i] = sc.nl();
            h[i] = sc.nl();
        }

        long ans =1 ;
        if(n>1)
            ans++;

        long right_most = points[0];

        for(int i=1;i<n-1;i++)
        {
            boolean left = false;
            boolean right = false;
            if(points[i]-h[i]>right_most)
                left = true;
            if(h[i]<points[i+1]-points[i])
                right = true;

            if(left==true)
            {
                ans++;
                right_most = points[i];
            }
            else if(right==true)
            {
                ans++;
                right_most = points[i]+h[i];
            }
            else
                right_most = points[i];

        }

        System.out.println(ans);
        
    }
    
    
    
    
}
