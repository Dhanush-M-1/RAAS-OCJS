import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;


public class temp2 {
	static int mini;
	static int miniv;
	static long time = 0, mp = Integer.MAX_VALUE, k = 0, cnt = 0, edge = 0, no = 0;

	static int[] goal;
	static int[] init;
	static int[] col;
	static char[][] g;
	static String sb = "";
	static ArrayList<Integer>[] a;

	static ArrayList<Integer> p = new ArrayList<>();


	public static void main(String[] args) throws IOException {

		Reader scn=new Reader();
		int n = scn.nextInt();
		int m = scn.nextInt();
		int q = scn.nextInt();
		ArrayList<Integer> gr[] = new ArrayList[n];


		int p[] = new int[n];
		int rank[] = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
			rank[i] = 1;
			gr[i]=new ArrayList<>();
		}

		int[] diameter = new int[n];
		for (int i = 0; i < m; i++) {
			int x = scn.nextInt() - 1;
			int y = scn.nextInt() - 1;
			gr[x].add(y);
			gr[y].add(x);
			unionset(p, rank, gr, x, y);

		}
		boolean visit[]=new boolean[n];
		
		for(int i=0;i<n;i++){
			int pp=getparent(p, i);
			if(!visit[pp]){
				visit[pp]=true;
				diameter[pp]=getdiameter(pp,p,rank,gr);
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<q;i++){
			int t=scn.nextInt();
			if(t==1){
				int x=scn.nextInt()-1;
				int px=getparent(p, x);
				sb.append(diameter[px]+"\n");
			}
			else{
				int x=scn.nextInt()-1;
				int y=scn.nextInt()-1;
				unionset2(p,rank,diameter,gr,x,y);
				
			}
		}
		System.out.println(sb);

	}

	private static void unionset2(int[] p, int[] rank, int[] diameter,ArrayList<Integer>[] gr, int x, int y) {
		int px = getparent(p, x);
		int py = getparent(p, y);
		if(px==py){
			return;
		}
		if (rank[px] >= rank[py]) {
			rank[px] += rank[py];
			p[py] = px;
			diameter[px]=Math.max(diameter[px], Math.max(diameter[py], (diameter[py]+1)/2+(diameter[px]+1)/2+1));
		} else {
			rank[py] += rank[px];
			p[px] = py;
			diameter[py]=Math.max(diameter[px], Math.max(diameter[py], (diameter[py]+1)/2+(diameter[px]+1)/2+1));
		}
		
		
	}

	private static int getdiameter(int i, int[] p, int[] rank, ArrayList<Integer>[] gr) {
		mini=-1;
		dfs(gr,i,0,-1);
		mini=-1;
		dfs(gr,miniv,0,-1);
		return mini;
	}

	private static void dfs(ArrayList<Integer>[] gr, int u, int depth, int p) {
		if(depth>mini){
			mini=depth;
			miniv=u;
		}
		for(int i=0;i<gr[u].size();i++){
			int ch=gr[u].get(i);
			if(ch!=p){
				dfs(gr, ch, depth+1, u);
			}
		}
		
	}

	private static void unionset(int[] p, int[] rank, ArrayList<Integer>[] gr, int x, int y) {
		int px = getparent(p, x);
		int py = getparent(p, y);
		if (rank[px] >= rank[py]) {
			rank[px] += rank[py];
			p[py] = px;
		} else {
			rank[py] += rank[px];
			p[px] = py;
		}
	}

	private static int getparent(int[] p, int x) {
		if(p[x]==x){
			return x;
		}
		return p[x]=getparent(p,p[x]);
	}
	static class pair implements Comparable<pair> {
		int n = 0;
		int cnt = 0;
		String s="";
		// int cnt;

		pair(int b, int a, String k) {
			this.n = b;
			this.cnt = a;
			s=k;
			// cnt = x;
		}

		@Override
		public int compareTo(pair o) {

			return 1;

		}
	}

	// -----------PrintWriter for faster output---------------------------------
	public static PrintWriter out;

	public static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[100000 + 1]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}

		public int[] nextIntArray(int n) throws IOException {
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextInt();
			}
			return arr;
		}

		public long[] nextLongArray(int n) throws IOException {
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = nextLong();
			}
			return arr;
		}

		public int[][] nextInt2DArray(int m, int n) throws IOException {
			int[][] arr = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++)
					arr[i][j] = nextInt();
			}
			return arr;
		}

	}
}
