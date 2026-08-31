/*
     * Code Author: Akshay Miterani
     * DA-IICT
     */
    import java.io.*;
    import java.util.*;
     
     
    public class ContestMode1 {
     
    	static double eps=(double)1e-6;
    	static long mod=(int)1e9+7;
    	public static void main(String args[]){
    		InputReader in = new InputReader(System.in);
    		OutputStream outputStream = System.out;
    		PrintWriter out = new PrintWriter(outputStream);
    		//----------My Code Starts Here----------
	    	int n=in.nextInt();
	    	int m=in.nextInt();
	    	boolean v[]=new boolean[m+1];
	    	for(int i=0;i<n;i++){
	    		int x=in.nextInt();
	    		for(int j=0;j<x;j++){
	    			int b=in.nextInt();
	    			v[b]=true;
	    		}
	    	}
	    	boolean f=true;
	    	for(int i=1;i<=m;i++){
	    		if(!v[i])
	    			f=false;
	    	}
	    	if(f){
	    		out.println("YES");
	    	}
	    	else{
	    		out.println("NO");
	    	}
    		out.close();
    		//---------------The End------------------
    	}
    	static long gcd(long x, long y)
        {
            long r=0, a, b;
            a = (x > y) ? x : y; // a is greater number
            b = (x < y) ? x : y; // b is smaller number
            r = b;
            while(a % b != 0)
            {
                r = a % b;
                a = b;
                b = r;
            }
            return r;
        }
    	static class Pair implements Comparable<Pair>{
    		long x;
    		long y;
    		int i;
    		Pair(long xx,long yy){
    			x=xx;
    			y=yy;
    		}
    		@Override
    		public int compareTo(Pair o) {
    			if(this.y==o.y)
					return Long.compare((this.x),(o.x));
				else
					return Long.compare((this.y),(o.y));
    		}
    	}
    	
    	static class InputReader {
    	    public BufferedReader reader;
    	    public StringTokenizer tokenizer;
     
    	    public InputReader(InputStream inputstream) {
    	      reader = new BufferedReader(new InputStreamReader(inputstream));
    	      tokenizer = null;
    	    }
    	    
    	    public String nextLine(){
    	    	String fullLine=null;
    	    	while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    	            try {
    	              fullLine=reader.readLine();
    	            } catch (IOException e) {
    	              throw new RuntimeException(e);
    	            }
    	            return fullLine;
    	          }
    	          return fullLine;
    	    }
    		public String next() {
    	      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    	        try {
    	          tokenizer = new StringTokenizer(reader.readLine());
    	        } catch (IOException e) {
    	          throw new RuntimeException(e);
    	        }
    	      }
    	      return tokenizer.nextToken();
    	    }
    		public long nextLong() {
    		      return Long.parseLong(next());
    		    }
    	    public int nextInt() {
    	      return Integer.parseInt(next());
    	    }
    	  }
    } 