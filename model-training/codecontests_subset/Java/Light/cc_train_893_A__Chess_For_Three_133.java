import java.util.Scanner;

public class A893ChessForThree {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int game = 0;
		boolean pos = true;
		//0 = AB 1 == AC 2 == BC
		for (int i = 0; i < n; i++) {
			int t = in.nextInt();
			if (pos) {
				if (game == 0) {
					if (t == 1) {
						game = 1;
					} else if (t == 2) {
						game = 2;
					} else {
						pos = false;
					}
				} else if (game == 1) {
					if (t == 1) {
						game = 0;
					} else if (t == 2) {
						pos = false;
					} else {
						game = 2;
					}
				} else {
					if (t == 1) {
						pos = false;
					} else if (t == 2) {
						game = 0;
					} else {
						game = 1;
					}
				}
				
			}
		}
		System.out.println((pos) ? "YES" : "NO");
	}
	
}
