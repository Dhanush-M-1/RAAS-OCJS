import java.io.*;
import java.util.*;

public class b
{
	public static void main(String[] args)
	{
		FastScanner in = new FastScanner();
		Point points[] = new Point[3];
		
		for(int i = 0; i < 3; i++)
			points[i] = new Point(in.nextLong(), in.nextLong());
		
		double a1 = points[0].x;
		double b1 = points[1].x;
		double c1 = points[2].x;
		double a2 = points[0].y;
		double b2 = points[1].y;
		double c2 = points[2].y;
		
		long dist1 = points[0].dist(points[1]);
//		double dist2 = points[0].dist(points[2]);
		long dist3 = points[1].dist(points[2]);
		
//		System.out.println(dist1 + " " + dist3);
		double s1 = points[0].slope(points[1]);
		double s2 = points[0].slope(points[2]);
//		System.out.println(s1);
//		System.out.println(s2);
		
		if(s1 == s2)
			System.out.println("No");
		else if(dist1 == dist3)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	private static boolean equals(double a, double b)
	{
//		System.out.println("Diff: " + Math.abs(b-a));
		return Math.abs(a-b) < 1e-9;
	}

	public static class Point
	{
		long x, y;
		
		public Point(long xx, long yy)
		{
			x = xx;
			y = yy;
		}
		
		public long dist(Point o)
		{
			long dx = x-o.x;
			long dy = y-o.y;
			return dx*dx+dy*dy;
		}
		
		public String toString()
		{
			return x + " " + y;
		}
		
		public double slope(Point o)
		{
			double dx = x-o.x;
			double dy = y-o.y;
			return dy/dx;
		}
	}
	
	public static class FastScanner
	{
		BufferedReader br;
		StringTokenizer st;

		public FastScanner(String s)
		{
			try {
				br = new BufferedReader(new FileReader(s));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public FastScanner()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String nextToken()
		{
			while (st == null || !st.hasMoreElements())
			{
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt()
		{
			return Integer.parseInt(nextToken());
		}

		long nextLong()
		{
			return Long.parseLong(nextToken());
		}

		double nextDouble()
		{
			return Double.parseDouble(nextToken());
		}
		
		String next()
		{
			return nextToken();
		}
	}
}
