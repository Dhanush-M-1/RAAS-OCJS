import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int i = 0;
		boolean[][] card = new boolean[4][13];

		while(true) {
			if(n == i) break;

			String mark = sc.next();
			int no = sc.nextInt();
			switch (mark) {
			case "S":
				card[0][no-1] = true;
				break;

			case "H":
				card[1][no-1] = true;
				break;

			case "C":
				card[2][no-1] = true;
				break;

			case "D":
				card[3][no-1] = true;
				break;
			}
			i++;
		}

		for(int j = 0; j < 4; j++) {
			for(int k = 0; k < 13; k++) {
				if(!card[j][k]) {
					if(j == 0) {
						System.out.println("S " + (k + 1));
					} else if(j == 1) {
						System.out.println("H " + (k + 1));
					} else if(j == 2) {
						System.out.println("C " + (k + 1));
					} else {
						System.out.println("D " + (k + 1));
					}
				}
			}
		}
	}

}
