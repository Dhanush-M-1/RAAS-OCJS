import java.util.Scanner;

public class B754 {
	
	static boolean isWinning(char[][] board){
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(i <= 1 && board[i][j] == 'x' && board[i+1][j] == 'x' && board[i+2][j] == 'x') return true;
				if(j <= 1 && board[i][j] == 'x' && board[i][j+1] == 'x' && board[i][j+2] == 'x') return true;
				if(i <= 1 && j <= 1 && board[i][j] == 'x' && board[i+1][j+1] == 'x' && board[i+2][j+2] == 'x') return true;
				if(i >= 2 && j <= 1 && board[i][j] == 'x' && board[i-1][j+1] == 'x' && board[i-2][j+2] == 'x') return true;
			}
		}
		return false;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		char[][] board = new char[4][4];
		for(int i = 0; i < 4; i++) board[i] = in.next().toCharArray();
		boolean win = false;
		for(int i = 0; i < 4; i++){
			for(int j = 0; j < 4; j++){
				if(board[i][j] == '.'){
					board[i][j] = 'x';
					if(isWinning(board)) win = true;
					board[i][j] = '.';
				}
			}
		}
		if(win) System.out.println("YES");
		else System.out.println("NO");
		in.close();
	}
}
 