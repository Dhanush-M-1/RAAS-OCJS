
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
	static int[] breaks;
	static int num;
	static BigInteger[] patterns;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		int m = sc.nextInt();
		breaks = new int[m];
		patterns = new BigInteger[num + 3];
		for(int i = 0; i < m; i++){
			breaks[i] = sc.nextInt();
		}
		BigInteger devider = new BigInteger("1000000007");
		System.out.println(pattern(0).remainder(devider).longValue());
	}
	static BigInteger pattern(int p){
		if(patterns[p] != null){
			return patterns[p];
		}
		if(p == num){
			patterns[p] = BigInteger.ONE;
			return patterns[p];
		}
		if(p > num){
			patterns[p] = BigInteger.ZERO;
			return patterns[p];
		}
		for(int i = 0; i < breaks.length; i++){
			if(p == breaks[i]){
				patterns[p] = BigInteger.ZERO;
				return patterns[p];
			}
		}
		patterns[p] = pattern(p + 1).add(pattern(p + 2));
		return patterns[p];
	}
}
