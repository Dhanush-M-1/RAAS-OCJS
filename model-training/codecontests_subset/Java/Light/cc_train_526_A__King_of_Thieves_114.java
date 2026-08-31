import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] segments = sc.next().toCharArray();
		sc.close();

		for (int start = 0; start < N; start++) {
			if (segments[start] == '.') {
				continue;
			}
			for (int jump = 1; jump < N; jump++) {
				int now = start;
				for (int i = 0; i < 4; i++) {
					now += jump;
					if (now >= N || segments[now] == '.') {
						break;
					}
					if (i == 3) {
						System.out.println("yes");
						return;
					}
				}
			}
		}
		System.out.println("no");
	}
}
