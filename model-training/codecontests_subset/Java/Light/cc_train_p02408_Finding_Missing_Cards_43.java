import java.util.Scanner;

public class Main {

	final static String[] suits = {"S", "H", "C", "D"};
	final static int[] ranks = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};  
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		boolean[][] exist = new boolean[suits.length][ranks.length];
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			String suit = scan.next();
			int rank = scan.nextInt();
			for (int j = 0; j < suits.length; j++) {
				if (suits[j].equals(suit)) {
					exist[j][rank-1] = true;
				}
			}
		}

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				if (!exist[i][j]) {
					System.out.println(suits[i] + " " + ranks[j]);
				}
			}
		}

		scan.close();
	}

}