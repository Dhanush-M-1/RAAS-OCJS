import java.util.*;
public class CF510D_FoxAndJumping {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		v = new int[n];
		c = new int[n];
		memo = new HashMap<Long, Integer>();
		for(int i = 0; i < n; i ++) v[i] = in.nextInt();
		for(int i = 0; i < n; i ++) c[i] = in.nextInt();
		int ans = tol(0,0);
		System.out.println(ans == 2000000 ? -1 : ans);
	}
	
	public static int tol(int g, int p){
		
		if(p == n && g == 1) return 0;
		if(p == n) return 2000000;
		long enc = encode(g, p);
		if(memo.containsKey(enc)) return memo.get(enc);
		int min = Math.min(tol(gcd(g, v[p]), p + 1) + c[p], tol(g, p + 1)); 
		memo.put(encode(g, p), min);
		return min;
	}
	
	public static long encode(int a, int b){
		return (long)a*305l + b;
	}
	public static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, a % b);
	}
	
	static int[] v;
	static int[] c;
	static HashMap<Long, Integer> memo;
	static int n;
}
