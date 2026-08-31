import java.util.*;
import java.io.*;
public class test{
	public static void main(String[] args)
	{
		int x,y;
		FastReader scan=new FastReader();
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		int n=scan.nextInt();
		int k=scan.nextInt();
		int[] arr=new int[n];
		for(x=0;x<n;x++)
			arr[x]=scan.nextInt();
		Arrays.sort(arr);
		for(x=n-1;x>=0;x--)
		{
			if(k%arr[x]==0)
			{
				out.println(k/arr[x]);
				break;
			}
		}
		out.flush();
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
