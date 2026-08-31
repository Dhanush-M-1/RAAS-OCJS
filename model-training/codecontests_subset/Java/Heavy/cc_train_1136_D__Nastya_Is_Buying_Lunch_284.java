import java.util.*;

import java.io.*;

public class NastyaLunch {
	static BufferedReader br;
	static StringTokenizer tokenizer;

	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = nextInt();
		int m = nextInt();
		int ans = 0;
		Node arr = new Node();
		Node curr = arr;
		for(int i = 0; i < n; i++) {
			curr.next = new Node(nextInt() - 1, curr);
			curr = curr.next;
		}
		HashSet<Integer>[] adj = new HashSet[n];
		for(int i = 0; i < n; i++)
			adj[i] = new HashSet<Integer>();
		for(int i = 0; i < m; i++)
			adj[nextInt() - 1].add(nextInt() - 1);
		curr = curr.prev;
		for(int i = n - 2; i >= 0; i--) {
			if(check(adj,i, n, curr)) {
				ans++;
				curr = curr.next;
				curr.prev.prev.next = curr;
				curr.prev = curr.prev.prev;
			}
			curr = curr.prev;
		}
		System.out.println(ans);
	}
	public static boolean check(HashSet<Integer>[] adj, int pos, int n, Node t) {
//		System.out.println(t);
		int curr = t.val;
		Node runner = t.next;
		while(runner != null){
			if(!adj[curr].contains(runner.val))
				return false;
			runner = runner.next;
		}
		
		return true;
	}
	public static String next() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			String line = br.readLine();
			if (line == null)
				throw new IOException();
			tokenizer = new StringTokenizer(line);
		}
		return tokenizer.nextToken();
	}

	public static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
class Node {
	public Node(int val, Node prev) {
		super();
		this.val = val;
		this.prev = prev;
	}
	public Node() {}
	int val;
	Node prev, next;
	public String toString() {
		return val + ", " + next;
	}
}
