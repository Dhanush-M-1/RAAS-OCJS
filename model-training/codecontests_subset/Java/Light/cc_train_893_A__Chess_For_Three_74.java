import java.util.Scanner;

public class a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int loser = 3;
		for(int i = 0; i < n; i++) {
			int t = in.nextInt();
			if(t == loser) {
				System.out.println("NO");
				return;
			}
			for(int j = 1; j < 4; j++) {
				if(j != t && j != loser) {
					loser = j;
					break;
				}
			}
		}
		System.out.println("YES");
	}
}
