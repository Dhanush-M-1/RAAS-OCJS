import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class D {

	public static int padre[];
	public static int rango[];

	public static void init(int v) {
		padre = new int[v];
		rango = new int[v];
		for (int i = 0; i < padre.length; i++) {
			padre[i] = i;
			rango[i] = 1;
		}
	}

	public static int find(int x) {
		while (padre[x] != x) {
			padre[x] = padre[padre[x]];
			x = padre[x];
		}
		return x;
	}

	public static void union(int a, int b) {
		int xRoot = find(a);
		int yRoot = find(b);
		if(xRoot == yRoot) return ;
		if (rango[xRoot] > rango[yRoot]) {
			padre[yRoot] = xRoot;
			rango[xRoot] += rango[yRoot];
		} else {
			padre[xRoot] = yRoot;
			rango[yRoot] += rango[xRoot];
		}
	}

	static class Pair implements Comparable<Pair> {
		int p, v;

		public Pair(int p, int v) {
			this.p = p;
			this.v = v;
		}

		@Override
		public int compareTo(Pair o) {
			if (p == o.p)
				return o.v - v;
			return p - o.p;
		}
	}

	public static void main(String[] args) throws IOException {
		File inputFile = new File("entradaD");
		if (inputFile.exists())
			System.setIn(new FileInputStream(inputFile));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder out = new StringBuilder();
		String line = "";
		while ((line = in.readLine()) != null) {
			int[] nm = readInts(line);
			int n = nm[0], m = nm[1];
			int[] v = readInts(in.readLine());
			init(n);
			for (int i = 0; i < m; i++) {
				int[] lr = readInts(in.readLine());
				union(lr[0] - 1, lr[1] - 1);
			}
			Pair[] all = new Pair[n];
			int[] first = new int[n];
			int[] pos = new int[n];
			int[] parent = new int[n];
			for (int i = 0; i < n; i++){
				parent[i] = find(i);
				first[i] = -1;
				all[i] = new Pair(parent[i], v[i]);
			}
			Arrays.sort(all);
			for (int i = 0; i < n; i++) 
				if(first[all[i].p] == -1)
					first[all[i].p] = i;
			for (int i = 0; i < n; i++) {
				if (i != 0)
					out.append(' ');
				out.append(all[first[parent[i]]+pos[parent[i]]++].v);
			}
			out.append('\n');
		}
		System.out.print(out);
	}

	static int[] readInts(String line) {
		StringTokenizer st = new StringTokenizer(line.trim());
		int a[] = new int[st.countTokens()], index = 0;
		while (st.hasMoreTokens())
			a[index++] = Integer.parseInt(st.nextToken());
		return a;
	}

}
