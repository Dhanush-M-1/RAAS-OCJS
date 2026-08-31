import java.util.*;

public class D {
	static int[] len, costArr;
	static int N;
	static HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<Integer, HashMap<Integer, Integer>>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		len = new int[N];
		costArr = new int[N];
		for (int i = 0; i < N; i++) {
			len[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			costArr[i] = sc.nextInt();
		}
		System.out.println(dp(0, 0));
	}
	
	static int dp(int curIdx, int curGcd) {
		//System.out.println("HOLD CURIDX: " + curIdx + " curGcd: " + curGcd);
		if (curGcd == 1) return 0;
		if (curIdx >= N) return -1;
		HashMap<Integer, Integer> get = map.get(curGcd);
		if (get != null) {
			Integer res = get.get(curIdx);
			if (res != null) return res;
		} else {
			get = new HashMap<Integer, Integer>();
			map.put(curGcd, get);
		}
		int cost = dp(curIdx+1, gcd(len[curIdx], curGcd));
		if (cost == -1) 
			cost = dp(curIdx+1, curGcd);
		else {
			cost += costArr[curIdx];
			int res = dp(curIdx+1, curGcd);
			if (res != -1)
				cost = Math.min(cost, res);
		}
		//System.out.println("CURIDX: " + curIdx + " curGcd: " + curGcd);
		//System.out.println("COST: " + cost);
		get.put(curIdx, cost);
		return cost;
	}
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		
		return gcd(b, a%b);
	}
}