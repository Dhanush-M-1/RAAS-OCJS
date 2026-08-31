    import java.io.*;
    import java.util.*;
     
    public class Stones {
    	
    	static FastReader sc=new FastReader();
    	
    	public static final long MOD=1000000007;
    	
    	void run() {
    	    int t=sc.nextInt();
    	    
    	    while(t-->0){
    	        int a1=sc.nextInt();
    	        int b1=sc.nextInt();
    	        int c1=sc.nextInt();
    	        int stones1=0,stones2=0;
    	        int a2=a1,b2=b1,c2=c1;
    	        
    	            int na=b1/2;
    	            int ast=Math.min(a1,na);
    	            b1=b1-ast*2;
    	            stones1+=ast*2+ast;
    	            
    	            int  nb=c1/2;
    	            int bst=Math.min(b1,nb);
    	            stones1+=bst+bst*2;
    	            
    	            nb=c2/2;
    	            bst=Math.min(b2,nb);
    	            b2=b2-bst;
    	            stones2+=bst+bst*2;
    	            
    	            na=b2/2;
    	            ast=Math.min(a2,na);
    	            stones2+=ast*2+ast;
    	        
    	            System.out.println(Math.max(stones1,stones2));
    	    }
    	}
    	
    	public static void main(String args[]) throws IOException {
    		new Stones().run();
    	}
    	
    	static class FastReader 
        { 
            BufferedReader br; 
            StringTokenizer st; 
      
            public FastReader() 
            { 
                br = new BufferedReader(new
                         InputStreamReader(System.in)); 
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
        }
     
    }