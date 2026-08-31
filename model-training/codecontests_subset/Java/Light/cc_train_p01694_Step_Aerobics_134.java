import java.util.Scanner;

public class Main {
	void run() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}

			int flg = -1;
			int l = -1, r = -1;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				if (s.equals("lu")) l *= -1;
				if (s.equals("ru")) r *= -1;
				if (s.equals("ld")) l *= -1;
				if (s.equals("rd")) r *= -1;
				
				if (l == 1 && r == 1 && flg == -1) {
					cnt++;
					flg *= -1;
				}
				if (l == -1 && r == -1 && flg == 1) {
					cnt++;
					flg *= -1;
				}
			}
			System.out.println(cnt);
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}