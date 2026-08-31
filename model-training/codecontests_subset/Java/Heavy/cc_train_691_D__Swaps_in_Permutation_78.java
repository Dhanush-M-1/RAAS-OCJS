import java.io.*;
import java.util.*;

public class Main { 
    
    static ArrayList<Integer>[] grp;
    static boolean[] vis;
    static ArrayList<Integer> ind;
    static ArrayList<Integer> val;
    static int[] pos;
    
    public static void main(String[] args) throws java.lang.Exception { 
        
        InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader pm = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
        
        int t = 1;
        while(t-- > 0){
            int n = pm.nextInt();
            int m = pm.nextInt();
            
            grp = new ArrayList[n];
            vis = new boolean[n];
            int[] ans = new int[n];
            
            pos = new int[n];
                
            for(int i=0;i<n;i++){
                pos[i]= pm.nextInt();
                grp[i] = new ArrayList<Integer>();
            }
            int s=0,d=0;
            while(m-- > 0){
                s = pm.nextInt()-1;
                d= pm.nextInt()-1;
                grp[s].add(d);
                grp[d].add(s);
            }
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    ind= new ArrayList<Integer>();
                    val= new ArrayList<Integer>();
                    //val.clear();
                    
                    dfs(i);
                    Collections.sort(ind);
                    
                    // for(int j=0;j<ind.size();j++){
                    //     val.add(hm.get(ind.get(j)));
                        
                    // }
                    Collections.sort(val);
                    Collections.reverse(val);
                    
                    for(int j=0;j<ind.size();j++){
                        // in = ind.get(j);
                        ans[ind.get(j)] = val.get(j);
                    }
                }
            }
            for(int i=0;i<n;i++)
                out.print(ans[i]+" ");
            
            out.close();
        }
        //end of tests
        
    }
    //end of main class
    static void dfs(int u){
        vis[u] = true;
        ind.add(u);
        val.add(pos[u]);
        for(Integer i:grp[u]){
            if(!vis[i])
                dfs(i);
        }
    }
    
    static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;
 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
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
 
	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	    
	    public long nextLong()
	    {
	    	return Long.parseLong(next());
	    }
 
	}
    
}    