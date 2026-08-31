import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		new C();
	}
	
	private char[][] board;
	private int n;
	private int m;
	private int k;

	public C() {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		board = new char[n][m];
		
		int x = 0;
		int y = 0;
		
		int amountFree = 0;
		
		for (int i = 0; i < n; i++) {
			String row = sc.next();
			for (int j = 0; j < m; j++) {
				board[i][j] = row.charAt(j);
				if (board[i][j] == '.') {
					board[i][j] = 'X';
					x = i;
					y = j;
					amountFree++;
				}
			}
		}
		
		k = amountFree-k;
		
		if (k > 0) {
			board[x][y] = '.';
			k--;
			fill(x, y);
		}
		
		
		for (int i = 0; i < n; i++) {
			System.out.println(board[i]);
		}
		
		sc.close();
	}
	
	public void fill(int x, int y) {
		if (k == 0) return;
		if (x < (n-1) && board[x+1][y] == 'X') {
			if (k == 0) return;
			board[x+1][y] = '.';
			k--;
			fill(x+1, y);
		}
		if (x > 0 && board[x-1][y] == 'X') {
			if (k == 0) return;
			board[x-1][y] = '.';
			k--;
			fill(x-1, y);
		}
		if (y > 0 && board[x][y-1] == 'X') {
			if (k == 0) return;
			board[x][y-1] = '.';
			k--;
			fill(x, y-1);
		}
		if (y < (m-1) && board[x][y+1] == 'X') {
			if (k == 0) return;
			board[x][y+1] = '.';
			k--;
			fill(x, y+1);
		}
	}
}
