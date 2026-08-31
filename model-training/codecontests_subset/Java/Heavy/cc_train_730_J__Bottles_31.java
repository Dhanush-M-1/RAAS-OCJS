import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class J {
	static final int inf = (int)1e7;
	static int n;
	static int[] as,bs;
	static int[][][] memo;
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
		memo = new int[2][(mink+1)][maxa+1];
		for(int[][] arr2 : memo)
			for(int[] arr1 : arr2)
				Arrays.fill(arr1, inf);
		
		int par = 0;
		int minAns = inf;
		memo[par][0][0] = 0;
		for(int idx=0;idx<n;idx++) {
			par = 1-par;
			
			for (int ku = 0; ku <= mink; ku++) {
				Arrays.fill(memo[par][ku], inf);
				for(int a=0;a<=maxa;a++) {
					memo[par][ku][a] = Math.min(memo[par][ku][a], memo[1-par][ku][a]+as[idx]);
					if(ku > 0 && a-bs[idx] >= 0)
						memo[par][ku][a] = Math.min(memo[par][ku][a], memo[1-par][ku-1][a-bs[idx]]);
					if(idx == n-1 && a >= totalA && ku == mink)
						minAns = Math.min(minAns, memo[par][ku][a]);
				}
//				System.out.println("memo[" + idx + "][" + ku + "] = " + Arrays.toString(memo[par][ku]));
			}
		}
		System.out.println(mink + " " + minAns);
	}
}
