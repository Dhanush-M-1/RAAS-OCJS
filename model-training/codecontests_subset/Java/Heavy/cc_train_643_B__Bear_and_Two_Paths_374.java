	import java.io.*;
	import java.lang.reflect.Array;
	import java.math.BigInteger;
	import java.util.*;
	 
	 
	
	
	
	import java.io.*;
	import java.lang.reflect.Array;
	import java.math.BigInteger;
	import java.util.*;
	 
	 
	public class q5 {
	
		static TreeSet<Integer> set1,set2;
		static ArrayList<Integer>[] gph;
		static int[] vis;
		static void dfs(int i, int set) {
			vis[i]=1;
			if(set==1) set1.add(i);
			else set2.add(i);
			for(int j:gph[i]) {
				if(vis[j]==0) {
					if(set==1) dfs(j,2);
					else dfs(j,1);
				}
			}
		}
		
		public static void main(String[] args) throws IOException {
			
	 		Reader.init(System.in);
	 		PrintWriter out=new PrintWriter(System.out);
			int n=Reader.nextInt(),k=Reader.nextInt();
			int a=Reader.nextInt(),b=Reader.nextInt(),c=Reader.nextInt(),d=Reader.nextInt();
			if(n==4 || k<n+1) out.println(-1);
			else {
				ArrayList<Integer> arr=new ArrayList<Integer>();
				for(int i=1;i<=n;i++) {
					if(i!=a && i!=b && i!=c && i!=d) arr.add(i);
					
				}
				out.print(a+" "+c+" ");
				for(int i:arr) out.print(i+" ");
				out.println(d+" "+b);

				out.print(c+" "+a+" ");
				for(int i:arr) out.print(i+" ");
				out.println(b+" "+d);
				
			}
			out.flush();
		}
	}
	
	
	class Reader {
	    static BufferedReader reader;
	    static StringTokenizer tokenizer;
	    /** call this method to initialize reader for InputStream */
	    static void init() throws IOException {
	    	 reader = new BufferedReader(
	                 new FileReader("input.txt"));
	    tokenizer = new StringTokenizer("");
	    }
	    static void init(InputStream input) {
	        reader = new BufferedReader(
	                     new InputStreamReader(input) );
	        tokenizer = new StringTokenizer("");
	    }
	    /** get next word */
	    static String nextLine() throws IOException{
	    	return reader.readLine();
	    }
	    static String next() throws IOException {
	        while ( ! tokenizer.hasMoreTokens() ) {
	            //TODO add check for eof if necessary
	            tokenizer = new StringTokenizer(
	                   reader.readLine() );
	        }
	        return tokenizer.nextToken();
	    }
	    static int nextInt() throws IOException {
	        return Integer.parseInt( next() );
	    }
	    static long nextLong() throws IOException {
	        return Long.parseLong( next() );
	    }
	    static double nextDouble() throws IOException {
	        return Double.parseDouble( next() );
	    }
	}