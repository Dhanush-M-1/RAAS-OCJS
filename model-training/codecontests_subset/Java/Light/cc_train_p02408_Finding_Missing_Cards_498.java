import java.util.*;

class Main {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		boolean[][] card = new boolean[4][13];
		int n = sc.nextInt();
		for (int i=0; i<n; i++) {
			String s = sc.next();
			int a = sc.nextInt()-1;
			if (s.equals("S")) {
				card[0][a] = true;
			}
			else if (s.equals("H")) {
				card[1][a] = true;
			}
			else if (s.equals("C")) {
				card[2][a] = true;
			}
			else if (s.equals("D")) {
				card[3][a] = true;
			}
		}
		
		for (int i=0; i<4; i++) {
			for (int j=0; j<13; j++) {
				if (card[i][j] == false) {
					System.out.println((i==0?"S":i==1?"H":i==2?"C":"D")+" "+(j+1));
				}
			}
		}

	}
}
