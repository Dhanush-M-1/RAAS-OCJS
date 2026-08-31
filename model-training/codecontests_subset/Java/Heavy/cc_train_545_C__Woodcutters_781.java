import java.util.*;
import java.io.*;


public class Main implements Runnable {
		
	public void solve() throws IOException {
		int n = nextInt();
                int[] x = new int[n];
                int[] h = new int[n];
                for(int i = 0; i < n; i++){
                    x[i] = nextInt();
                    h[i] = nextInt();
                }
                
                int answer = 0;
               int last = Integer.MIN_VALUE;
               for(int i = 0; i < n; i++){
                   if(last < x[i] - h[i]){
                       answer++;
                       last = x[i];
                   }
                   else if(i+1 == n || x[i] + h[i] < x[i+1]){
                       answer++;
                       last = x[i] + h[i];
                   }
                   else
                       last = x[i];
               }
                
                out.println(answer);
                
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
	}

        public void debug(Object... arr){
            System.out.println(Arrays.deepToString(arr));
        }

        public void print1Int(int[] a){
                for(int i = 0; i < a.length; i++)
                        System.out.print(a[i] + " ");
                System.out.println();
        }
        
        public void print2Int(int[][] a){
                for(int i = 0; i < a.length; i++){
                        for(int j = 0; j < a[0].length; j++){
                                System.out.print(a[i][j] + " ");
                        }
                        System.out.println();
                }
        }
        
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
                        out = new PrintWriter(System.out);
			tok = null;
			solve();
			in.close();
                        out.close();
		} catch (IOException e) {
			System.exit(0);
		}
	}

	public String nextToken() throws IOException {
		while (tok == null || !tok.hasMoreTokens()) {
			tok = new StringTokenizer(in.readLine());
		}
		return tok.nextToken();
	}

	public int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	public long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	public double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}
        PrintWriter out;
	BufferedReader in;
	StringTokenizer tok;
}