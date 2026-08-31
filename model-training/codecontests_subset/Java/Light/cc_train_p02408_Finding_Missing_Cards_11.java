import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[][] t = new boolean[4][13];
	
		for(int i = 0; i < n; i++) {
			char egara = scan.next().charAt(0);
			int number = scan.nextInt();
			
			switch(egara) {
			case 'S':
				t[0][number-1] = true;
				break;
			case 'H':
				t[1][number-1] = true;
				break;
			case 'C':
				t[2][number-1] = true;
				break;
			case 'D':
				t[3][number-1] = true;
				break;
			}
		}

		char[] check = {'S', 'H', 'C', 'D'};
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 13; j++) {
				if(!t[i][j]) {
					System.out.println(check[i] + " " + (j + 1));
				}
			}
		}
		
		
	}

}

