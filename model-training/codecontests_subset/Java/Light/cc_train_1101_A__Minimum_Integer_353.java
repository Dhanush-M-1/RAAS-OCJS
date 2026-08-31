import java.util.Scanner;

/*
 * https://codeforces.com/contest/1101/problem/A
 */
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = Integer.parseInt(s.nextLine());
		for (int i = 0; i < q; i++) {
			String[] str = s.nextLine().split(" ");
			System.out.println(findMin(Long.parseLong(str[0]), Long.parseLong(str[1]), Long.parseLong(str[2])));
		}
	}

	private static long findMin(long l, long r, long d) {
		if (d < Math.min(l, r)) {
			return d;
		}
		if (Math.max(l, r) % d == 0) {
			return Math.max(l, r) + d;
		}
		return d + Math.max(l, r) - Math.max(l, r) % d;

	}

}
