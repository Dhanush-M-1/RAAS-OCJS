	// Main Code at the Bottom
	import java.util.*;
	import java.io.*; 
	public class Main{
		//Fast IO class
	    static class FastReader {
	        BufferedReader br; 
	        StringTokenizer st; 
	        public FastReader() {
	        	boolean env=System.getProperty("ONLINE_JUDGE") != null;
	        	if(!env) {
	        		try {
						br=new BufferedReader(new FileReader("src\\input.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
	        	}
	        	else br = new BufferedReader(new InputStreamReader(System.in)); 
	        } 
	        String next() {
	            while (st == null || !st.hasMoreElements()) {
	                try {
	                    st = new StringTokenizer(br.readLine()); 
	                } 
	                catch (IOException  e) {
	                    e.printStackTrace(); 
	                } 
	            } 
	            return st.nextToken(); 
	        } 
	        int nextInt() {
	            return Integer.parseInt(next()); 
	        } 
	        long nextLong() {
	            return Long.parseLong(next()); 
	        } 
	        double nextDouble() {
	            return Double.parseDouble(next()); 
	        } 
	        String nextLine() {
	            String str = ""; 
	            try {
	                str = br.readLine(); 
	            } 
	            catch (IOException e) {
	                e.printStackTrace(); 
	            } 
	            return str; 
	        } 
	    }     
	    static long MOD=(long)1e9+7;
	    //debug
	    static void debug(Object... o) {
	        System.out.println(Arrays.deepToString(o));
	    }
	    // Pair
	    static class pair{
	    	long x,y;
	    	pair(long a,long b){
	    		this.x=a;
	    		this.y=b;
	    	}
	    	public boolean equals(Object obj) {
	    		if(obj == null || obj.getClass()!= this.getClass()) return false;
	            pair p = (pair) obj;
	            return (this.x==p.x && this.y==p.y);
	        }
	    	public int hashCode() {
	            return Objects.hash(x,y);
	        }
	    }
	    static FastReader sc=new FastReader();
	    static PrintWriter out=new PrintWriter(System.out);  
	    //Global variables and functions
	    static long exp(long a,long b) {
	    	if(b==0) return 1;
	    	if(b%2==0) return exp((a*a)%MOD,b/2)%MOD;
	    	return ((a%MOD)*exp((a*a)%MOD,b/2))%MOD;
	    }
	    static int parent[];
	    static void init(int n) {
	    	parent=new int[n];
	    	Arrays.fill(parent, -1);
	    }
	    static int find(int x) {
	    	if(parent[x]<0) return x;
	    	return parent[x]=find(parent[x]);
	    }
	    static boolean union(int x,int y) {
	    	x=find(x);
	    	y=find(y);
	    	if(x==y) return false;
	    	parent[x]+=parent[y];
	    	parent[y]=x;
	    	return true;
	    }
	    //Main function(The main code starts from here)
	    public static void main (String[] args) throws java.lang.Exception {
	    	int test=1;
	    	//test=sc.nextInt();
	    	while(test-->0) {
	    		int n=sc.nextInt(),m=sc.nextInt();
	    		init(m+1);
	    		ArrayList<Integer> ans=new ArrayList<>();
	    		for(int i=0;i<n;i++) {
	    			int k=sc.nextInt();
	    			if(union(sc.nextInt()-1,(k==1?m:sc.nextInt()-1))) ans.add(i+1);
	    		}
	    		long s=exp(2,ans.size());
	    		out.println(s+" "+ans.size());
	    		for(Integer x: ans) out.print(x+" ");
	    	}	
	        out.flush();
	        out.close();
	    }
	}