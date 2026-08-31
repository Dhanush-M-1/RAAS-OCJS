import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;



public class  gym{

static class SegmentTree {		// 1-based DS, OOP
	
	int N; 			//the number of elements in the array as a power of 2 (i.e. after padding)
	int[] array, sTree, lazy;
	
	SegmentTree(int[] in)		
	{
		array = in; N = in.length - 1;
		sTree = new int[N<<1];		//no. of nodes = 2*N - 1, we add one to cross out index zero
		lazy = new int[N<<1];
		build(1,1,N);
	}
	
	void build(int node, int b, int e)	// O(n)
	{
		if(b == e)					
			sTree[node] = array[b];
		else						
		{
			int mid = b + e >> 1;
			build(node<<1,b,mid);
			build(node<<1|1,mid+1,e);
			sTree[node] = sTree[node<<1]+sTree[node<<1|1];
		}
	}
	
	
	void update_point(int index, int val)			// O(log n)
	{
		index += N - 1;				
		sTree[index] += val;			
		while(index>1)				
		{
			index >>= 1;
			sTree[index] = sTree[index<<1] + sTree[index<<1|1];		
		}
	}
	
	
	void update_range(int i, int j, int val)		// O(log n) 
	{
		update_range(1,1,N,i,j,val);
	}
	
	void update_range(int node, int b, int e, int i, int j, int val)
	{
		if(i > e || j < b)		
			return;
		if(b >= i && e <= j)		
		{
			sTree[node] += (e-b+1)*val;			
			lazy[node] += val;				
		}							
		else		
		{
			int mid = b + e >> 1;
			propagate(node, b, mid, e);
			update_range(node<<1,b,mid,i,j,val);
			update_range(node<<1|1,mid+1,e,i,j,val);
			sTree[node] = sTree[node<<1] + sTree[node<<1|1];		
		}
		
	}
	void propagate(int node, int b, int mid, int e)		
	{
		lazy[node<<1] += lazy[node];
		lazy[node<<1|1] += lazy[node];
		sTree[node<<1] += (mid-b+1)*lazy[node];		
		sTree[node<<1|1] += (e-mid)*lazy[node];		
		lazy[node] = 0;
	}
	
	int query(int i, int j)
	{
		return query(1,1,N,i,j);
	}
	
	int query(int node, int b, int e, int i, int j)	// O(log n)
	{
		if(i>e || j <b)
			return 0;		
		if(b>= i && e <= j)
			return sTree[node];
		int mid = b + e >> 1;
		propagate(node, b, mid, e);
		int q1 = query(node<<1,b,mid,i,j);
		int q2 = query(node<<1|1,mid+1,e,i,j);
		return q1 + q2;	
				
	}
	
	
	
	
}
    public static void main(String[] args) throws IOException{
        MScanner sc = new MScanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        
        int n = sc.nextInt();
        LinkedList<Integer>[]adj=new LinkedList[n];
        for(int i=0;i<n;i++)adj[i]=new LinkedList<Integer>();
        for(int i=0;i<n-1;i++) {
        	int x=sc.nextInt()-1;int y=sc.nextInt()-1;
        	adj[x].add(y);adj[y].add(x);
        }
        for(int i=0;i<n;i++) {
        	if(adj[i].size()==2) {
        		pw.println("NO");pw.flush();return;
        	}
        }
        pw.println("YES");
        pw.flush();
    }
    static class Vector {

    	double x, y; 

    	Vector(double a, double b) { x = a; y = b; }

    	Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

    	Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

    	double dot(Vector v) { return (x * v.x + y * v.y); }

    	double cross(Vector v) { return x * v.y - y * v.x; }

    	double norm2() { return x * x + y * y; }

    	Vector reverse() { return new Vector(-x, -y); }

    	Vector normalize() 
    	{ 
    		double d = Math.sqrt(norm2());
    		return scale(1 / d);
    	}		
    }
    static class Point implements Comparable<Point>{

    	static final double EPS = 1e-9;

    	double x, y;                  

    	Point(double a, double b) { x = a; y = b; }  
    	
    	public int compareTo(Point p)
    	{
    		if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
    		if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
    		return 0;
    	}
    	public String toString() {
    		return "("+x+" "+y+")";
    	}
    	public double dist(Point p) { return sq(x - p.x) + sq(y - p.y); }
    	
    	static double sq(double x) { return x * x; }
    	
    	Point rotate(double angle)
    	{
    		double c = Math.cos(angle), s = Math.sin(angle);
    		return new Point(x * c - y * s, x * s + y * c);
    	}
    	// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x
    	
    	Point rotate(double theta, Point p)			//rotate around p
    	{
    		Vector v = new Vector(p, new Point(0, 0));
    		return translate(v).rotate(theta).translate(v.reverse());
    	}
    	
    	Point translate(Vector v) { return new Point(x + v.x , y + v.y); }
    	
    	Point reflectionPoint(Line l) 	//reflection point of p on line l
    	{
    		Point p = l.closestPoint(this);
    		Vector v = new Vector(this, p);
    		return this.translate(v).translate(v);
    	}
    	
    	boolean between(Point p, Point q)
    	{
    		return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
    				&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
    	}
    	
    	//returns true if it is on the line defined by a and b
    	boolean onLine(Point a, Point b) 
    	{
    		if(a.compareTo(b) == 0) return compareTo(a) == 0;
    		return Math.abs(new Vector(a, b).cross(new Vector(a, this))) < EPS;
    	}
    	
    	boolean onSegment(Point a, Point b)
    	{
    		if(a.compareTo(b) == 0) return compareTo(a) == 0;
    		return onRay(a, b) && onRay(b, a);
    	}
    	
