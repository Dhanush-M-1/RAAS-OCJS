import java.util.*;

public class D317 {
	static long[][] memo;
	static int[] a;
	static int val1;
	static int k;
	static long oo = Long.MAX_VALUE/5000;
	public static void main(String[] args) {
		
		Scanner qwe = new Scanner(System.in);
		
		int n = qwe.nextInt();
		k = qwe.nextInt();
		
		a = new int[n];
		int numt1 = 0;
		val1 = (int)(Math.ceil((double)(n)/k));
		for (int i = 0; i < a.length; i++) {
			a[i] =qwe.nextInt();
			if(i < k && (int)(Math.ceil((double)(n-i)/k)) == val1) numt1++;
		}
		Arrays.sort(a);
		long sum = 0;
		for(int i =1; i < a.length; i++){
			sum += a[i]-a[i-1];
		}
		
		//System.out.println("numt1: " + numt1 + " val1: " + val1);
		
		memo = new long[numt1+1][k-numt1+1];
		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = -1;
			}
		}
		
		if(k > 1)
			sum -= dp(numt1,k-numt1);
		
		
		System.out.println(sum);
		
		qwe.close();
	}
	
	static long dp(int t1, int t2){
		if(t1 < 0 || t2 < 0) return -oo;
		if(memo[t1][t2] != -1) return memo[t1][t2];
		int index = k-t1-t2;
		if(index == k-1) return 0;
		int sdex = 0;
		int usedt1 = memo.length-1-t1;
		int usedt2 = memo[0].length-1-t2;
		sdex += usedt1*val1;
		sdex += usedt2*(val1-1);
		
		long ret = -oo;
		if(t1 > 0)
			ret = Math.max(a[sdex+val1]-a[sdex+val1-1]+dp(t1-1,t2), ret);
		if(t2 > 0)
			ret = Math.max(a[sdex+val1-1]-a[sdex+val1-2]+dp(t1,t2-1),ret);
		
		return memo[t1][t2] = ret;
	}

}