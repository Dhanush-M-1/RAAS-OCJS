import java.util.HashSet;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int xi = sc.nextInt();
			for (int j = 0; j < xi; j++) {
				int yij = sc.nextInt();
				set.add(yij);
			}
		}
		if (set.size() < m) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

		sc.close();

	}

}