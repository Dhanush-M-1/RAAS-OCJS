import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Codechef
{
    
	public static void main (String[] args) throws java.lang.Exception
	{
	    try{
	    FastReader read=new FastReader();
		// your code goes here
		
		int t=read.nextInt();
		while(t>0)
		{
		    StringBuffer sb = new StringBuffer();
		    int k = read.nextInt();
		    int n = read.nextInt();
		    int m = read.nextInt();
		    int a[] = new int[n];
		    int b[] = new int[m];
		    for(int i=0;i<n;i++)
		    {
		        a[i]=read.nextInt();
		    }
		    for(int i=0;i<m;i++)
		    {
		        b[i] = read.nextInt();
		    }
		    int i=0,j=0;
		    boolean flag = false;
		    while(i<n || j<m)
		    {
		        if(i<n && a[i]==0)
		        {
		            sb.append("0");
		            sb.append(" ");
		            i++;
		            k++;
		           
		        }
		        else if(j<m && b[j]==0)
		        {
		            sb.append("0");
		            sb.append(" ");
		            j++;
		            k++;
		        }
		        else if(i<n && a[i]<=k)
		        {
		            sb.append(a[i]);
		            sb.append(" ");
		            i++;
		            
		        }
		        else if(j<m && b[j]<=k)
		        {
		            sb.append(b[j]);
		            sb.append(" ");
		            j++;
		           
		        }
		        else
		        {
		            flag=true;
		            break;
		        }
		    }
		    if(flag)
		    System.out.println("-1");
		    else
		   System.out.println(sb);
		    t--;
		}
		//System.out.println(sb);
	    }
	    catch(Exception e)
	    {return;
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