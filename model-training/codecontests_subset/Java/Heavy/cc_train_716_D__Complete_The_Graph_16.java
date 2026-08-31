import java.io.*;
import java.util.*;
import java.math.*;

public class Solve3 {
  
  static class Edge{
    int u; int v; long w;
    Edge(int u, int v, long w) {
	  this.u = u; this.v = v; this.w = w;
	}
  }
  static class Node implements Comparable<Node>{
    int nr; long d;
	Node(int nr, long d){
	  this.nr = nr;
	  this.d = d;
	}
	public int compareTo(Node node) {
	  if(node.d > d) return -1;
	  if(node.d < d) return 1;
	  return 0;
	}
  }
  static long INF = 10000000000000L;
  static long dij(LinkedList<Edge> [] es, Set<Edge> zeros, boolean[] visited, int s, int t, int n, boolean pr) {
    long res = INF*10000L;
	PriorityQueue<Node> q = new PriorityQueue<Node>();
	Arrays.fill(visited, false);
	long min[] = new long[n];
	Arrays.fill(min, res);
	int[] prev = new int[n];
	Arrays.fill(prev, -1);
	q.offer(new Node(s, 0));
	while(!q.isEmpty()) {
	  Node node = q.poll();
	  
	  if(node.nr == t) {
	    if(pr){
	    HashMap<Integer, Integer> map = new HashMap<>();
		int a = node.nr;
		int b = prev[a];
		while(b!=-1){
		  map.put(a,b);
		  a=b;
		  b=prev[b];
		  //System.out.println(a + " X " + b);
		}
		{
		  Iterator<Edge> it = zeros.iterator();
		  while(it.hasNext()) {
		    Edge e = it.next();
            if(!((Integer)e.v).equals(map.get(e.u)) && !((Integer)e.u).equals(map.get(e.v))) {
              it.remove();			
			  e.w = INF;  
			  //System.out.println(e.v + " Y " + e.u);
			}
		  }
		}
		}
	    return node.d;
	  }
	  if(visited[node.nr]==false)
	  for(Edge e : es[node.nr]) {
	    if(e.v==node.nr) {
		  if(!visited[e.u]&&node.d + e.w<min[e.u]){
		    min[e.u]=node.d + e.w;
			prev[e.u]=node.nr;
		    q.offer(new Node(e.u, node.d + e.w));
		  }
		} else {
		  if(!visited[e.v]&&node.d + e.w<min[e.v]){
		    min[e.v]=node.d + e.w;
		    prev[e.v]=node.nr;
			q.offer(new Node(e.v, node.d + e.w));
		  }
		}
	  }
	  visited[node.nr] = true;
	  
	}
    return res;	
  }
  
  public static void main(String[] args) {
	MyScanner scanner = new MyScanner();
	PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	long start = System.currentTimeMillis();
    int n = scanner.nextInt();
	int m = scanner.nextInt();
	long L = scanner.nextInt();
	INF = L+1;
	int s = scanner.nextInt();
	int t = scanner.nextInt();
	Edge[] edges = new Edge[m];
	Set<Edge> zeros = new HashSet<Edge>();
    for(int i = 0; i < m; i++) {
      int u = scanner.nextInt();
	  int v = scanner.nextInt();
	  long w = scanner.nextInt();
	  edges[i] = new Edge(u,v,w);
	  if(w==0L) zeros.add(edges[i]);
    }
	LinkedList<Edge> [] es = new LinkedList[n];
	boolean[] visited = new boolean[n];
	for(int i = 0; i < n; i++) es[i] = new LinkedList<>();
	for(Edge e : edges) {
	  es[e.u].add(e);
	  es[e.v].add(e);
	}
	for(Edge e : zeros) {
      e.w = 1L;
    }	
    long min = dij(es, zeros, visited, s, t, n, true);
    for(Edge e : zeros) {
      e.w = INF;
    }	
	long max = dij(es, zeros, visited, s, t, n, false);
	//System.out.println(min + " " + max);
	if(min <= L && L <= max) {
	  long dist = max;
	  int count = 0;
	  //System.out.println(zeros.size());
	  for(Edge e : zeros) if(dist != L){
	    if(dist - L > e.w) {
		  dist-=e.w-1;
		  e.w = 1;
		  count++;
		  if(dist - L < 2 * INF || count > 1000) {
		    dist = dij(es, zeros, visited, s, t, n, false);
			count=0;
		  }
		  continue;
		}
		dist = dij(es, zeros, visited, s, t, n, false);
		e.w = 1;
		long dist2 = dij(es, zeros, visited, s, t, n, false);
		if(dist2 < L) 
		{
		 e.w = 1+(L-dist2);
		 dist = dij(es, zeros, visited, s, t, n,false);
		} else
		dist = dist2;
		if(dist == L) break;
		
	  }
	  if(dist == L) {
		out.println("YES");
		for(Edge e2 : edges) {
		  out.println(e2.u + " " + e2.v + " " + e2.w);
		}
		out.close();
		return;
	  }
	}
	out.println("NO");
	out.close();
  }
//

  public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
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