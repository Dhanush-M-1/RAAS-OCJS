import java.io.*;
import java.util.*;
import java.math.*;
import java.awt.Point;
 
public class Main {
	static final long MOD = 998244353L;
	//static final long INF = -1000000000000000007L;
	//static final long MOD = 1000000007L;
	//static final int INF = 1000000007;
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter pw = new PrintWriter(System.out);
		int Q = sc.ni();
		for (int q = 0; q < Q; q++) {
			int N = sc.ni();
			int M = sc.ni();
			int A = sc.ni()-1;
			int B = sc.ni()-1;
			ArrayList<Integer>[] graph = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				graph[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < M; i++) {
				int n1 = sc.ni()-1;
				int n2 = sc.ni()-1;
				graph[n1].add(n2);
				graph[n2].add(n1);
			}
			
			boolean[] visitedB = new boolean[N];
			//Effectively remove node A from the graph. See which nodes don't connect to B.
			visitedB[B] = true;
			ArrayDeque<Integer> bfs = new ArrayDeque<Integer>();
			bfs.add(B);
			while (! bfs.isEmpty()) {
				int node = bfs.pollFirst();
				for (int neighbor: graph[node]) {
					if (neighbor != A && !visitedB[neighbor]) {
						visitedB[neighbor] = true;
						bfs.add(neighbor);
					}
				}
			}
			int notVisB = 0;
			for (int i = 0; i < N; i++) {
				if (i!=A && !visitedB[i]) {
					notVisB++;
				}
			}
			
			
			
			boolean[] visitedA = new boolean[N];
			//Effectively remove node B from the graph. See which nodes don't connect to A.
			visitedA[A] = true;
			//bfs is already empty
			bfs.add(A);
			while (! bfs.isEmpty()) {
				int node = bfs.pollFirst();
				for (int neighbor: graph[node]) {
					if (neighbor != B && !visitedA[neighbor]) {
						visitedA[neighbor] = true;
						bfs.add(neighbor);
					}
				}
			}
			int notVisA = 0;
			for (int i = 0; i < N; i++) {
				if (i!=B && !visitedA[i]) {
					notVisA++;
				}
			}
			
			long ans = (notVisA+0L)*notVisB;
			pw.println(ans);
		}
		pw.close();
	}
	
    public static int[][] sort(int[][] array) {
    	//Sort an array (immune to quicksort TLE)
		Random rgen = new Random();
		for (int i = 0; i < array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int[] temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
		Arrays.sort(array, new Comparator<int[]>() {
			  @Override
        	  public int compare(int[] arr1, int[] arr2) {
				  return arr1[0]-arr2[0]; //ascending order
	          }
		});
		return array;
	}
    
    public static long[][] sort(long[][] array) {
    	//Sort an array (immune to quicksort TLE)
		Random rgen = new Random();
		for (int i = 0; i < array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    long[] temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
		Arrays.sort(array, new Comparator<long[]>() {
			  @Override
        	  public int compare(long[] arr1, long[] arr2) {
				  return 0;
	          }
		});
		return array;
	}
    
    static class FastScanner { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastScanner() { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int ni() { 
            return Integer.parseInt(next()); 
        } 
  
        long nl() { 
            return Long.parseLong(next()); 
        } 
  
        double nd() { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() { 
            String str = ""; 
            try { 
                str = br.readLine(); 
            } catch (IOException e) {
                e.printStackTrace(); 
            } 
            return str;
        }
    }
}