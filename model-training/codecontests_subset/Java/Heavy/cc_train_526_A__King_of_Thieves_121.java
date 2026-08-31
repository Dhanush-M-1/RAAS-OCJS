import java.util.*;
import java.io.*;


public class E implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt();
                char[] c = nextToken().toCharArray();
                
                for(int i1 = 0; i1 < c.length; i1++){
                    for(int i2 = i1 + 1; i2 < c.length; i2++){
                        int  k = i2 - i1;
                        int cnt = 0;
                        for(int i = i1; i < c.length; i += k){
                            if(c[i] != '*') break;
                            else{
                                cnt++;
                                if(cnt == 5) break;
                            }
                        }
                        
                        if(cnt == 5){
                            out.println("yes");
                            return;
                        }
                    }
                }
                out.println("no");
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new E().run();
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