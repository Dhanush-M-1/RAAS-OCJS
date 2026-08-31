import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[][] num = new int[4][13];
		for (int i = 0; i < n; i++) {
			String mark = scan.next();
			int innum = scan.nextInt();
			if (mark.equals("S")) {
				num[0][innum-1] = 1;
			}
			else if (mark.equals("H")) {
				num[1][innum-1] = 1;
			}
			else if (mark.equals("C")) {
				num[2][innum-1] = 1;
			}
			else if (mark.equals("D")) {
				num[3][innum-1] = 1;
			}
		}
		for (int k = 0; k < 4; k++) {
			for (int m = 0; m < 13; m++) {
				if (num[k][m] == 0) {
					int l = m;
					l++;
					if (k == 0) System.out.println("S " + l);
					else if (k == 1) System.out.println("H " + l);
					else if (k == 2) System.out.println("C " + l);
					else if (k == 3) System.out.println("D " + l);
				}
			}
		}
	}
}
