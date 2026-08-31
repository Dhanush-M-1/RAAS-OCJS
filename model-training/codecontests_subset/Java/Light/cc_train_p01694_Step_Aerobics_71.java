import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			int N = sc.nextInt();
			if (N == 0) break;
			boolean lu = false;
			boolean ru = false;
			boolean lt = true;
			boolean rt = true;
			int ans = 0;
			for (int i = 0; i < N; ++i) {
				char move = sc.next().charAt(0);
				if (move == 'l') {
					lu = !lu;
				} else {
					ru = !ru;
				}
				if (lu == lt && ru == rt) {
					++ans;
					lt = !lt;
					rt = !rt;
				}
			}
			System.out.println(ans);
		}
	}

}