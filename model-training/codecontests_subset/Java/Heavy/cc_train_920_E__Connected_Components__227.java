import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] G = new LinkedList[n+1];
		
		for (int i = 0; i <= n; i++) {
			G[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			G[x].add(y);
			G[y].add(x);
		}
		
		Vertex[] V = new Vertex[n+1];
        for (int v = 1; v <= n; v++) {
            V[v] = new Vertex(v, null, null);
        }
        
        VertexList list1 = new VertexList();
        for(int v = 1; v < G.length; v++) {
        	list1.add(V[v]);
        }
        
        VertexList list2 = new VertexList();
        
        int[] nodesCC = new int[n];
		int cc = 0;
		for (int v = 1; v <= n; v++) {
			if(!V[v].visited) {
				nodesCC[cc] = bfs(G, v, V, list1, list2);
				cc++;
			}
		}
		
		Arrays.sort(nodesCC);
		
		System.out.println(cc);
		for (int i = 0; i < nodesCC.length; i++) {
			if (nodesCC[i] > 0) {
				System.out.print(nodesCC[i] + " ");
			}
		}
		System.out.println();
		
		sc.close();
	}
	
	public static int bfs(LinkedList<Integer>[] G, int s, Vertex[] V, VertexList list1, VertexList list2) {
		list1.remove(V[s]);
        
        LinkedList<Integer> Q = new LinkedList<Integer>();
        Q.addLast(s);
        V[s].visited = true;
        int count = 1;
        while(!Q.isEmpty()) {
            int u = Q.removeFirst();
            
            for (int v : G[u]) {
                if (!V[v].visited) {
                    list1.remove(V[v]);
                    list2.add(V[v]);
                }
            }
            
            Vertex v = list1.first;
            while(v != null) {
                v.visited = true;
                Q.addLast(v.key);
                v = v.next;
                
                count++;
            }
            list1.first = list2.first;
            list1.last = list2.last;
            list2.clear();
        }
        
        return count;
	}
	
	static class VertexList {
        Vertex first, last;
        
        VertexList() {
            first = null;
            last = null;
        }
        
        void add(Vertex v) {
            if (first == null) {
                first = v;
                last = v;
            }
            
            else {
                last.next = v;
                v.prev = last;
                last = v;
            }
        }
        
        void remove(Vertex v) {
            if (v.prev == null) {
                first = v.next;
            } else {
                v.prev.next = v.next;
            }
            
            if (v.next == null) {
                last = v.prev;
            } else {
                v.next.prev = v.prev;
            }
            
            v.prev = null;
            v.next = null;
        }
        
        void clear() {
            first = null;
            last = null;
        }
    }
    
    static class Vertex {
        Vertex prev, next;
        int key;
        boolean visited;
        
        public Vertex(int key, Vertex prev, Vertex next) {
            this.key = key;
            this.prev = prev;
            this.next = next;
        }
    }
}