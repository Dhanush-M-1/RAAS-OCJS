import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] cards = new int[4][13];
		int i, j;
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 13; j++) {
				cards[i][j] = 0;
			}
		}
		String ill;
		int num;
		for(i = 0; i < n; i++) {
			ill = sc.next();
			num = sc.nextInt();
			if(ill.equals("S")) {
				cards[0][num - 1] = 1;
			}
			if(ill.equals("H")) {
				cards[1][num - 1] = 1;
			}
			if(ill.equals("C")) {
				cards[2][num - 1] = 1;
			}
			if(ill.equals("D")) {
				cards[3][num - 1] = 1;
			}
		}

		for(i = 0; i < 4; i++) {
			for(j = 0; j < 13; j++) {
				if(cards[i][j] == 0) {
					if(i == 0)	System.out.printf("S %d\n", j + 1);
					if(i == 1)	System.out.printf("H %d\n", j + 1);
					if(i == 2)	System.out.printf("C %d\n", j + 1);
					if(i == 3)	System.out.printf("D %d\n", j + 1);
				}
			}
		}
	}
}

