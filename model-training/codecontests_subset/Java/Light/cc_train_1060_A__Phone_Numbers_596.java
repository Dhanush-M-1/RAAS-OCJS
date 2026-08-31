import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String s = sc.next();

		String[] s2 = s.split("");
		int m = 0;
		for (String s3 : s2) {
			int x = Integer.valueOf(s3);
			if (x == 8) {
				m++;
			}
		}
		int x = n / 11;
		int ans = m < x ? m : x;
		System.out.println(ans);
		sc.close();

	}

}