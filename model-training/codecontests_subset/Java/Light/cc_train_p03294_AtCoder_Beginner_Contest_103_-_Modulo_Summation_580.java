import java.util.Scanner;

public class Main { // https://atcoder.jp/contests/abc103/tasks/abc103_c
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		int n = x.nextInt();
		long res = 0;
		for (int i = 0; i < n; i++) {
			res += x.nextInt();
		}
		res -= n;
		System.out.println(res);
	}
}
