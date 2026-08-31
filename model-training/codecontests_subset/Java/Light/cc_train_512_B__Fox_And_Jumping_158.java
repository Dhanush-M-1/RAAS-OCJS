import java.awt.Point;
import java.util.HashMap;
import java.util.Scanner;

public class FoxAndJumping {
	public static final long MAX = (long)1e15;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] l = new int[n], c = new int[n];
		for(int i = 0 ; i < n ; i++) l[i] = scan.nextInt();
		for(int i = 0 ; i < n ; i++) c[i] = scan.nextInt();
		DynamicProgramming dp = new DynamicProgramming();
		long res = solve(0, 0, l, c, n, 0, dp);
		System.out.println(res == MAX?-1:res);
	}
	static long solve(int depth, int count, int[] l, int[] c, int n, int gcd, DynamicProgramming dp){
		Point curr = new Point(gcd, depth);
		if(gcd == 1) return 0;
		if(depth == n) return MAX;
		if(dp.contains(curr)) return dp.get(curr);
		long res = MAX;
		res = Math.min(solve(depth+1, count+1, l, c, n, gcd(gcd, l[depth]), dp) + c[depth], solve(depth+1, count, l, c, n, gcd, dp));
		dp.put(curr, res);
		return res;
	}
	static int min(int a, int b){return Math.min(a, b);}
	static int max(int a, int b){return Math.max(a, b);}
	static int gcd(int a, int b){
		if(b == 0) return a;
		return gcd(b, (a%b));
	}
	static class DynamicProgramming{
		HashMap<Point, Long> map = new HashMap<>();
		public DynamicProgramming(){}
		public long get(Point curr){return map.get(curr);}
		public void put(Point curr, long value){map.put(curr, value);}
		public boolean contains(Point curr){return map.containsKey(curr);}
	}
}
