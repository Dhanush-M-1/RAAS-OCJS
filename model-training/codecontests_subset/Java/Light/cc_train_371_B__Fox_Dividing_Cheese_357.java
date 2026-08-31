//package ladderB;

import java.util.HashMap;
import java.util.Scanner;

public class foxDividingCheese {
	static int INF = (int)1e9;
	static HashMap<Integer, Integer> memo;
	static int gcd(int one, int two) {
		if(two==0)return one;
		return gcd(two, one%two);
	}
	static int minWays(int cur) {
		if(cur==1)
		{
			int ans = 0;
			memo.put(cur,ans);
			return ans;
		}
		if(memo.containsKey(cur))
			return memo.get(cur);
		int two = INF;
		int three =INF;
		int four =INF;
		int five = INF;
		if(cur%2==0)
			two = minWays(cur/2)+1;
		if(cur%3==0)
			three = minWays(cur/3)+1;
		if(cur%5==0)
			three = minWays(cur/5)+1;
		int min = Math.min(two, Math.min(three, Math.min(four, five)));
		if(min>=INF)
		{
			memo.put(cur,INF);
			return INF;
		}else {
			memo.put(cur, min);
			return min;
		}
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int one = sc.nextInt();
	int two = sc.nextInt();
	int gcd = gcd(one,two);
	memo = new HashMap<Integer,Integer>();
	one/=gcd;
	two/=gcd;
	if(one ==two)
			System.out.println(0);
	else {
		int firstOne = minWays(one);
		int secondOne = minWays(two);
		//System.out.println(firstOne+" "+secondOne+" "+one+" "+two);
		if(firstOne==INF|| secondOne == INF)
			System.out.println(-1);
		else System.out.println(firstOne+secondOne);
	}
}
}
