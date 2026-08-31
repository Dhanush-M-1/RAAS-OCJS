
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	public static void solution() throws Exception {
		int TestCase = Integer.parseInt(rd.readLine());
		for(int TT=0;TT<TestCase;TT++) {
			int n = Integer.parseInt(rd.readLine());
			int[] arr = new int[n];
			int[] printweight = new int[n];
			tok = new StringTokenizer(rd.readLine());
			for(int i=0;i<n;i++) arr[i] = Integer.parseInt(tok.nextToken());
			
			Queue<Node> que = new LinkedList<>();
			que.add(new Node(0,n-1,0));
			while(!que.isEmpty()) {
				Node c = que.poll();
				int mp = findMax(c.pos, arr);
				printweight[mp] = c.weight;
				if(mp-1 >= c.pos[0]) que.add(new Node(c.pos[0],mp-1,c.weight+1));
				if(mp+1 <= c.pos[1]) que.add(new Node(mp+1,c.pos[1],c.weight+1));
			}
			for(int i=0;i<n;i++) wr.write(printweight[i]+" ");
			wr.newLine();
		}
		wr.flush();
	}
	
	public static int findMax(int[] pos, int[] arr) {
		int max = 0;
		int index = -1;
		for(int i=pos[0];i<=pos[1];i++) {
			if(max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	static class Node {
		int[] pos = new int[2];
		int weight;
		public Node(int l, int r, int w) {
			this.pos[0] = l;
			this.pos[1] = r;
			this.weight = w;
		}
	}
}