import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] x = sc.next().toCharArray();
		sc.close();

		int ans = 0;
		int cnt = 0;
		for (int i = 0; i < x.length; i++) {
			if (x[i] == 'S') {
				cnt++;
			} else {
				if (cnt > 0) {
					ans += 2;
					cnt--;
				}
			}
		}
		System.out.println(x.length - ans);
	}
}
