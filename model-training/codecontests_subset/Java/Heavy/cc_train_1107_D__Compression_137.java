	import java.io.*;
	import java.util.*;
	import java.math.*;
	
	 
	 public class Main	{
	   static class Pair implements Comparable<Pair>{

		   int a;
		   long b;
		   public Pair(int x,long y){a=x;b=y;}
		   public int compareTo(Pair p){
				 return Long.compare(a, p.a);
		   }
//		@Override
//		public int hashCode() {
//			final int prime = 31;
//			int result = 1;
//			result = prime * result + a;
//			result = prime * result + b;
//		   
//			return result;
//		}
//		@Override
//		public boolean equals(Object obj) {
//			Pair cur = (Pair)obj;
//			if((a==cur.a && b==cur.b))return true;
//			return false;
//		}
	 }
	   static class ArrayUtils {
			public static Integer[] generateOrder(int size) {
				Integer[] order = new Integer[size];
				for (int i = 0; i < size; i++)
					order[i] = i;
				return order;
			}
		 
			public static Integer[] order(int size, Comparator<Integer> comparator) {
				Integer[] order = generateOrder(size);
				Arrays.sort(order, comparator);
				return order;
			}
		 
				}
	static class TrieNode{
		int cnt;
		TrieNode[]child;
		public TrieNode() {
			cnt = 0;
			child = new TrieNode[10];
		}
	}
	  public static long gcd(long a,long b)
	  {
	    if(a<b)
	      return gcd(b,a);
	    if(b==0)
	      return a;
	    return gcd(b,a%b);
	    
	  }
	  static int lcm(int a,int b) {
		  return  a*b / (int)gcd(a,b);
	  }
	  
	  static long mod = 998244353;//(long)(1e9+7); //
	   
	    public static void main(String[] args) throws Exception {
	       new Thread(null, null, "Anshum Gupta", 99999999) {
	            public void run() {
	                try {
	                    solve();
	                } catch(Exception e) {
	                    e.printStackTrace();
	                    System.exit(1);
	                }
	            }
	        }.start();
	    }
	
	static long pow(long x,long y){
	    if(y == 0)return 1;
	    if(y==1)return x;
	    long a = pow(x,y/2);
	    a = (a*a)%mod;
	    if(y%2==0){
	        return a;
	    }
	    return (a*x)%mod;
	}
	
	static long mxx;
	static int mxN = (int)(2e6+5);
	static int mxV = (int)(2e5);
	static long[]fact,inv_fact;
	static long my_inv(long a) {
		return pow(a,mod-2);
	}
	static long bin(int a,int b) {
		if(a < b || a<0 || b<0)return 0;
	    return ((fact[a]*inv_fact[a-b])%mod * inv_fact[b])%mod;
	}
		static ArrayList<ArrayList<Integer>>adj;
		static boolean[]vis;
	static void make_facts() {
	  fact=new long[mxN];
	  inv_fact = new long[mxN];
	  fact[0]=inv_fact[0]=1L;
	  for(int i=1;i<mxN;i++) {
		   fact[i] = (i*fact[i-1])%mod;
		   inv_fact[i] = my_inv(fact[i]);
	  }
	}
	static int n;
	static int[][]a, sum;
	static int get_dec(char x) {
		int v = x - '0';
		if(v >= 0 && v <= 9)return v;
		else return x - 'A' + 10;
	}
	static boolean ispos(int x) {
		for(int i=x;i<=n;i+=x) {
			for(int j=x;j<=n;j+=x) {
				int cursum = sum[i][j] - sum[i-x][j] - sum[i][j-x] + sum[i-x][j-x];
				if(cursum == 0 || cursum == x * x)continue;
				return false;
			}
		}
		return true;
	}
	 public static void solve() throws Exception {
	   // solve the problem here
	   MyScanner s = new MyScanner();
	        out = new PrintWriter(new BufferedOutputStream(System.out), true);
	        int tc = 1;//s.nextInt();
	        mxx = (long)(1e18+5);
	//	        make_facts(); 
	//	        int mod = (int)1e9+7;
	        
	        while(tc-->0){
	        	n = s.nextInt();
	        	a = new int[n+1][n+1];
	        	for(int i=1;i<=n;i++) {
	        		String str = s.next();
	        		int j = 1;
	        		int k = 0;
	        		while(k < n/4) {
	        			int x = get_dec(str.charAt(k++));
	        			a[i][j+3] = x % 2;
	        			x /= 2;
	        			a[i][j+2] = x % 2;
	        			x /= 2;
	        			a[i][j+1] = x % 2;
	        			x /= 2;
	        			a[i][j] = x % 2;
	        			x /= 2;
	        			j += 4;
	        		}
	        	}
	        	sum = new int[n+1][n+1];
	        	for(int i=1;i<=n;i++) {
	        		for(int j=1;j<=n;j++) {
	        			sum[i][j] = sum[i-1][j] + sum[i][j-1] -  sum[i-1][j-1] + a[i][j];
	        		}
	        	}
//	        	for(int i=1;i<=n;i++) {
//	        		for(int j=1;j<=n;j++) {
//	        			out.print(a[i][j] + " ");
//	        		}out.println();
//	        	}
//	        	for(int i=1;i<=n;i++) {
//	        		for(int j=1;j<=n;j++) {
//	        			out.print(sum[i][j] + " ");
//	        		}out.println();
//	        	}
	        	int ans = 1;
	        	for(int x = n; x >= 1; x--) {
	        		if(n % x != 0)continue;
	        		if(ispos(x)) {
	        			ans = x;
	        			break;
	        		}
	        	}
	        	out.println(ans);
	        }
	        
	        	
	           
	        out.flush();
	}
	 
	     
	 
	 
	 
	    //-----------PrintWriter for faster output---------------------------------
	    public static PrintWriter out;
	 
	    //-----------MyScanner class for faster input----------
	    public static class MyScanner {
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public MyScanner() {
	            br = new BufferedReader(new InputStreamReader(System.in));
	        }
	 
	        String next() {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }
	 
	        int nextInt() { return Integer.parseInt(next()); }
	        long nextLong() { return Long.parseLong(next()); }
	        double nextDouble() { return Double.parseDouble(next()); }
	         
	        String nextLine(){
	            String str = "";
	            try {
	                str = br.readLine();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            return str;
	        }
	    }
	    //--------------------------------------------------------
	}
