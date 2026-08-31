import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;

public class D1208 {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("F:/books/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		Long[] a = new Long[s.length];
		for (int i = 0; i < s.length; i++) {
			a[i] = Long.parseLong(s[i]);
		}
		long[] tree = new long[4*n];
		long[] lazy = new long[4*n];
		for(int i=0;i<n;i++) {
			segmentTreeMinUpdateLazy(lazy,tree,0,n-1,0,i,i,a[i]);
		}
		for(int i=0;i<n;i++) {
			int pos = getRightZero(lazy,tree,n,0,n-1);
			segmentTreeMinUpdateLazy(lazy,tree,0,n-1,0,pos+1,n-1,-(i+1));
			segmentTreeMinUpdateLazy(lazy,tree,0,n-1,0,pos,pos,Long.MAX_VALUE);
			a[pos] = (long) (i+1);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) sb.append(a[i]+" ");
		System.out.println(sb.toString());
	}
	
	private static int getRightZero(long[] lazy,long[] tree,int n,int s, int e) {
		if(s==e) {
			return s;
		}
		int m = (s+e)/2;
		if(segmentTreeMinQueryLazy(lazy,tree,0,n-1,0,m+1,e)==0) 
			return getRightZero(lazy,tree,n,m+1,e);
		return getRightZero(lazy,tree,n,s,m);
	}

	private static void segmentTreeMinUpdateLazy(long[] lazy,long[] tree,int ss,
			int se,int si,int us,int ue,long v) {
		if(lazy[si]!=0) {
			tree[si] += lazy[si];
			if(ss!=se) {
				lazy[si*2+1] += lazy[si];
				lazy[si*2+2] += lazy[si];
			}
			lazy[si] = 0;
		}
		if(us>se || ue<ss) return;
		if(us<=ss && ue>=se) {
			tree[si] += v;
			if(ss!=se) {
				lazy[si*2+1] += v;
				lazy[si*2+2] += v;
			}
			return;
		}
		int m = (ss+se)/2;
		segmentTreeMinUpdateLazy(lazy,tree,ss,m,si*2+1,us,ue,v);
		segmentTreeMinUpdateLazy(lazy,tree,m+1,se,si*2+2,us,ue,v);
		tree[si] = Math.min(tree[si*2+1], tree[si*2+2]);
	}
	
	private static long segmentTreeMinQueryLazy(long[] lazy,long[] tree,int ss,
			int se,int si,int qs,int qe) {
		if(lazy[si]!=0) {
			tree[si] += lazy[si];
			if(ss!=se) {
				lazy[si*2+1] += lazy[si];
				lazy[si*2+2] += lazy[si];
			}
			lazy[si] = 0;
		}
		if(qs>se || qe<ss) return Long.MAX_VALUE;
		if(qs<=ss && qe>=se) return tree[si];
		int m = (ss+se)/2;
		return Math.min(segmentTreeMinQueryLazy(lazy,tree,ss,m,si*2+1,qs,qe),
				segmentTreeMinQueryLazy(lazy,tree,m+1,se,si*2+2,qs,qe));
	}


}
