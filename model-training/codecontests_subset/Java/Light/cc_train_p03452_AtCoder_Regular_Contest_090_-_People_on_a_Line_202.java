import java.util.*;
import java.io.*;


public class Main {
	
	public static class edge {
		
		node l;
		node r;
		int d;
		
		public edge(node l, node r, int d) {
			this.l = l;
			this.r = r;
			this.d = d;
		}
		
	}	
	public static class node {
		
		boolean assigned; //have we ever given this a val?
		LinkedList<edge> edg;
		boolean cleared; //processed
		int loc;
		
		public node() {
			assigned = false;
			loc = 0;
			cleared = false;
			edg = new LinkedList<edge>();
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] rd;
		rd = in.readLine().split("\\s++");
		int n = Integer.parseInt(rd[0]);
		int m = Integer.parseInt(rd[1]);
		node[] nodes = new node[n];
		for(int i = 0; i < n; i++) {
			nodes[i] = new node();
		}
		for(int i = 0; i < m; i++) {
			rd = in.readLine().split("\\s++");
			int l = Integer.parseInt(rd[0]);
			int r = Integer.parseInt(rd[1]);
			int d = Integer.parseInt(rd[2]);
			edge t = new edge(nodes[l-1], nodes[r-1], d);
			nodes[l-1].edg.offer(t);
			nodes[r-1].edg.offer(t);
		}
		boolean gucci = true;
		for(int i = 0; i < n; i++) {
			if(nodes[i].cleared) continue;
			LinkedList<node> q = new LinkedList<node>();
			q.offer(nodes[i]);
			nodes[i].assigned = true;
			while(!q.isEmpty()) {
				node nod = q.poll();
				for(edge e : nod.edg) {
					node oth = e.l;
					int dir = -1;
					if(e.l == nod) {
						oth = e.r;
						dir = 1;
					}
					if(oth.cleared) continue;
					else {
						if(!oth.assigned) {
							q.offer(oth);
							oth.loc = nod.loc + dir * e.d;
							oth.assigned = true;
						} else {
							if(oth.loc != nod.loc + dir * e.d) gucci = false;
						}
					}
				}
				nod.cleared = true;
			}
		}
		System.out.println(gucci ? "Yes" : "No");
	}
}