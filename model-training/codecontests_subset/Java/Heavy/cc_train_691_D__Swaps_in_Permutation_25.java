import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CodeForces {

	public static void main(String[] args) {
		InputReader input = new InputReader(System.in);
		int n = input.nextInt();
		int m = input.nextInt();   
		int[] perm = new int[n];  // the numbers permutation
		for(int i = 0 ; i < n; i++) {
			perm[i] = input.nextInt();
		}
		ArrayList[] edges = new ArrayList[n]; //edges list
		for(int i = 0; i < n; i ++) {
			edges[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < m; i++) {
			int from = input.nextInt() - 1;
			int to = input.nextInt() - 1;
			edges[from].add(to);
			edges[to].add(from);
		}
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				ArrayList<Integer> nums = new ArrayList<Integer>();
				ArrayList<Integer> pos = new ArrayList<Integer>();
				Queue<Integer> bfs = new LinkedList<Integer>();
				bfs.add(i);
				nums.add(-1 * perm[i]);
				pos.add(i);
				visited[i] = true;
				while (!bfs.isEmpty()) {
					int cur = bfs.poll();
					int size = edges[cur].size();
					for (int j = 0; j < size; j++) {
						int adj = (int) edges[cur].get(j);
						if(!visited[adj]) {
							visited[adj] = true;
							bfs.add(adj);
							pos.add(adj);
							nums.add(-1 * perm[adj]);
						}
					}
				}
				Collections.sort(pos);
				Collections.sort(nums);
				for(int k = 0; k < pos.size(); k++) {
					perm[pos.get(k)] = -1 * nums.get(k);
				}
			}
			
		}
		PrintWriter pw = new PrintWriter(System.out);
		for(int a : perm) {
			pw.print(a);
			pw.append(' ');
		}
		pw.println();
		pw.flush();
		pw.close();
	}
	
	static class InputReader {
		private BufferedReader reader;
		private StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			tokenizer = null;
		}

		public InputReader(FileReader stream) {
			reader = new BufferedReader(stream);
			tokenizer = null;
		}

		public String nextLine() {
			try {
				return reader.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}