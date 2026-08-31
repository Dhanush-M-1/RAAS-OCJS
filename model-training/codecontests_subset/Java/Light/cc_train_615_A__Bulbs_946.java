import java.util.Scanner;

public class bulbs {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		boolean[] bulbs = new boolean[m];
		boolean allOn = true;
		for (int i=0; i<n; i++) {
			int c = scan.nextInt();
			for (int j=0; j<c; j++) {
				int id = scan.nextInt();
				bulbs[id-1] = true;
			}
		}
		for (int i=0; i<m; i++) {
			if (!bulbs[i]) {
				allOn = false;
			}
		}
		if (allOn) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
