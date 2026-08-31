import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int a = 0;
		int b = 0;
		int n = 0;
		String c;
		char d[] = new char[] {'S', 'H', 'C', 'D'};
		boolean cards[][] = new boolean[4][13];

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for(int i=0; i<n; i++) {
			c = sc.next();  //マークの読み込み
			b = sc.nextInt() - 1;  //数字の読み込み

			switch(c) {
				case "S":
					a = 0;
					break;
				case "H":
					a = 1;
					break;
				case "C":
					a = 2;
					break;
				case "D":
					a = 3;
					break;
			}

			for(int j=0; j<4; j++) {
				for(int k=0; k<13; k++) {
					if(j == a && k == b) {
						cards[j][k] = true;
					}
				}
			}
		}

		for(int i=0; i<4; i++) {
			for(int j=0; j<13; j++) {
				if(cards[i][j] == false) {
					System.out.print(d[i] + " ");
					System.out.println(String.format("%d",j+1));
				}
			}
		}

	}
}

