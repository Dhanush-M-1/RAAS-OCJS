import java.io.*;
import java.util.*;


public class Competitive_2 {

	static int[][] p;
	
	public static void main(String[] args) {
		FastReader in = new FastReader();
		long x1=in.nextInt(), y1=in.nextInt(), x2=in.nextInt(), y2=in.nextInt(), x3=in.nextInt(), y3=in.nextInt();
		
//		System.out.println((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
//		System.out.println((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2));
		
		if( (x2-x1)*(y3-y1) - (y2-y1)*(x3-x1) == 0 || (x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)!=(x3-x2)*(x3-x2)+(y3-y2)*(y3-y2))
			System.out.println("NO");
		else
			System.out.println("YES");
		
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
