import java.util.*;
import java.io.*;

public class Main implements Runnable {
    int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    
    private long convertId(int x, int y){
        return ((long)x << 32) + y;
    }
    Map<Long, Integer> dist;
        
    public void solve() throws IOException {
		dist =  new TreeMap<>();
                int x1 = nextInt();
                int y1 = nextInt();
                int x2 = nextInt();
                int y2 = nextInt();
                
                int M = nextInt();
                for(int i = 0; i < M; i++){
                    int r = nextInt();
                    int a = nextInt();
                    int b = nextInt();
                    for(int k = a; k <= b; k++){
                        dist.put(convertId(r, k), -1);
                    }
                }
                
                
               Queue<Integer>  q  = new LinkedList<>();
               q.add(x1);
               q.add(y1);
               dist.put(convertId(x1, y1), 0);
               while(!q.isEmpty()){ // BFS
                   int nowx = q.poll();
                   int nowy = q.poll();
                   int nowd = dist.get(convertId(nowx, nowy));
               //System.out.println(nowx + "  "+ nowy + " " + nowd);
                   for(int k = 0; k < 8; k++){
                       int tx = nowx + dx[k];
                       int ty = nowy + dy[k];
                       if(dist.containsKey(convertId(tx, ty)) && dist.get(convertId(tx, ty)) == -1){
                           dist.put(convertId(tx, ty), nowd + 1);
                           q.add(tx);
                           q.add(ty);
                       }
                   }
               }
               
               
               
    
               System.out.println(dist.get(convertId(x2, y2)));
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