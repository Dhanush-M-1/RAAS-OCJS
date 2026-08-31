import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
1
2
1 5 10
2 15 5

1
3
2 93 78
1 71 59
3 57 96

1
4
1 100 0
1 100 0
2 0 1
2 0 1
 */
public class Main {

	public static void main(String[] args) {
		FastScanner fs=new FastScanner();
		int T=fs.nextInt();
		PrintWriter out=new PrintWriter(System.out);
		for (int tt=0; tt<T; tt++) {
			int n=fs.nextInt();
			ArrayList<Camel> goLeft=new ArrayList<>();
			ArrayList<Camel> goRight=new ArrayList<>();
			long ans=0;
			for (int i=0; i<n; i++) {
				int k=fs.nextInt()-1, l=fs.nextInt(), r=fs.nextInt();
				if (l>=r) {
					goLeft.add(new Camel(k, l-r));
					ans+=r;
				}
				else {
					goRight.add(new Camel(n-1-(k+1), r-l));
					ans+=l;
				}
			}
//			System.out.println("Initially ans: "+ans);
			ans+=solve(goLeft);
			ans+=solve(goRight);
			out.println(ans);
		}
		out.close();
	}
	
	//wants to go left
	static long solve(ArrayList<Camel> camels) {
		Collections.sort(camels);
		int lastPos=-1;
		int nSpaces=0;
		PriorityQueue<Integer> removableDeltas=new PriorityQueue<>();
		for (Camel c:camels) {
			int dPositions=c.splitPoint-lastPos;
			lastPos=c.splitPoint;
//			System.out.println("Processing camel at split point "+c.splitPoint+" "+c.difference+" "+dPositions+" "+lastPos);
			nSpaces+=dPositions;
			if (nSpaces>0) {
//				System.out.println("Extra space ");
				removableDeltas.add(c.difference);
				nSpaces--;
				continue;
			}
			else {
//				System.out.println("No room");
				if (removableDeltas.isEmpty()) continue;
				if (removableDeltas.peek()<c.difference) {
					removableDeltas.remove();
					removableDeltas.add(c.difference);
				}
			}
		}
		long ans=0;
		for (long l:removableDeltas) ans+=l;
		return ans;
		
	}
	
	static class Camel implements Comparable<Camel> {
		int splitPoint;
		int difference;
		public Camel(int splitPoint, int difference) {
			this.splitPoint=splitPoint;
			this.difference=difference;
		}
		
		public int compareTo(Camel o) {
			return Integer.compare(splitPoint, o.splitPoint);
		}
	}

	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	
	static class FastScanner {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String next() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		int[] readArray(int n) {
			int[] a=new int[n];
			for (int i=0; i<n; i++) a[i]=nextInt();
			return a;
		}
		long nextLong() {
			return Long.parseLong(next());
		}
	}

	
}
