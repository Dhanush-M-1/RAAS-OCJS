import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class J {
	static final int inf = (int)1e7;
	static int n;
	static int[] as,bs;
	static int[][] memo;
	static final int maxa = 100*100;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		as = new int[n];
		bs = new int[n];
		int totalA = 0;
		for(int i=0;i<n;i++) {
			as[i] = in.nextInt();
			totalA += as[i];
		}
		for(int i=0;i<n;i++)
			bs[i] = in.nextInt();
		int[] bsSorted = bs.clone();
		Arrays.sort(bsSorted);
		
		int mink = 0;
		int curA = 0;
		for(int j=bsSorted.length-1;j>=0;j--) {
			if(curA >= totalA) break;
			curA += bsSorted[j];
			mink++;
		}
		memo = new int[mink+1][maxa+1];
		for(int[] arr1 : memo)
			Arrays.fill(arr1, inf);
		
		int minAns = inf;
		memo[0][0] = 0;
		for(int idx=0;idx<n;idx++) {
			for (int ku = mink; ku >=0; ku--) {
				for(int a=0;a<=maxa;a++) {
					int ans = inf;
					ans = Math.min(ans, memo[ku][a]+as[idx]);
					if(ku > 0 && a-bs[idx] >= 0)
						ans = Math.min(ans, memo[ku-1][a-bs[idx]]);
					memo[ku][a] = ans;
					if(idx == n-1 && a >= totalA && ku == mink)
						minAns = Math.min(minAns, ans);
				}
			}
		}
		System.out.println(mink + " " + minAns);
	}
}
