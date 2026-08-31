import java.util.*;
		import java.io.*;
		 public class Main {
			public static boolean visited[]; 
			public static Integer distances[];
				
		    public static void main ( String args[] ) throws IOException {
		    	FastReader sc = new FastReader();
		    	int n = sc.nextInt(); 
		    	int positions[] = new int [n]; 
		    	int heights[] = new int [n]; 
		    	
		    	for(int i = 0 ; i <n;i++) {positions[i] = sc.nextInt() ; heights[i]= sc.nextInt(); }
		    	int count = n>1?2:1;
		    	for(int i = 1 ; i<n-1 ; i++) {
		    		if(positions[i]-heights[i]>positions[i-1])
		    			count++; 
		    		else if (positions[i]+heights[i]<positions[i+1]){
		    				count++; 
		    				positions[i]+=heights[i]; 
		    	}
		    	}
		    		System.out.println(count); 
		    	
		    }
		    public static int gcdExtended(int a, int b, int x, int y) 
		    { 
		        // Base Case 
		        if (a == 0) 
		        { 
		            x = 0; 
		            y = 1; 
		            return b; 
		        } 
		  
		        int x1=1, y1=1; // To store results of recursive call 
		        int gcd = gcdExtended(b%a, a, x1, y1); 		        // call 
		        x = y1 - (b/a) * x1; 
		        y = x1; 
		  
		        return gcd; 
		    }
		    			
		    	
		     static class Graph
		    {
		        public int V;  
		        public LinkedList<Integer> adj[];
 		        Graph(int v)
		        {
		            V = v;
		            visited = new boolean[v+1]; 
		            distances = new Integer[v+1]; 
		            for(int i = 0 ; i <v+1 ; i++)
		            	distances[i] = -1  ;
		            adj = new LinkedList[v+1];
		            for (int i=0; i<v+1; ++i)
		                adj[i] = new LinkedList<Integer>();
		        }
		        void addEdge(int v, int w)
		        {
		            adj[v].add(w); 
		        }
		        void dfs(int node) {
		        	visited[node]= true; 
		        	System.out.print(node+" ");
		        	for(int x :adj[node]) {
		        		if(!visited[x])
		        			dfs(x); 
		        	}
		        	
		        }
		        void bfs(int node){
		            Queue<Integer> q = new LinkedList<Integer>();   ;
		            distances[node]= 0 ;
		            q.add(node);
		            while(!q.isEmpty()){
		                int src = q.peek();
		                System.out.print(src+" ");
		                q.remove();
		                int cost = distances[src];
		                for(int child : adj[src]){
		                    if(distances[child]==-1){
		                        q.add(child);
		                        distances[child]= cost+1;
		                    }
		                }
		            }
		        }
		        public  int graph_height(int node) {
		        	int h = 0 ; 
		        	for(int x : adj[node])
		        		h= Math.max(h,1+graph_height(x));
		  
		        return h ; 
		          
		    }
		    }
		     
		    static class FastReader
			{
				BufferedReader br;
				StringTokenizer st;
 
				public FastReader() {
					  
					   br = new BufferedReader(new InputStreamReader(System.in));
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
				public boolean ready() throws IOException {
					return br.ready();
				}
		}
		 }
		  class Pair {
			int x ;
			int y ;
			public Pair(int x ,int y){
				this.x = x;
				this.y=y;}
		}
 
		  class Pair1 implements Comparable{
			int x ;
			int y ;
			public Pair1(int x ,int y){
				this.x = x;
				this.y=y;}
			public int compareTo(Object o) {
				Pair1 a = (Pair1) o ;
 
				return (this.x-a.x);
			}
 
			}
		 class Pair2 implements Comparable{
			int x ;
			int y ;
			public Pair2(int x ,int y){
				this.x = x;
				this.y=y;}
			public int compareTo(Object o) {
				Pair2 a = (Pair2) o ;
 
				return (this.y-a.y);
			}
		 }
		 
		 
