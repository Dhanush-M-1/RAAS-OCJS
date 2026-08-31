import java.io.*;
import java.util.*;
import java.math.*;

public class Competitive_1 {
	
	public static final long bias = 1000000000;
	public static final int dirX[] = {1,0,1,-1,0,-1,-1,1};
	public static final int dirY[] = {0,1,1,0,-1,-1,1,-1};
	
	public static void main(String[] args) {
		FastReader in = new FastReader();
		int x0=in.nextInt(), y0=in.nextInt(), x1=in.nextInt(), y1=in.nextInt(), n=in.nextInt();
		
		HashSet<Long> allowed = new HashSet<Long>();
		for(int i=0; i<n; i++){
			int r=in.nextInt(), a=in.nextInt(), b=in.nextInt();
			for(int j=a; j<=b; j++)
				allowed.add( r*bias + j );
		}
		
		Queue<Long> q = new LinkedList<Long>();
		HashSet<Long> visited = new HashSet<Long>();
		long depth = -1;
		
		q.add(x0*bias + y0);
		visited.add(x0*bias + y0);
		
		while(!q.isEmpty()){
			depth++;
			int nOfLevel=q.size();
			
			for(int i=0; i<nOfLevel; i++){
				long point = q.poll();
				long x = point/bias, y = point%bias;
				
				if(x==x1 && y==y1){
					System.out.println(depth);
					return;
				}
				
				for(int j=0; j<8; j++){
					long xx=x+dirX[j], yy=y+dirY[j];
					long pp = xx*bias + yy;
					if(!visited.contains(pp) && allowed.contains(pp)){
						visited.add(pp);
						q.add(pp);
					}
				}
			}
		}
		
		System.out.println(-1);
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
