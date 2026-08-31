import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class B {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
    public void dfs(int[] A, boolean[] marked, int cur, ArrayList<Integer> list){
    	if( marked[cur] ) return;
    	if( A[cur] != 0 ){    		
    		dfs(A, marked, A[cur], list);
    	}    		    	
    	marked[cur] = true;
    	list.add(cur);
    }
    
	public void solve() throws IOException {				
		int N = nextInt();
		int X = nextInt();
		int[] A = new int[N+1];
		for(int i = 1; i <= N; i++)
			A[i] = nextInt();
		
		ArrayList<Integer> sortedt = new ArrayList<Integer>();
		boolean[] marked = new boolean[N+1];
		for(int i = 1; i <= N; i++){
			dfs(A, marked, i, sortedt);
		}
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		for(int i = sortedt.size()-1; i >= 0; i--){
			sorted.add( sortedt.get(i) );
		}		
//		for(int s: sorted){
//			out.println( s);
//		}
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		marked = new boolean[N+1];
		int rank = -1;
		for(int i: sorted){
			if( marked[i] ) continue;
			
			boolean isX = false;
			int cur = i;
			int size = 1;
			marked[cur] = true;			
			if( cur == X ){
				rank = size;
				isX = true;
			}
			while( A[cur] != 0){
				size++;
				cur = A[cur];
				marked[cur] = true;
				
				if( cur == X ){
					rank = size;
					isX = true;
				}
			}
			
			if(!isX)
				set.add( size );
			else
				rank = size-rank+1;
		}
//		for(int s: set){
//			out.println( s);
//		}
//		if(true)return;
		
		boolean[] dp = new boolean[N+1];
		dp[0] = true; 
		for(int j = 0; j < set.size(); j++){
			for(int i = N; i >= 0; i--){
				if( dp[i] ){
					dp[i + set.get(j) ] = true;
				}
			}
		}
		
		for(int i = 0; i <= N; i++){
			if( dp[i] ){
				out.println( i + rank);
			}
		}
		
		
//		out.println("rank: " + rank);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new B().run();
	}
	
	public void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            out = new PrintWriter(System.out);
            solve();
            reader.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

}
