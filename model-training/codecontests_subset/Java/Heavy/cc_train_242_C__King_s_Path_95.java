
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KingsPath 
{
	static int x0, y0, xf, yf, n;
	
	static class C implements Comparator<Qentry>
	{

		@Override
		public int compare(Qentry arg0, Qentry arg1) 
		{
			return arg0.d - arg1.d;
		}
	}
	
	static class Qentry
	{
		int x, y, d;
		
		public Qentry(int x0, int y0, int d0)
		{
			x = x0;
			y = y0;
			d = d0;
		}
	}
	
	static class WhyNot
	{
		HashSet<Integer> gox = new HashSet<Integer>();
		HashMap<Integer, Integer> d = new HashMap<Integer, Integer>();
	}
	
	public static void main(String[] args) 
	{
		FastReader sc = new FastReader();
		WhyNot[] yn = new WhyNot[200001];
		for(int i = 0; i <= 200000; i++)
		{
			yn[i] = new WhyNot();
		}
		
//		System.out.println("BRUHH");
		
		y0 = sc.nextInt();
		x0 = sc.nextInt();
		yf = sc.nextInt() - y0 + 100000;
		xf = sc.nextInt() - x0 + 100000;
		
		if(Math.abs(xf-100000) > 100001 || Math.abs(yf-100000) > 100001)
		{
			System.out.println(-1);
			return;
		}
		
		
		n = sc.nextInt();
		
		for(int i = 0; i < n; i++)
		{
			int y = sc.nextInt() - y0+100000;
			int x1 = sc.nextInt() - x0+100000;
			int x2 = sc.nextInt() - x0+100000;
			
			if(y >= 0 && y <= 200000)
				for(int x = x1; x <= x2 && x >= 0 && x <= 200000; x++)
				{
					yn[y].gox.add(x);
				}
		}
		
		//go
		int xp = 100000;
		int yp = 100000;
		
//		System.out.println("THING " + yn[100000].gox);
//		System.out.println("THING " + yn[100001].gox);
		
		
		C c = new C();
		PriorityQueue<Qentry> pq = new PriorityQueue<Qentry>(c); 
		pq.add(new Qentry(100000, 100000, 0));
		yn[100000].d.put(100000, 0);
		
		while(!pq.isEmpty())
		{
			Qentry curq = pq.poll();
			
//			System.out.println(curq.x + " " + curq.y);
			for(int it = 0; it <= 7; it++)
			{
				int xx = curq.x;
				int yy = curq.y;
				
				if(it == 0) {xx--; yy--;}
				else if(it == 1){yy--;}
				else if(it == 2) {xx++; yy--;}
				else if(it == 3) {xx++;}
				else if(it == 4) {xx++; yy++;}
				else if(it == 5) {yy++;}
				else if(it == 6) {xx--; yy++;}
				else if(it == 7) {xx--;}
//				System.out.println(" IT " + it);
				
				if(yy >= 0 && yy <= 200000 && xx >= 0 && xx <= 200000)
				{
					if(xx == xf && yy == yf)
					{
						System.out.println(curq.d+1);
						return;
					}
					
					if(yn[yy].gox.contains(xx) && (!yn[yy].d.containsKey(xx) || yn[yy].d.get(xx) > curq.d+1))
					{
//						System.out.println("Step to " + xx + " " + yy);
						yn[yy].d.put(xx, curq.d+1);
						pq.add(new Qentry(xx, yy, curq.d+1));
					}
					else
					{
//						System.out.println("Failed step to " + xx + " " + yy);
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
