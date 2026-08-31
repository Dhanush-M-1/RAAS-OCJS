
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

 public class a
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
 
    public static void main(String[] args)
    {
        FastReader sc=new FastReader();
		int n =sc.nextInt();
		int k = sc.nextInt();
		
		int[] a = new int[n];
		int j=0;
		
		for(int i=0;i<n;i++)
		{
			int temp = sc.nextInt();
			
			if(k%temp==0)
			{
				a[j]=k/temp;
				j++;
			}
			
		}

        Arrays.sort(a);
        for(int i=0;i<n;i++)
        {
        	if(a[i]>0)
        	{
        		System.out.println(a[i]);
        		break;
        	}
        }






        	





    }
}

   


	
