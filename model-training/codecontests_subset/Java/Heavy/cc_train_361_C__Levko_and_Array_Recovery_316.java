import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;


public class A {	
	BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;
    
    long INF = Long.MAX_VALUE / 2;
	public void solve() throws IOException {				
		int N = nextInt();
		int M = nextInt();
		long[] max = new long[N];
		long[] add = new long[N];
		Arrays.fill(max, INF);
		int[][] queries = new int[M][];
		for(int i = 0; i < M; i++){
			queries[i] = new int[]{ nextInt(), nextInt()-1, nextInt()-1, nextInt() };
		}
		
		for(int i = 0; i < M; i++){
			int T = queries[i][0];
			int L = queries[i][1];
			int R = queries[i][2];
			int V = queries[i][3];
			if(T == 1){
				for(int j = L; j <= R; j++){
					add[j] += V;
				}
			}
			else{
				for(int j = L; j <= R; j++){
					max[j] = Math.min(max[j], V-add[j]);
				}
			}
		}
		
		Arrays.fill(add, 0);
		for(int i = 0; i < M; i++){
			int T = queries[i][0];
			int L = queries[i][1];
			int R = queries[i][2];
			int V = queries[i][3];
			
			if(T == 1){
				for(int j = L; j <= R; j++){
					add[j] += V;
				}
			}
			else{
				boolean OK = false;
				for(int j = L; j <= R; j++){
					if(V == max[j] + add[j]) OK = true;
				}
				if(!OK){
					out.println("NO");
					return;
				}
			}
		}
		
		out.println("YES");
		for(int i = 0; i < N; i++){
			out.print( max[i] == INF? 0: max[i] );
			out.print(" ");
		}
		out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new A().run();
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
