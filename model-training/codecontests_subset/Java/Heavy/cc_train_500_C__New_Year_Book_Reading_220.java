import java.util.*;
import java.io.*;

public class C implements Runnable {
		
	public void solve() throws IOException {
		int N = nextInt(); int M = nextInt();
                int[] weight = new int[N];
                for(int i = 0; i < N; i++) weight[i] = nextInt();
                
                int[] order = new int[M];
                for(int i = 0; i < M; i++) order[i] = nextInt() - 1;
                
                long cost = 0;
                LinkedList<Integer> books = new LinkedList<Integer>();
                for(int i = 0; i < M; i++){
                    int index = books.indexOf(order[i]);
                    if(index == -1){
                        for(int k : books) cost += weight[k];
                    }
                    else{
                        for(int k = 0; k < index; k++) cost += weight[books.get(k)];
                        books.remove(index);
                    }
                    books.addFirst(order[i]);
                }
                
                out.println(cost);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------------------------------------
	public static void main(String[] args) {
		new C().run();
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