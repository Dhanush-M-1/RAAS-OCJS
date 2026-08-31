import java.util.Scanner;

public class p1382A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt(), m = sc.nextInt(), c = 0;
			int a[] = new int[n];
			int b[] = new int[m];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				b[i] = sc.nextInt();
			}
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (b[i] == a[j]) {
						++c;
						System.out.println("YES");
						System.out.println("1 " + b[i]);
						break;
					}
					if(c>0)
						break;
				}
				if(c>0)
					break;
			}

			if (c == 0)
				System.out.println("NO");

		}
	}
}
