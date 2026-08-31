
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int m, n, i, j;
		String mark = "NULL";
		
		int cards[][];
		cards = new int[4][13];
		
		for(i = 0; i < 4; i++) {
			for(j = 0; j < 13; j++) {
				cards[i][j] = 0;
			}
		}
		
		
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		for(i = 0; i < n; i++) {
			
			mark = scan.next();
			m = scan.nextInt();
			
			if(mark.equals("S")) {
				cards[0][m-1] = 1;
			} else if (mark.equals("H")) {
				cards[1][m-1] = 1;
			} else if (mark.equals("C")) {
				cards[2][m-1] = 1;
			} else if (mark.equals("D")) {
				cards[3][m-1] = 1;
			}
		}
		
		
		
		for(i = 0; i < 4; i++) {
			switch(i) {
			case 0 : mark = "S"; break;
			case 1 : mark = "H"; break;
			case 2 : mark = "C"; break;
			case 3 : mark = "D"; break;
			}
			for(j = 0; j < 13; j++) {
				if(cards[i][j] == 0) {
					System.out.println(mark + " " + (j + 1));
				}
			}
		}
	}
}
