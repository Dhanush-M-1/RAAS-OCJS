import java.io.PrintWriter;
import java.util.*;

public class Main {
	static class SegmentTree {
		int N;
		int[] v;
		public SegmentTree(int M) {
			N=1;
			while(M>N) {
				N<<=1;
			}
			v = new int[N*2];
		}
		public void add(int l, int r, int x) {
			add(l, r, 0, N, x, 1);
		}
		public void add(int l, int r, int a, int b, int x, int idx) {
			if(r<=a || b<=l) {
				;
			} else if(l<=a && b<=r) {
				v[idx] += x;
			} else {
				int mid = (a+b)/2;
				add(l, r, a, mid, x, idx*2);
				add(l, r, mid, b, x, idx*2+1);
			}
		}
		
		public int get(int p) {
			p += N;
			int ans = 0;
			while(p>=1) {
				ans += v[p];
				p>>=1;
			}
			return ans;
		}
		
	}
	
	static class Segment {
		int l,r;
		int length;
		public Segment(int l, int r) {
			this.l = l;
			this.r = r;
			length = r-l+1;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);

		int N = sc.nextInt();
		int M = sc.nextInt();
		Segment[] segments = new Segment[N];
		for(int i=0; i<N; i++)
			segments[i] = new Segment(sc.nextInt(), sc.nextInt());

		Arrays.sort(segments, new Comparator<Segment>() {
			public int compare(Segment s1, Segment s2) {
				return Integer.compare(s1.length, s2.length);
			}
		});
		
		SegmentTree st = new SegmentTree(M+1);
		
		int idx = 0;
		for(int i=1; i<=M; i++) {
			while(idx<N && segments[idx].length<i) {
				st.add(segments[idx].l, segments[idx].r+1, 1);
				idx++;
			}
			int ans = N-idx;
			for(int j=i; j<=M; j+=i)
				ans += st.get(j);
			pw.println(ans);
		}
		
		sc.close();
		pw.close();
	}
}
