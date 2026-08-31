import java.io.*;
import java.math.BigInteger;
import java.util.*;




public class Main {

	 static class FastReader 
	    { 
	        final private int BUFFER_SIZE = 1 << 16; 
	        private DataInputStream din; 
	        private byte[] buffer; 
	        private int bufferPointer, bytesRead; 
	  
	        public FastReader() 
	        { 
	            din = new DataInputStream(System.in); 
	            buffer = new byte[BUFFER_SIZE]; 
	            bufferPointer = bytesRead = 0; 
	        } 
	  
	        public FastReader(String file_name) throws IOException 
	        { 
	            din = new DataInputStream(new FileInputStream(file_name)); 
	            buffer = new byte[BUFFER_SIZE]; 
	            bufferPointer = bytesRead = 0; 
	        } 
	  
	        public String readLine() throws IOException 
	        { 
	            byte[] buf = new byte[64]; // line length 
	            int cnt = 0, c; 
	            while ((c = read()) != -1) 
	            { 
	                if (c == '\n') 
	                    break; 
	                buf[cnt++] = (byte) c; 
	            } 
	            return new String(buf, 0, cnt); 
	        } 
	  
	        public int nextInt() throws IOException 
	        { 
	            int ret = 0; 
	            byte c = read(); 
	            while (c <= ' ') 
	                c = read(); 
	            boolean neg = (c == '-'); 
	            if (neg) 
	                c = read(); 
	            do
	            { 
	                ret = ret * 10 + c - '0'; 
	            }  while ((c = read()) >= '0' && c <= '9'); 
	  
	            if (neg) 
	                return -ret; 
	            return ret; 
	        } 
	  
	        public long nextLong() throws IOException 
	        { 
	            long ret = 0; 
	            byte c = read(); 
	            while (c <= ' ') 
	                c = read(); 
	            boolean neg = (c == '-'); 
	            if (neg) 
	                c = read(); 
	            do { 
	                ret = ret * 10 + c - '0'; 
	            } 
	            while ((c = read()) >= '0' && c <= '9'); 
	            if (neg) 
	                return -ret; 
	            return ret; 
	        } 
	  
	        public double nextDouble() throws IOException 
	        { 
	            double ret = 0, div = 1; 
	            byte c = read(); 
	            while (c <= ' ') 
	                c = read(); 
	            boolean neg = (c == '-'); 
	            if (neg) 
	                c = read(); 
	  
	            do { 
	                ret = ret * 10 + c - '0'; 
	            } 
	            while ((c = read()) >= '0' && c <= '9'); 
	  
	            if (c == '.') 
	            { 
	                while ((c = read()) >= '0' && c <= '9') 
	                { 
	                    ret += (c - '0') / (div *= 10); 
	                } 
	            } 
	  
	            if (neg) 
	                return -ret; 
	            return ret; 
	        } 
	  
	        private void fillBuffer() throws IOException 
	        { 
	            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
	            if (bytesRead == -1) 
	                buffer[0] = -1; 
	        } 
	  
	        private byte read() throws IOException 
	        { 
	            if (bufferPointer == bytesRead) 
	                fillBuffer(); 
	            return buffer[bufferPointer++]; 
	        } 
	  
	        public void close() throws IOException 
	        { 
	            if (din == null) 
	                return; 
	            din.close(); 
	        } 
	    } 
	
		public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	 
		public static long mod = 998244353;
		public static long[] fac;
		public static int N = (int) 1e5;
		public static long[] dp;
		public static List<Integer>[] edges;
		public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FastReader sc = new FastReader();
		
		 int n = sc.nextInt();
	     int m = sc.nextInt();
	     List<Integer>[] edges = new ArrayList[n+1];
	     for(int i=0;i<=n;++i) edges[i] = new ArrayList<>();
	     for(int i=1;i<=m;++i) {
	    	 int u = sc.nextInt();
	    	 int v = sc.nextInt();
	    	 edges[u].add(v);
	    	 edges[v].add(u);
	     }
	     DSU dsu = new DSU(n+1);
	     // to enhance
	     for(int i=1;i<=n;++i) Collections.sort(edges[i]);
	     
	     TreeSet<Integer> allComp = new TreeSet<>(); //contain one element from each comp
	     
	     for(int i=1;i<=n;++i) {
	    	 Map<Integer,Integer> map = new HashMap<>();
	    	 
	    	 for(int node : edges[i]) {
	    		 /*
	    		  * till now comp. are made from nodes 
	    		  * less than i so there is no use of 
	    		  * node having value greater than i
	    		  */
	    		 if(node >= i) break;
	    		 int root = dsu.findRoot(node);
	    		 /*
	    		  * storing the number of node present in some white comp
	    		  * but connected to i with a black edge
	    		  */
	    		 map.put(root,map.getOrDefault(root,0)+1);
	    	 }
	    	 
	    	 List<Integer> list = new ArrayList<>();
	    	 
	    	 for(int node : allComp) {
	    		 int root = dsu.findRoot(node);
	    		 /*
	    		  * iterating over all comps 
	    		  * if we find any comp having at least one node 
	    		  * which are connected to i by a white edge
	    		  * then we can merge i to that comp
	    		  */
	    		 if(dsu.size[root] > map.getOrDefault(root,0)) {
	    			 dsu.unite(i, root);
	    			 list.add(node);
	    		 }
	    	 }
	    	 /*
	    	  * as now i is merged into diff comp
	    	  * so we delete the elements of that comp
	    	  * and insert i in place of them 
	    	  */
	    	 for(int x : list) allComp.remove(x);
	    	 allComp.add(i);
	     }
	     
	     
	     List<Integer> set = new ArrayList<>();
	     
	     out.println(allComp.size());
	     for(int x : allComp) set.add(dsu.size[dsu.findRoot(x)]);
	     Collections.sort(set);
	     for(int x : set) out.print(x+" ");
	     
	     
	     out.close();
	     
		}
		 static class DSU {
		        int n;
		        int[] parent, size;

		        public DSU(int v) {
		            n = v;
		            parent = new int[n];
		            size = new int[n];
		            for(int i = 0; i < n; i++) {
		                parent[i] = i;
		                size[i] = 1;
		            }
		        }

		        public int findRoot(int curr) {
		            if(curr == parent[curr]) return curr;
		            return parent[curr] = findRoot(parent[curr]);
		        }

		        public boolean unite(int a, int b) {
		            int rootA = findRoot(a);
		            int rootB = findRoot(b);
		            if(rootA == rootB) return true;
		            if(size[rootA] > size[rootB]) {
		                parent[rootB] = rootA;
		                size[rootA] += size[rootB];
		            }
		            else {
		                parent[rootA] = rootB;
		                size[rootB] += size[rootA];
		            }
		            return false;
		        }
		 }
}