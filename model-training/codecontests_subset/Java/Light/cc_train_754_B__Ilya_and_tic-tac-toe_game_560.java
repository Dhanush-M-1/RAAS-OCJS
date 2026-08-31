import java.util.Scanner;


public class b {
	static int[] dx = {0,1,0,-1,1,-1,1,-1};
	static int[] dy = {1,0,-1,0,1,-1,-1,1};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char[][] board = new char[4][4];
		for (int i = 0; i < board.length; i++) {
			board[i] = in.nextLine().toCharArray();
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == 'x'){
					for (int k = 0; k < dx.length; k++) {
						if(i+2*dx[k] < 4 && i+2*dx[k] >=0 &&j+2*dy[k] < 4 && j+2*dy[k] >=0 ){
							if(board[i+2*dx[k]][j+2*dy[k]] != 'o' && board[i+dx[k]][j+dy[k]] != 'o'){
								if(board[i+2*dx[k]][j+2*dy[k]] == 'x' || board[i+dx[k]][j+dy[k]] == 'x'){
									System.out.println("YES");
									return;
								}
							}
						}
					}
				}
			}
		}
		System.out.println("NO");
	}

}
