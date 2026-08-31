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
		Point a = new Point(sc.ni(),sc.ni());
		Point b = new Point(sc.ni(),sc.ni());
		int segs = sc.ni();
		int N = 0;
		HashMap<Point,Integer> hm = new HashMap<Point,Integer>();
		ArrayList<Point> points = new ArrayList<Point>();
		for (int i = 0; i < segs; i++) {
			int row = sc.ni();
			int col1 = sc.ni();
			int col2 = sc.ni();
			for (int j = col1; j <= col2; j++) {
				Point p = new Point(row,j);
				hm.put(p, N);
				points.add(p);
				N++;
			}
		}
		//N holds the number of points
		ArrayList<Integer>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < N; i++) {
			Point p = points.get(i);
			for (int x = -1; x <= 1; x++) {
				for (int y = -1; y <= 1; y++) {
					Point q = new Point(p.x+x,p.y+y);
					if (hm.containsKey(q) && !(x==0&&y==0)) {
						adj[i].add(hm.get(q));
					}
				}
			}
		}

		int rootID = hm.get(a);
		int destID = hm.get(b);
		
		int[] dist = new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[rootID] = 0;
		
		ArrayDeque<Integer> bfs = new ArrayDeque<Integer>();
		bfs.add(rootID);
		while (!bfs.isEmpty()) {
			int node = bfs.pollFirst();
			if (node == destID) {
				break;
			}
			for (int neighbor: adj[node]) {
				if (dist[neighbor]==Integer.MAX_VALUE) {
					dist[neighbor] = dist[node]+1;
					bfs.add(neighbor);
				}
			}
		}
		if (dist[destID]==Integer.MAX_VALUE) {
			pw.println(-1);
		} else {
			pw.println(dist[destID]);
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