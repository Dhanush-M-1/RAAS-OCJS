import java.util.*;
import java.io.*;


public class Main implements Runnable {
	int[][] a;
        int[][] b;
        
        int[][] ret;
        boolean[][] was;
        int n;
	public void solve() throws IOException {
		n = nextInt();
                
                a = new int[n][3];
                b = new int[n][3];
                ret = new int[n][3];
                was = new boolean[n][3];
                for(int i = 0; i < n; i++){
                    int x = nextInt();
                    int y = nextInt();
                    a[i][0] = x - y;
                    b[i][0] = x;
                    a[i][1] = x;
                    b[i][1] = x;
                    a[i][2] = x;
                    b[i][2] = x + y;
                }
                out.println(doitDP(1, 0) + 1);
                
	}
        
        private boolean good(int i, int last, int now, int cur){
            return b[i][last] < a[now][cur];
        }
        private int doitDP(int i, int last){
            if(i == n) return 0;
            if(was[i][last]) return ret[i][last];
            was[i][last] = true;
            int now = 0;
            
            for(int cur = 0; cur < 3; cur++){
                if(good(i-1, last, i, cur)){
                    int n = doitDP(i + 1, cur);
                    if(cur != 1) n++;
                    now = Math.max(now, n);
                }
            }
            
            ret[i][last] = now;
            return ret[i][last];
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