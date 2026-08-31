import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class E {
	
	static TreeSet<Node> allNodes=new TreeSet<>();
	static Node[] nodes;
	
	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int n=fs.nextInt(), m=fs.nextInt(), k=fs.nextInt();
		nodes=new Node[n];
		for (int i=0; i<n; i++) nodes[i]=new Node(i);
		Edge[] edges=new Edge[m];
		for (int i=0; i<m; i++) {
			int a=fs.nextInt()-1, b=fs.nextInt()-1;
			edges[i]=new Edge(a, b);
			nodes[a].adj.add(b);
			nodes[b].adj.add(a);
			nodes[a].degree++;
			nodes[b].degree++;
		}
		for (Node nn:nodes) {
			allNodes.add(nn);
		}
		int[] answers=new int[m];
		while (!allNodes.isEmpty()&&allNodes.first().degree<k) {
			Node toRemove=allNodes.first();
			allNodes.remove(toRemove);
			for (int nIndex:toRemove.adj) {
				Node nn=nodes[nIndex];
				if (allNodes.contains(nn)) {
					allNodes.remove(nn);
					nn.degree--;
					allNodes.add(nn);
				}
			}
		}
		for (int i=m-1; i>=0; i--) {
			answers[i]=allNodes.size();
			Edge e=edges[i];
			Node a=nodes[e.from], b=nodes[e.to];
			if (allNodes.contains(a)&&allNodes.contains(b)) {
				allNodes.remove(a);
				allNodes.remove(b);
				a.degree--;
				b.degree--;
				a.adj.remove(e.to);
				b.adj.remove(e.from);
				allNodes.add(a);
				allNodes.add(b);
			}
			while (!allNodes.isEmpty()&&allNodes.first().degree<k) {
				Node toRemove=allNodes.first();
				allNodes.remove(toRemove);
				for (int nIndex:toRemove.adj) {
					Node nn=nodes[nIndex];
					if (allNodes.contains(nn)) {
						allNodes.remove(nn);
						nn.degree--;
						allNodes.add(nn);
					}
				}
			}			
		}
		PrintWriter out=new PrintWriter(System.out);
		for (int i=0; i<m; i++) {
			out.println(answers[i]);
		}
		out.close();
	}
	
	static class Edge {
		int from, to;
		public Edge(int from, int to) {
			this.from=from;
			this.to=to;
		}
	}
	
	static class Node implements Comparable<Node> {
		int degree=0;
		int index;
		HashSet<Integer> adj=new HashSet<>();
		
		public Node(int index) {
			this.index=index;
		}
		
		public int compareTo(Node o) {
			int degDiff=Integer.compare(degree, o.degree);
			return degDiff==0?Integer.compare(index, o.index):degDiff;
		}
		
		public int hashcode() {
			return index;
		}
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		
		public String next() {
			while (!st.hasMoreElements())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
		
		public long nextLong() {
			return Long.parseLong(next());
		}
		
		public int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) {
				a[i]=nextInt();
			}
			return a;
		}
		
		public double nextDouble() {
			return Double.parseDouble(next());
		}
		
	}

}
