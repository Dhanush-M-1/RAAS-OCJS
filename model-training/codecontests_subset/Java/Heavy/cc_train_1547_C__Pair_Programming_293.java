import java.util.*;
import java.io.*;
public class Test {
	public static void main(String[] args) throws IOException {
	   Scanner sc = new Scanner(System.in);
	   PrintWriter pw = new PrintWriter(System.out);
	   int t = sc.nextInt();
	   while(t-->0) {
		   int tot = sc.nextInt();
		   int n = sc.nextInt();
		   int m = sc.nextInt();
		   int [] a = new int [n];
		   int [] b = new int[m];
		  for(int c = 0;c<n;c++) {
			  a[c]= sc.nextInt();
		  }
		  for(int c = 0;c<m;c++) {
			  b[c] = sc.nextInt();
		  }
		   int i = 0;
		   int j = 0;
		   int[] res = new int[n+m];
		   boolean can = true;
		   for(int k = 0;k<res.length;k++) {
			   if(i<a.length&& a[i]==0) {
				   //System.out.println("ll");
				   tot++;
				   res[k] = a[i];
				   i++;
				   
			   }
			   else if(j<b.length && b[j]==0) {
				   //System.out.println("ll1");

				   tot++;
				   res[k] = b[j];

				   j++;
				   //System.out.println(j);
			   }
			   else if (i<a.length&& a[i]<=tot) {
				   //System.out.println("ll2");

				   res[k] = a[i];
					   i++;
				   }
			   else if(j<b.length&& b[j]<=tot) {
				  // System.out.println("ll3");

				   res[k] = b[j];
				   j++;
			   }
			   else {
				   can = false;
				   break;
			   }
		   }
		   if(can ) {
			   for(int c = 0;c<res.length;c++) {
				   System.out.print(res[c]+" ");
			   }
			   System.out.println();
		   }
		   else {
			   System.out.println(-1);
		   }
		 
	   
	
		   	
	}}
	public static int idxOf(String s,char c) {
		int idx = -2;
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)==c) {
				return i;
			}
		}
		return idx;
	}
	static ArrayList<Long >start;
	static ArrayList<Long> end;
	public static void dfs (int idx) {
		can[idx] = true;
		for(int i = 0;i<start.size();i++) {
			if((start.get(i)<start.get(idx)&& end.get(i)>start.get(idx)||(start.get(i)<end.get(idx)&& end.get(i)>end.get(idx)))){
				if(!can[i]) {
				dfs(i);
			}}
		}
	}
	static boolean [] can ; 
	static int n;
	
	static int [] [] sol;
	static int [] g;
	public static void constructSol() {
		for(int i = 1;i<sol.length;i++) {
			for(int j = 1;j<10;j++) {
				if(g[i] == j) {
					sol[i][j] = sol[i-1][j]+1;
				}
				else {
					sol[i][j] = sol[i-1][j];
				}
			}
		}
	}
	public static void prod() {
		for(int i=1;i<g.length;i++) {
			int n = i;
		if(n<10) {
			g[ n] = n;
		    continue;
		}
		int prod = 1;
		while(n>0) {
			if(n%10!=0) {
				prod*= (n%10);
				
			}
			n/=10;
		}
		//System.out.println(prod);
		g[i] = g[prod];
	
	}}
	public static  boolean isPalindrome(String s) {
		
		for(int i = 0;i<=s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	public static long logBase2(long n) {
		long ans = 0;
		while(n>1) {
			ans ++;
			n/=2;
		}
		return ans;
	}
	public static double getmostLeft(ArrayList<Circle> list) {
	        double min = Double.MAX_VALUE;
	        for (Circle c: list) {
	            min = Math.min(min, c.x - c.r);
	        }
	        return min;
	    }
 
	   public static double getmostRight(ArrayList<Circle> list) {
	        double max = Double.MIN_VALUE;
	        for (Circle c: list) {
	            max = Math.max(max, c.x + c.r);
	        }
	        return max;
	    }
	static class Circle{
		double x ;
		double y ;
		double r;
		int id;
		public Circle(double x, double y, double r) {
			this.x = x;
			this.y = y;
			this.r = r;
			
		}
		public String toString () {
			return x +" "+y+" "+r;
		}
		public boolean intersect(Circle o) {
			double dist = Math.sqrt((y-o.y)*(y-o.y)+(x-o.x)*(x-o.x));
			if(dist<=r+o.r) {
				return true;
			}
			return false;
		}
		public  Circle combine( Circle o) {
			double dist = Math.sqrt((y-o.y)*(y-o.y)+(x-o.x)*(x-o.x));
		    if(Math.abs(r-o.r)>=dist) {
		    	if(r>=o.r) {
		    		return this;
		    	}
		    	else {
		    		return o;
		    	}
		    }
 
			double cx = (x+o.x)/2.0;
			double cy = (y+o.y)/2.0;
			double rad = (dist +r +this.r)/2.0;
			return new Circle (cx, cy, rad);
		}
	}
	static class Pair implements Comparable {
		long x;
		int y;
		public Pair (long x, int y) {
			this.x = x;
			this.y = y;
			
		}
		@Override
		public int compareTo(Object arg0) {
			Pair p = (Pair) arg0;
		return Long.compare(x, p.x);
		}
	}
	public static String solve (String s) {
		Stack <String> st = new Stack<String>();
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i)==']') {
				String toEncode = "";
				while(!st.isEmpty()&&!st.peek().equals("[")) {
					toEncode = st.pop()+ toEncode;
				}
				st.pop();
				String toPush = "";
				int freq = Integer.parseInt(st.pop());
				while(freq-->0) {
					toPush+=toEncode;
				}
				st.push(toPush);
			}
			else {
				st.push(s.charAt(i)+"");
			}
			
		}
		String res = "";
		while(!st.isEmpty()) {
			res = st.pop() +res;
		}
		return res;
	}
	static String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static int solve (int i, int j) {
		//System.out.println("hh");
		int p = 0;
		for(int k = i;k<=j;k++) {
			if(s.charAt(k)==alph.charAt(p)) {
				p++;
			}
			if(p==26) {
				return (j-i+1);
			}
		}
		return Integer.MAX_VALUE;
		
	}
	static String s;
	static ArrayList <Integer> prime;
	 static void simpleSieve(int limit)
	    {   
	        // Create a boolean array "mark[0..n-1]" and initialize
	        // all entries of it as true. A value in mark[p] will
	        // finally be false if 'p' is Not a prime, else true.
	        boolean mark[] = new boolean[limit+1];
	         
	        for (int i = 0; i < mark.length; i++)
	            mark[i] = true;
	      
	        for (int p=2; p*p<limit; p++)
	        {
	            // If p is not changed, then it is a prime
	            if (mark[p] == true)
	            {
	                // Update all multiples of p
	                for (int i=p*p; i<limit; i+=p)
	                    mark[i] = false;
	            }
	        }
	      
	        // Print all prime numbers and store them in prime
	        for (int p=2; p<limit; p++)
	        {
	            if (mark[p] == true)
	            {
	                prime.add(p);
	               // System.out.print(p + "  ");
	            }
	        }
	    }
 
	 
	 public static long gcd (long a, long b ) {
		 if(b==0) {
			 return a;
		 }
		 else {
			 return gcd (b, a%b);
		 }
	 }
	 
 static class Scanner {
 		StringTokenizer st;
 		BufferedReader br;
  
 		public Scanner(InputStream s) {
 			br = new BufferedReader(new InputStreamReader(s));
 		}
        public Scanner(FileReader r) {
        	br = new BufferedReader(r);
        }
 		public boolean hasNext() {
 			// TODO Auto-generated method stub
 			return false;
 		}
  
 		public String next() throws IOException {
 			while (st == null || !st.hasMoreTokens())
 				st = new StringTokenizer(br.readLine());
 			return st.nextToken();
 		}
  
 		public int nextInt() throws IOException {
 			return Integer.parseInt(next());
 		}
  
 		public long nextLong() throws IOException {
 			return Long.parseLong(next());
 		}
  
 		public String nextLine() throws IOException {
 			return br.readLine();
 		}
  
 		public double nextDouble() throws IOException {
 			String x = next();
 			StringBuilder sb = new StringBuilder("0");
 			double res = 0, f = 1;
 			boolean dec = false, neg = false;
 			int start = 0;
 			if (x.charAt(0) == '-') {
 				neg = true;
 				start++;
 			}
 			for (int i = start; i < x.length(); i++)
 				if (x.charAt(i) == '.') {
 					res = Long.parseLong(sb.toString());
 					sb = new StringBuilder("0");
 					dec = true;
 				} else {
 					sb.append(x.charAt(i));
 					if (dec)
 						f *= 10;
 				}
 			res += Long.parseLong(sb.toString()) / f;
 			return res * (neg ? -1 : 1);
 		}
  
 		public boolean ready() throws IOException {
 			return br.ready();
 		}
  
 	}
}