import java.util.Scanner;

public class WizeGems {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int d1 = sc.nextInt();
		int d2 = sc.nextInt();
		int i = 0, j = 0, k = 0, l = 0;
		boolean f = true;
		for (i = 1; i < 10 && f; i++) {
			for (j = 1; j < 10 && f; j++) {
				if (j == i)
					j++;
				for (k = 1; k < 10 && f; k++) {
					if (k == i)
						k++;
					if (k == j)
						k++;
					for (l = 1; l < 10 && f; l++) {
						if (l == i)
							l++;
						if (l == j)
							l++;
						if (l == k)
							l++;
						if (i + j == r1 && i + k == c1 && i + l == d1
								&& j + l == c2 && k + l == r2 && j + k == d2)
							f = false;
					}
				}
			}
		}
		i--;
		j--;
		k--;
		l--;
		if (i > 9 || j > 9 || k > 9 || l > 9)
			System.out.println(-1);
		else
			System.out.println(i + " " + j + "\n" + k + " " + l + "\n");
	}
}
