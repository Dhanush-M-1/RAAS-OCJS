import java.io.*;
import java.util.*;

public class D implements Runnable {
	public static void main (String[] args) {new Thread(null, new D(), "_cf", 1 << 28).start();}

	int res = 0, n;
	Point[] a;
	
	public void run() {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		System.err.println("");

		n = fs.nextInt();
		a = new Point[n];
		for(int i = 0; i < n; i++) {
			a[i] = new Point(fs.nextInt(), fs.nextInt(), i);
		}
		Arrays.sort(a);
		int[] remapX = new int[a[n-1].x+1];
		Arrays.fill(remapX, -1);
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			int x = a[i].x;
			if(remapX[x] == -1) {
				remapX[x] = cnt++;
			}
		}
		int[][] byX = new int[cnt][];
		TreeSet<Integer>[] findX = new TreeSet[cnt];
		int[] locX = new int[n];
		int[] locY = new int[n];
		Arrays.fill(locX, -1);
		Arrays.fill(locY, -1);
		
		cnt = 0;
		for(int i = 0; i < n; i++) {
			int j = i;
			while(j < n && a[i].x == a[j].x) j++;
			byX[cnt] = new int[j-i];
			findX[cnt] = new TreeSet<>();
			for(int k = i; k < j; k++) {
				findX[cnt].add(a[k].y);
				locY[a[k].id] = k-i;
				byX[cnt][k-i] = a[k].y;
			}
			cnt++;
			i=--j;
		}
		
		Arrays.sort(a, new VComp());
		int[] remapY = new int[a[n-1].y+1];
		Arrays.fill(remapY, -1);
		
		int cnt2 = 0;
		for(int i = 0; i < n; i++) {
			int y = a[i].y;
			if(remapY[y] == -1) {
				remapY[y] = cnt2++;
			}
		}
		
		int[][] byY = new int[cnt2][];
		cnt2 = 0;
		for(int i = 0; i < n; i++) {
			int j = i;
			while(j < n && a[i].y == a[j].y) j++;
			byY[cnt2] = new int[j-i];
			for(int k = i; k < j; k++) {
				locX[a[k].id] = k-i;
				byY[cnt2][k-i] = a[k].x;
			}
			cnt2++;
			i=--j;
		}
		
		
		int res = 0;
		for(int i = 0; i < n; i++) {
			int whereY = remapY[a[i].y];
			int whereX = remapX[a[i].x];
			
			int idxy = locX[a[i].id]; 
			int idxx = locY[a[i].id]; 
			
			if(byY[whereY].length-idxy <= byX[whereX].length-idxx) {
				for(int k = idxy+1; k < byY[whereY].length; k++) {
					int dist = abs(byY[whereY][k]-a[i].x);
					int nx = a[i].x, ny = a[i].y+dist;
					int nx2 = byY[whereY][k], ny2 = a[i].y+dist;
					if(nx >= remapX.length || remapX[nx] == -1) continue;
					if(nx2 >= remapX.length || remapX[nx2] == -1) continue;
					if(ny >= remapY.length || remapY[ny] == -1) continue;
					if(ny2 >= remapY.length || remapY[ny2] == -1) continue;
					boolean match = findX[remapX[nx]].contains(ny) && findX[remapX[nx2]].contains(ny2);
					if(match) {
						res++;
					}
				}
			}
			else {
				for(int k = idxx+1; k < byX[whereX].length; k++) {
					int dist = abs(byX[whereX][k]-a[i].y);
					int nx = a[i].x+dist, ny = a[i].y;
					int nx2 = a[i].x+dist, ny2 = byX[whereX][k];
					if(nx >= remapX.length || remapX[nx] == -1) continue;
					if(nx2 >= remapX.length || remapX[nx2] == -1) continue;
					if(ny >= remapY.length || remapY[ny] == -1) continue;
					if(ny2 >= remapY.length || remapY[ny2] == -1) continue;
					boolean match = findX[remapX[nx]].contains(ny) && findX[remapX[nx2]].contains(ny2);
					if(match) {
						res++;
					}
				}
			}
		}
		
		out.println(res);
		out.close();
	}
	
	int abs(int a) {
		if(a < 0) return -a;
		return a;
	}
	
	long getMask(int a, int b) {
		long res = b;
		res |= (long)a << 32L;
		return res;
	}
	
	class VComp implements Comparator<Point> {
		public int compare(Point a, Point b) {
			int comp = Integer.compare(a.y, b.y);
			if(comp == 0) comp = Integer.compare(a.x, b.x);
			return comp;
		}
	}

	class Point implements Comparable<Point> {
		int x, y, id;
		Point(int a, int b, int i) {
			x = a; y = b;
			id = i;
		}
		public int compareTo(Point p) {
			int comp = Integer.compare(x, p.x);
			if(comp == 0) comp = Integer.compare(y, p.y);
			return comp;
		}
		public String toString() {
			return String.format("%d - (%d, %d)", id, x, y);
		}
	}
	
	class FastScanner {
		public int BS = 1<<16;
		public char NC = (char)0;
		byte[] buf = new byte[BS];
		int bId = 0, size = 0;
		char c = NC;
		double num = 1;
		BufferedInputStream in;

		public FastScanner() {
			in = new BufferedInputStream(System.in, BS);
		}

		public FastScanner(String s) {
			try {
				in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
			}
			catch (Exception e) {
				in = new BufferedInputStream(System.in, BS);
			}
		}

		public char nextChar(){
			while(bId==size) {
				try {
					size = in.read(buf);
				}catch(Exception e) {
					return NC;
				}                
				if(size==-1)return NC;
				bId=0;
			}
			return (char)buf[bId++];
		}

		public int nextInt() {
			return (int)nextLong();
		}

		public long nextLong() {
			num=1;
			boolean neg = false;
			if(c==NC)c=nextChar();
			for(;(c<'0' || c>'9'); c = nextChar()) {
				if(c=='-')neg=true;
			}
			long res = 0;
			for(; c>='0' && c <='9'; c=nextChar()) {
				res = (res<<3)+(res<<1)+c-'0';
				num*=10;
			}
			return neg?-res:res;
		}

		public double nextDouble() {
			double cur = nextLong();
			return c!='.' ? cur:cur+nextLong()/num;
		}

		public String next() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c>32) {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public String nextLine() {
			StringBuilder res = new StringBuilder();
			while(c<=32)c=nextChar();
			while(c!='\n') {
				res.append(c);
				c=nextChar();
			}
			return res.toString();
		}

		public boolean hasNext() {
			if(c>32)return true;
			while(true) {
				c=nextChar();
				if(c==NC)return false;
				else if(c>32)return true;
			}
		}
		
		public int[] nextIntArray(int n) {
			int[] res = new int[n];
			for(int i = 0; i < n; i++) res[i] = nextInt();
			return res;
		}
		
	}

}