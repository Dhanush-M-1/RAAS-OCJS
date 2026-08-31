import java.util.Scanner;

public class one {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r1, r2, c1, c2, d1, d2;
		r1 = sc.nextInt();
		r2 = sc.nextInt();
		c1 = sc.nextInt();
		c2 = sc.nextInt();
		d1 = sc.nextInt();
		d2 = sc.nextInt();
		boolean[] v = new boolean[10];
		boolean check = true;
		for (int i = 1; i <= 9 && check; i++) {
			v[i] = true;
			for (int j = 1; j <= 9 && check; j++)
				if (!v[j]) {
					v[j] = true;
					for (int k = 1; k <= 9 && check; k++)
						if (!v[k]) {
							v[k] = true;
							for (int l = 1; l <= 9 && check; l++)
								if (!v[l]) {
									
									if (i + j == r1 && i + k == c1
											&& i + l == d1 && j + l == c2
											&& k + l == r2 && j + k == d2) {
										System.out.println(i + " " + j);
										System.out.println(k + " " + l);
										check = false;
									}
								}
							v[k] = false;
						}
					v[j] = false;
				}
			v[i] = false;
		}
		if (check)
			System.out.println(-1);

	}

}
