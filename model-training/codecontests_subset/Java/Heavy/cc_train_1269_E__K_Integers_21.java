import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class E {

	public static void main(String[] args) throws Exception {
//		StringTokenizer stok = new StringTokenizer(new Scanner(new File("F:/books/input.txt")).useDelimiter("\\A").next());
		StringTokenizer stok = new StringTokenizer(new Scanner(System.in).useDelimiter("\\A").next());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(stok.nextToken());
		int[] a = new int[n+1];
		for (int i = 0; i < n; i++) {
			a[Integer.parseInt(stok.nextToken())]=i+1;
		}
		long tot1 = 0,tot2 = 0;
		long[] fen = new long[n+1];
		PriorityQueue<Long> minH = new PriorityQueue<Long>();
		PriorityQueue<Long> maxH = new PriorityQueue<Long>(Collections.reverseOrder());
		long l = Long.MIN_VALUE,r = Long.MAX_VALUE;
		long ls=0,rs=0;
		for(int i=1;i<=n;i++) {
			tot1 += fenwickQ(n,fen)-fenwickQ(a[i],fen);
			fenwickI(a[i],1,fen);
			if(a[i]<=r) {
				maxH.add((long) a[i]);
				ls += a[i];
			}	
			else {
				minH.add((long) a[i]);
				rs += a[i];
			}
			if(maxH.size()>minH.size()+1) {
				long v = maxH.poll();
				minH.add(v);
				ls-=v;rs+=v;
			}
			else if(minH.size()>maxH.size()) {
				long v = minH.poll();
				maxH.add(v);
				ls+=v;rs-=v;
			}
			l = maxH.peek();
			r = minH.size()>0?minH.peek():r;
//			System.out.println(minH+"\n"+maxH+"\n"+i);
//			System.out.println(tot1+" "+tot2);
			tot2 += l*maxH.size()-ls;
			tot2 += rs-l*minH.size();
			tot2 -= tr(maxH.size()-1);
			tot2 -= tr(minH.size());
//			System.out.println(tot1+" "+tot2);
//			System.out.println("******");
			sb.append((tot1+tot2)+" ");
			tot2=0;
		}
		System.out.println(sb);
	}
	
	private static long tr(long n) {
		return (n*(n+1)/2);
	}

	private static void fenwickI(int id, long v, long[] fen) {
		int l = fen.length;
		for(int i=id;i<l;i+=i&-i) {
			fen[i] += v;
		}
	}

	private static long fenwickQ(int id, long[] fen) {
		long ret = 0;
		for(int i=id;i>0;i-=i&-i) {
			ret += fen[i];
		}
		return ret;
	}

}
