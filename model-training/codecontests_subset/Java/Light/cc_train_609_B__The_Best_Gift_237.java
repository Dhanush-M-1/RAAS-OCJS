import java.util.Scanner;


public class BestGift {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		int m = s.nextInt();
		long[] bs = new long[m+1];
		for(int i = 0; i < n; i++) {
			bs[s.nextInt()]++;
		}
		long res = 0;
		for(int i = 1; i <= m; i++) {
			for(int j = i+1; j <= m; j++) {
				res += (bs[i] * bs[j]);
			}
		}
		System.out.print(res);
	}

}
