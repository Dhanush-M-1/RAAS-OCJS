import java.util.*;
import java.io.*;

public class Main implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt();
                int me = nextInt() - 1;
                
                int[] a = new int[N];
                for(int i = 0; i < N; i++) a[i] = nextInt() - 1;
                
                boolean[] tail = new boolean[N];
                Arrays.fill(tail, true);
                for(int i = 0; i < N; i++) if(a[i] >= 0)  tail[a[i]] = false;
                
                boolean[] possible = new boolean[N + 1];
                possible[0] = true;
                
                for(int i = 0; i < N; i++)
                        if(tail[i]){
                                int at = i;
                                int len = 0;
                                boolean myq = false;
                                while(at >= 0){
                                        if(at == me) myq = true;
                                        len++;
                                        at = a[at];
                                }
                                
                                if(!myq){
                                        for(int k = N - len; k >= 0; k--){
                                                if(possible[k]){
                                                        possible[k + len] = true;
                                                }
                                        }
                                }
                                
                        }
                
                
                int myOffsetinq = 0;
                while(me >= 0){
                        myOffsetinq ++;
                        me = a[me];
                }
                
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < N; i++){
                        if(possible[i]){
                                sb.append(i +  myOffsetinq);
                                sb.append("\n");
                        }
                }
                
                System.out.print(sb.toString());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			tok = null;
			solve();
			in.close();
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

	BufferedReader in;
	StringTokenizer tok;
}