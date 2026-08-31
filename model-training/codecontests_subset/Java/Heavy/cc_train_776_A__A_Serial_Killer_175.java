import java.util.*;
import java.io.*;
public class test{
	public static void main(String[] args)
	{
		int x;
		long mod=(long)(1e9+7);
		FastReader scan=new FastReader();
		OutputStream output=System.out;
		PrintWriter out=new PrintWriter(output);
		String a=scan.next();
		String b=scan.next();
		int n=scan.nextInt();
		out.println(a+" "+b);
		while(n-->0)
		{
			String c=scan.next();
			String d=scan.next();
			if(c.equals(a))
				a=d;
			else
				b=d;
			out.println(a+" "+b);
		}
		out.close();
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