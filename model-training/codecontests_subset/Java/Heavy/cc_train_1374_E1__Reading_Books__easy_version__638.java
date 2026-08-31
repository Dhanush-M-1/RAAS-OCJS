import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;



public class q5 {
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
	public static class node{
		int ind;
		node left;
		node right;
	}
	public static void main(String[] args) {
		FastReader s = new FastReader();
		int t = 1;
		while(t-- > 0)
		{
			int n = s.nextInt();
			int k = s.nextInt();
			long ans = 0;
			
			PriorityQueue<Integer> c = new PriorityQueue<>();
			PriorityQueue<Integer> a = new PriorityQueue<>();
			PriorityQueue<Integer> b = new PriorityQueue<>();
		
			for(int i=0;i<n;++i)
			{
				int l = s.nextInt();
				int m = s.nextInt();
				int p = s.nextInt();
				
				if(m == 1 && p == 1)
					c.add(l);
				else if(m == 1)
					a.add(l);
				else if(p == 1)
					b.add(l);
				
				
			}
			int ca = 0;
			int cb = 0;
			while(ca < k && cb < k)
			{
				if(a.isEmpty() && b.isEmpty() && c.isEmpty())
					break;
				else if(a.isEmpty() && b.isEmpty() && !c.isEmpty())
				{
					ans += c.poll();
					ca++;cb++;
				}
				else if(!a.isEmpty() && b.isEmpty() && c.isEmpty())
				{
					ans += a.poll();
					ca++;
				}
				else if(a.isEmpty() && !b.isEmpty() && c.isEmpty())
				{
					ans += b.poll();
					cb++;
				}
				else if(!a.isEmpty() && !b.isEmpty() && c.isEmpty())
				{
					ans += b.poll();
					ans += a.poll();
					cb++;ca++;
				}
				else if(!a.isEmpty() && b.isEmpty() && !c.isEmpty())
				{
					ans += c.poll();
					ca++;cb++;
				}
				else if(a.isEmpty() && !b.isEmpty() && !c.isEmpty())
				{
					ans += c.poll();
					ca++;cb++;
				}
				else{
					if(a.peek() + b.peek() < c.peek())
					{
						ans += b.poll();
						ans += a.poll();
						cb++;ca++;
					}
					else{
						ans += c.poll();
						ca++;cb++;
					}
				}
				
				
			}
			
			if(ca < k || cb < k )
				out.println(-1);
			else out.println(ans);
			
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
