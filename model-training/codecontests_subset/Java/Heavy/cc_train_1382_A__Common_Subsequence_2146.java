import java.io.BufferedReader;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class q1 {
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) {
		FastReader s = new FastReader();
		
		int t = s.nextInt();
		
		while(t-- > 0)
		{
			int n  =s.nextInt();
			int m  =s.nextInt();
			
			int[] a = new int[n];
			int[] b = new int[m];
			Set<Integer> set = new HashSet<>();
			for(int i=0;i<a.length;++i)
			{
				a[i] = s.nextInt();
				set.add(a[i]);
			}
			int k = -1;
			for(int i=0;i<m;++i)
			{
				b[i] = s.nextInt();
				if(set.contains(b[i]))
					k = b[i];
			}
			
			if(k == -1)
				out.println("NO");
			else
			{
				out.println("YES");out.println(1 + " "+ k);
				
			}
			
		}
			
			
			
		
		out.flush();
		out.close();
	}
	
	static class FastReader {
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
