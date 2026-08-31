import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		boolean[][] ar = new boolean[4][13];
		for ( int i = 1; i <= n; i++ ) {
			String suit = scan.next();
			int rank = scan.nextInt();
			if ( suit.equals("S") ) {ar[0][rank-1] = true;}
			if ( suit.equals("H") ) {ar[1][rank-1] = true;}
			if ( suit.equals("C") ) {ar[2][rank-1] = true;}
			if ( suit.equals("D") ) {ar[3][rank-1] = true;}
		}
		for ( int i = 0; i < 4; i++ ) {
			for ( int j = 0; j < 13; j++ ) {
				if ( ar[i][j] == false ) {
					if ( i == 0 ) { System.out.println("S " + (j+1));}
					if ( i == 1 ) { System.out.println("H " + (j+1));}
					if ( i == 2 ) { System.out.println("C " + (j+1));}
					if ( i == 3 ) { System.out.println("D " + (j+1));}
				}
 			}
		}
	}
}