import java.util.*;

public class Main {
	static long gcd(long a,long b) {
		if(b == 0)return a;
		return gcd(b,a % b);
	}
	static boolean check(long a,long b,long c,long d) {
		if(a < b || d < b)return false;
		if(c + 1 >= b)return true;
		///如果某天之后  剩下的多于c(不需要增加）  但是却小于b 那么次日肯定不够 
		///实际上就是c < a - bx + dy < b有解的话就是No 
		///移项的a - b < bx - dy < a - c
		///根据欧几里德扩展定理 就是说(a-b,a-c)之间是否有gcd(b,d)的倍数 即是否有解
		long g = gcd(b,d);
		return (a - c - 1) / g - (a - b) / g <= 0;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for(int i = 0;i < t;i ++) {
			long a = in.nextLong();
			long b = in.nextLong();
			long c = in.nextLong();
			long d = in.nextLong();
			if(check(a,b,c,d))System.out.println("Yes");
			else System.out.println("No");
		}
	}

}