    	//returns true if it is on the ray whose start point is a and passes through b
    	boolean onRay(Point a, Point b)
    	{
    		if(a.compareTo(b) == 0) return compareTo(a) == 0;
    		return new Vector(a, b).normalize().equals(new Vector(a, this).normalize());	//implement equals()
    	}
    	
    	// returns true if it is on the left side of Line pq
    	// add EPS to LHS if on-line points are accepted
    	static boolean ccw(Point p, Point q, Point r)
    	{
    		return new Vector(p, q).cross(new Vector(p, r)) > 0;
    	}
    	
    	static boolean collinear(Point p, Point q, Point r)
    	{
    		return Math.abs(new Vector(p, q).cross(new Vector(p, r))) < EPS;
    	}
    	
    	static double angle(Point a, Point o, Point b)  // angle AOB
    	{
    		Vector oa = new Vector(o, a), ob = new Vector(o, b);
    		return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
    	}
    	
    	static double distToLine(Point p, Point a, Point b) //distance between point p and a line defined by points a, b (a != b)
    	{
    		if(a.compareTo(b) == 0) return p.dist(a);
    		// formula: c = a + u * ab
    		Vector ap = new Vector(a, p), ab = new Vector(a, b);
    		double u = ap.dot(ab) / ab.norm2();
    		Point c = a.translate(ab.scale(u)); 
    		return p.dist(c);
    	}
    	// Another way: find closest point and calculate the distance between it and p

    	static double distToLineSegment(Point p, Point a, Point b) 
    	{
    		Vector ap = new Vector(a, p), ab = new Vector(a, b);
    		double u = ap.dot(ab) / ab.norm2();
    		if (u < 0.0) return p.dist(a);
    		if (u > 1.0) return p.dist(b);        
    		return distToLine(p, a, b); 
    	}
    	// Another way: find closest point and calculate the distance between it and p
    }
    static class Line {

    	static final double INF = 1e9, EPS = 1e-9;
    	
    	double a, b, c;
    	
    	Line(Point p, Point q)
    	{
    		if(Math.abs(p.x - q.x) < EPS) {	a = 1; b = 0; c = -p.x;	}
    		else
    		{
    			a = (p.y - q.y) / (q.x - p.x);
    			b = 1.0;
    			c = -(a * p.x + p.y);
    		}
    					
    	}
    	
    	Line(Point p, double m) { a = -m; b = 1; c =  -(a * p.x + p.y); } 
    	
    	boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
    	
    	boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }
    	
    	Point intersect(Line l)
    	{
    		if(parallel(l))
    			return null;
    		double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
    		double y;
    		if(Math.abs(b) < EPS)
    			 y = -l.a * x - l.c;
    		else
    			y = -a * x - c;
    		
    		return new Point(x, y);
    	}
    	
    	Point closestPoint(Point p)
    	{
    		if(Math.abs(b) < EPS) return new Point(-c, p.y);
    		if(Math.abs(a) < EPS) return new Point(p.x, -c);
    		return intersect(new Line(p, 1 / a));
    	}
    			
    }
    static long gcd(long a, long b) {

		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
    static int[]primes;
    static int sizeofp=0;
	static int[] isComposite;

	static void sieve(int N)	// O(N log log N) 
	{
		isComposite = new int[N+1];					
		isComposite[0] = isComposite[1] = 1;			
		primes = new int[N];

		for (int i = 2; i <= N; ++i) 					
			if (isComposite[i] == 0) 					
			{
				primes[sizeofp++]=i;;
				if(1l * i * i <= N)
					for (int j = i * i; j <= N; j += i)	
						isComposite[j] = 1;
			}   
	}
    static class pair implements Comparable<pair>{
    	int num;int idx;int s;
    	pair(int x,int y,int o){
    		num=x;idx=y;s=o;
    	}
		@Override
		public int compareTo(pair o) {
			if(num!=o.num) {
				return num-o.num;
			}
			return idx-o.idx;
		}
		public boolean equals(pair o) {
			if(this.compareTo(o)==0)return true;
			return false;
		}
		public String toString() {
			return "("+0+" "+0+")";
		}
    }
	static class MScanner 
	{
	    StringTokenizer st;
	    BufferedReader br;

	    public MScanner(InputStream s){    br = new BufferedReader(new InputStreamReader(s));}

	    public String next() throws IOException 
	    {
	        while (st == null || !st.hasMoreTokens()) 
	            st = new StringTokenizer(br.readLine());
	        return st.nextToken();
	    }

	    public int nextInt() throws IOException {return Integer.parseInt(next());}
	    
	    public long nextLong() throws IOException {return Long.parseLong(next());}

	    public String nextLine() throws IOException {return br.readLine();}
	    
	    public double nextDouble() throws IOException
	    {
	        String x = next();
	        StringBuilder sb = new StringBuilder("0");
	        double res = 0, f = 1;
	        boolean dec = false, neg = false;
	        int start = 0;
	        if(x.charAt(0) == '-')
	        {
	            neg = true;
	            start++;
	        }
	        for(int i = start; i < x.length(); i++)
	            if(x.charAt(i) == '.')
	            {
	                res = Long.parseLong(sb.toString());
	                sb = new StringBuilder("0");
	                dec = true;
	            }
	            else
	            {
	                sb.append(x.charAt(i));
	                if(dec)
	                    f *= 10;
	            }
	        res += Long.parseLong(sb.toString()) / f;
	        return res * (neg?-1:1);
	    }
	    
	    public boolean ready() throws IOException {return br.ready();}


	}
}