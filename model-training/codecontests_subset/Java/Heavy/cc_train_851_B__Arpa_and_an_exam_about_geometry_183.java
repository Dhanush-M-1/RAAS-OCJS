import java.io.*;
import java.util.*;


public class B {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		Point a = new Point(sc.nextInt(),sc.nextInt());
		Point b = new Point(sc.nextInt(),sc.nextInt());
		Point c = new Point(sc.nextInt(),sc.nextInt());

		long ccw = ccw(a, b, c);

		double ang1 = angle(a, b, c) * 180 / Math.PI;
		double ang2 = angle(a, c, b)* 180 / Math.PI;
		double ang3 = angle(c, a, b)* 180 / Math.PI;

		boolean ok = false;
		if((ang1 + EPS > 90 || ang2 + EPS > 90 || ang3 + EPS > 90) && !((Math.abs(ang1-90) < EPS) || (Math.abs(ang2-90) < EPS) 
				|| (Math.abs(ang3-90) < EPS)	))
		{
			double max = Math.max(ang1, Math.max(ang2, ang3));
			if(max == ang1)
				ok = true;
		}
		else
			ok = true;
		if(ccw == 0 )
			System.out.println("No");
		else
			if(ok && dist(a,b) == dist(b, c))
				System.out.println("Yes");
			else
				System.out.println("No");

	}
	
	static  long dist(Point p, Point q) { return (sq(q.x - p.x) + sq(q.y - p.y)); }
	static long sq(long x) { return 1l*x * x; }
	
	static double EPS = 1e-8;

	static double angle(Point a, Point o, Point b)  // angle AOB
	{
		Vector oa = new Vector(o, a), ob = new Vector(o, b);
		return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));			// it returns a positive angle
	}

	static long ccw(Point p, Point q, Point r)			//positive cross product means counter-clockwise
	{
		return new Vector(p, q).cross(new Vector(p, r));
	}

	static class Scanner{
		StringTokenizer st;BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public String next() throws IOException 
		{while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public boolean ready() throws IOException {return br.ready();}
	}
	static class Point{

		static final double EPS = 1e-9;

		int x, y;                  

		Point(int a, int b) 
		{ 
			x = a; y = b; 
		}  
	}
	static class Vector {

		int x, y; 

		Vector(int a, int b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

		long dot(Vector v) { return (1l*x * v.x + 1l*y * v.y); }

		long cross(Vector v) { return 1l*x * v.y - 1l*y * v.x; }

		double norm2() { return x * x + y * y; }					//only returns norm squared

		Vector reverse() { return new Vector(-x, -y); }

	}
}
