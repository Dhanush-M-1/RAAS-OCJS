import java.util.*;
import java.io.*;


public class Main implements Runnable {
        
        private int getParent(int x){
                if(p[x] == -1)
                        return x;
                else
                        return p[x] = getParent(p[x]);
        }
        
        private int get(int x){
                return (x + 1) / 2;
        }
        
        private void merge(int a, int b){
                a = getParent(a);
                b = getParent(b);
                if(a == b) return;
                p[b] = a;
                dia[a] = Math.max(Math.max(dia[a], dia[b]), get(dia[a]) + get(dia[b]) + 1);
        }
        
        private Result diameter(int x, int parent){
                p[x] = parent;
                Result res = new Result(x, 0);
                for(int i = 0; i < graph[x].size(); i++){
                        int child = graph[x].get(i);
                        if(child == parent) continue;
                        
                        Result now = diameter(child, x);
                        now.diam++;
                        if(now.diam > res.diam) res = now;
                }
                
                return res;
        }
        
        class Result{
                int farthest, diam;
                Result(int f, int d){
                        farthest = f;
                        diam = d;
                }
        }
        
        ArrayList<Integer>[] graph;
        int N, M, Q;
        int[] p, dia;
	public void solve() throws IOException {
               N = nextInt();
               M = nextInt();
               Q = nextInt();
               
               graph = new ArrayList[N];
               for(int i = 0; i < N; i++) graph[i] = new ArrayList<>();
               
               
               
               for(int i = 0;i < M; i++){
                       int u = nextInt() - 1;
                       int v = nextInt() - 1;
                       graph[u].add(v);
                       graph[v].add(u);
               }
               
               
               dia = new int[N];
               p = new int[N];
               for(int i = 0; i < N; i++) p[i] = -2;
               
               //get diameters
               for(int i = 0; i < N; i++){
                       if(p[i] == -2){
                               Result last = diameter(i, -1);
                               dia[last.farthest] = diameter(last.farthest, -1).diam;
                       }
                                
               }
               
               for(int i = 0; i < Q; i++){
                       int type = nextInt();
                       if(type == 1){
                               int x = nextInt() - 1;
                               out.println(dia[getParent(x)]);
                       }
                       else{
                               int u = nextInt() - 1;
                               int v = nextInt() - 1;
                               merge(u, v);
                       }
               }
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