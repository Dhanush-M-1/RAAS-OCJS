    import java.awt.Point;
import java.io.*;
        		    import java.math.*;
        		    import java.util.*;
        		    import javax.print.attribute.SetOfIntegerSyntax;


     
        		    // kishanthesiya25@gmail.com
        		    // kishan_25
        		    // @daiict
        		    
     
        		    public class latest{
        		    	private static InputStream stream;
        		    	private static byte[] buf = new byte[1024];
        		    	private static int curChar;
        		    	private static int numChars;
        		    	private static SpaceCharFilter filter;
        		    	private static PrintWriter pw;

        		    	
        		    	static ArrayList<Integer> arr[];
        		    	static ArrayList<Integer> ans;
        		    	static int f;
        		    	
        		    	private static long count = 0,mod=1000000007;
        		    //	private static TreeSet<Integer> ts=new TreeSet[200000];
     
        		        public static void main(String[] args) {
        		        	InputReader(System.in);
        		    		pw = new PrintWriter(System.out); 
        		            new Thread(null ,new Runnable(){
        		               public void run(){
        		                   try{
        		                       soln2();
        		                       pw.close();
        		                   } catch(Exception e){
        		                       e.printStackTrace();
        		                   }
        		               }
        		           },"1",1<<26).start();
        		       }

        		    	public static long gcd(long x, long y) {
        		    		if (x == 0)
        		    			return y;
        		    		else
        		    			return gcd( y % x,x);
        		    	}	public static boolean isPrime(int n) {
        		    	// Corner cases
			    		if (n <= 1)
			    			return false;
			    		if (n <= 3)
			    			return true;
			     
			    		// This is checked so that we can skip 
			    		// middle five numbers in below loop
			    		if (n % 2 == 0 || n % 3 == 0)
			    			return false;
			     
			    		for (int i = 5; i * i <= n; i = i + 6)
			    			if (n % i == 0 || n % (i + 2) == 0)
			    				return false;
			     
			    		return true;
			    	}
        		        static LinkedList<Integer> adj[];
        		      
        		        static boolean Visited[];
        		        static long color[];
        		        static long dist[][];
        		        static long no_sp_no_sub[];
        		        static int visited[];
        		    	static Stack<Integer> stack;
        		    	static int n;
        		    	static int m;
        		    	static int main[];
        		    	static int status[];
        		        
        		        private static void soln2(){
        		        	
        		        	Scanner in = new Scanner(System.in);
        		        	
        		        	//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        		        	
        		        
        		        	int n = in.nextInt();
        		        	int k = in.nextInt();
        		        	in.nextLine();
        		        	
        		        	int arr[] = new int[n];
        		        	
        		        	for(int i = 0;i<n;i++){
        		        		arr[i] = in.nextInt();
        		        	}
        		        	
        		        	long i=1;
        		    		long r=0;
        		    		while(r<k && r+i<k){
        		    			r = r+i;
        		    			i++;
        		    		}
        		    		System.out.println(arr[(int)(k-r-1)]);
        		        
        		        	
        		        }
        		        

        		        public static long pow(long n,long p,long m){
        		            long  result = 1;
        		             if(p==0)
        		               return 1;
        		           if (p==1)
        		               return n;
        		           while(p!=0)
        		           {
        		               if(p%2==1)
        		                   result *= n;
        		               if(result>=m)
        		               result%=m;
        		               p >>=1;
        		               n*=n;
        		               if(n>=m)
        		               n%=m;
        		           }
        		           return result;
        		           }
        		        
        		    	public static void dfs(int i){
        		    		
        		    		if(status[i] == 0){
        		    			status[i] = 1;

            		    		 for(int j = 0;j<arr[i].size();j++){
            		    			dfs(arr[i].get(j));
            		    		}
            		    		
            		    		status[i] = 2;
            		    		ans.add(i);
            		    		
        		    		}else if(status[i] == 1){
        		    			f = 1;
        		    			return;
        		    		}
        		    	}
        		      
        		    
        		        
        		        
        		        private static long maxSubarraySum(long a[]){
        		        	long max_so_far=Long.MIN_VALUE;
        		        	long max_ending_here=0;
        		        	for(int i=0;i<a.length;i++){
        		        		max_ending_here+=a[i];
        		        		if(max_ending_here>max_so_far)
        		        			max_so_far=max_ending_here;
        		        		if(max_ending_here<0)
        		        			max_ending_here=0;
        		        	}
        		        	return max_so_far;
        		        }

     
        		    	// To Get Input
        		    	// Some Buffer Methods
     
        		    	public static void InputReader(InputStream stream1) {
        		    		stream = stream1;
        		    	}
     
        		    	private static boolean isWhitespace(int c) {
        		    		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        		    	}
     
        		    	private static boolean isEndOfLine(int c) {
        		    		return c == '\n' || c == '\r' || c == -1;
        		    	}
     
        		    	private static int read() {
        		    		if (numChars == -1)
        		    			throw new InputMismatchException();
        		    		if (curChar >= numChars) {
        		    			curChar = 0;
        		    			try {
        		    				numChars = stream.read(buf);
        		    			} catch (IOException e) {
        		    				throw new InputMismatchException();
        		    			}
        		    			if (numChars <= 0)
        		    				return -1;
        		    		}
        		    		return buf[curChar++];
        		    	}
     
        		    	private static int nextInt() {
        		    		int c = read();
        		    		while (isSpaceChar(c))
        		    			c = read();
        		    		int sgn = 1;
        		    		if (c == '-') {
        		    			sgn = -1;
        		    			c = read();
        		    		}
        		    		int res = 0;
        		    		do {
        		    			if (c < '0' || c > '9')
        		    				throw new InputMismatchException();
        		    			res *= 10;
        		    			res += c - '0';
        		    			c = read();
        		    		} while (!isSpaceChar(c));
        		    		return res * sgn;
        		    	}
     
        		    	private static long nextLong() {
        		    		int c = read();
        		    		while (isSpaceChar(c))
        		    			c = read();
        		    		int sgn = 1;
        		    		if (c == '-') {
        		    			sgn = -1;
        		    			c = read();
        		    		}
        		    		long res = 0;
        		    		do {
        		    			if (c < '0' || c > '9')
        		    				throw new InputMismatchException();
        		    			res *= 10;
        		    			res += c - '0';
        		    			c = read();
        		    		} while (!isSpaceChar(c));
        		    		return res * sgn;
        		    	}
     
        		    	private static String nextToken() {
        		    		int c = read();
        		    		while (isSpaceChar(c))
        		    			c = read();
        		    		StringBuilder res = new StringBuilder();
        		    		do {
        		    			res.appendCodePoint(c);
        		    			c = read();
        		    		} while (!isSpaceChar(c));
        		    		return res.toString();
        		    	}
     
        		    	private static String nextLine() {
        		    		int c = read();
        		    		while (isSpaceChar(c))
        		    			c = read();
        		    		StringBuilder res = new StringBuilder();
        		    		do {
        		    			res.appendCodePoint(c);
        		    			c = read();
        		    		} while (!isEndOfLine(c));
        		    		return res.toString();
        		    	}
     
        		    	private static int[] nextIntArray(int n) {
        		    		int[] arr = new int[n];
        		    		for (int i = 0; i < n; i++) {
        		    			arr[i] = nextInt();
        		    		}
        		    		return arr;
        		    	}
     
        		    	private static int[][] next2dArray(int n, int m) {
        		    		int[][] arr = new int[n][m];
        		    		for (int i = 0; i < n; i++) {
        		    			for (int j = 0; j < m; j++) {
        		    				arr[i][j] = nextInt();
        		    			}
        		    		}
        		    		return arr;
        		    	}
        		    	private static char[][] nextCharArray(int n,int m){
        		    		char [][]c=new char[n][m];
        		    		for(int i=0;i<n;i++){
        		    			String s=nextLine();
        		    			for(int j=0;j<s.length();j++){
        		    				c[i][j]=s.charAt(j);
        		    			}
        		    		}
        		    		return c;
        		    	}
     
        		    	private static long[] nextLongArray(int n) {
        		    		long[] arr = new long[n];
        		    		for (int i = 0; i < n; i++) {
        		    			arr[i] = nextLong();
        		    		}
        		    		return arr;
        		    	}
     
        		    	private static void pArray(int[] arr) {
        		    		for (int i = 0; i < arr.length; i++) {
        		    			pw.print(arr[i] + " ");
        		    		}
        		    		pw.println();
        		    		return;
        		    	}
     
        		    	private static void pArray(long[] arr) {
        		    		for (int i = 0; i < arr.length; i++) {
        		    			pw.print(arr[i] + " ");
        		    		}
        		    		pw.println();
        		    		return;
        		    	}
     
        		    	private static void pArray(boolean[] arr) {
        		    		for (int i = 0; i < arr.length; i++) {
        		    			pw.print(arr[i] + " ");
        		    		}
        		    		pw.println();
        		    		return;
        		    	}
     
        		    	private static boolean isSpaceChar(int c) {
        		    		if (filter != null)
        		    			return filter.isSpaceChar(c);
        		    		return isWhitespace(c);
        		    	}
     
        		    	private interface SpaceCharFilter {
        		    		public boolean isSpaceChar(int ch);
        		    	}
     
     
    }
        		    
        		    class nodi{
        		    	int a;
        		    	int b;
        		    }
        		    
        		    class MyComp2 implements Comparator<nodi>{
        		        
        		    	@Override
        		    	public int compare(nodi o1, nodi o2) {
        		    		if(o1.b>o2.b){
        		    			return 1;
        		    		}else if(o1.b<o2.b){
        		    			return -1;
        		    		}else{
        		    			return 0;
        		    			
        		    			
        		    		}
        		    		
        		    		
        		    	}
        		    }
        		    
        		    class node{
        		    	int i;
        		    	int a;
        		    	int b;
        		    }
        		    
        		    class MyComp implements Comparator<node>{
        		        
        		    	@Override
        		    	public int compare(node o1, node o2) {
        		    		if(o1.a>o2.a){
        		    			return 1;
        		    		}else if(o1.a<o2.a){
        		    			return -1;
        		    		}else{
        		    			return 1;	
        		    		}
        		    		
        		    		
        		    	}
        		    }
        		    
        		    class Node{
        		    	int to;
        		    	long dist;
        		    	Node(int to,long dist){
        		    		this.to=to;
        		    		this.dist=dist;
        		    	}
        		    	
        		    }
        		  
        		    class Pair implements Comparable<Pair>{

        		        long a;
        		        long b;
        		        
        			Pair (long a,long b){
        				this.a = a;
        				this.b = b;
        			}

        			public int compareTo(Pair o) {
        		            return Long.compare(this.b,o.b);
        				//return 0;
        			}

        		            public boolean equals(Object o) {
        		            if (o instanceof Pair) {
        		                Pair p = (Pair)o;
        		                return p.a == a && p.b == b;
        		            }
        		            return false;
        		        }

        		        @Override
        		        public String toString() {
        		            return a+" " + b;
        		        }
        		        
        		    } 
        		    
        		    
        		    class Dsu{
	    		    	private int rank[], parent[] ,n;
	    		    	private static int[] parent1;
	    		    	Dsu(int size){
	    		    		this.n=size+1;
	    		    		rank=new int[n];
	    		    		//parent=new int[n];
	    		    		parent=new int[n];
	    		    	makeSet();
	    		
	    		    	}
	    		    	
	    		    	void makeSet(){
	    		    		for(int i=0;i<n;i++){
	    		    			parent[i]=i;
	    		    		}
	    		    	}
	    		    	
	    		    	int find(int x){
	    		    		if(parent[x]!=x){
	    		    			
	    		    			parent[x]=find(parent[x]);
	    		    		}
	    		    		return parent[x];
	    		    	}
	    		    
	    		    	
	    		    	boolean union(int x,int y){
	    		    		int xRoot=find(x);
	    		    		int yRoot=find(y);
	    		    		
	    		    		if(xRoot==yRoot)
	    		    			return false;
	    		    		if(rank[xRoot]<rank[yRoot]){
	    		    		parent[xRoot]=yRoot;	
	    		    		}else if(rank[yRoot]<rank[xRoot]){
	    		    			parent[yRoot]=xRoot;
	    		    		}else{
	    		    			parent[yRoot]=xRoot;
	    		    			rank[xRoot]++;
	    		    		}
	    		    		return true;
	    		    	}

	    		     
	    		    }
  
