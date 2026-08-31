import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		final char[] SUIT = {'S', 'H', 'C', 'D'};
		boolean[][] taroHas = new boolean[4][13];
		int n = scanner.nextInt();
		
		for (int i = 0; i < n; i++) {
			char s = scanner.next().charAt(0);
			int r = scanner.nextInt();
			
			for (int j = 0; j < 4; j++) {
				if (s == SUIT[j]) {
					taroHas[j][r - 1] = true;
					break;
				}
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (!taroHas[i][j])
					System.out.println(SUIT[i] + " " + (j + 1));
			}
		}
	}

}

