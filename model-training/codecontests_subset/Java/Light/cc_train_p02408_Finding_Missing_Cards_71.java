import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		int n = stdIn.nextInt();
		boolean[][] cards = new boolean[4][13];
		for (int i=0; i<n; i++) {
			String s = stdIn.next();
			switch (s.charAt(0)) {
				case 'S':cards[0][stdIn.nextInt()-1] = true; break;
				case 'H':cards[1][stdIn.nextInt()-1] = true; break;
				case 'C':cards[2][stdIn.nextInt()-1] = true; break;
				case 'D':cards[3][stdIn.nextInt()-1] = true; break;
			}
		}
		char[] c = {'S','H','C','D'};
		for (int i=0; i<4; i++) {
			for (int j=0; j<13; j++) {
				if (!cards[i][j]) {
					System.out.println(c[i]+" "+(j+1));
				}
			}
		}
	}
}