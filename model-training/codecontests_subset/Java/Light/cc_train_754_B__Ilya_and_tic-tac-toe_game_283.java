import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProblemB {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] tt = new char[8][8];
		for (int i=2; i<=5; i++) {
			String tmp = br.readLine();
			for (int j=2; j<=5; j++) {
				tt[i][j] = tmp.charAt(j-2);
			}
		}
		
		boolean canWin = false;
		for (int i=2; i<=5; i++) {
			for (int j=2; j<=5; j++) {
				if (tt[i][j] != '.') continue;
				
				if ((tt[i][j-1] == 'x' && (tt[i][j-2] == 'x' || tt[i][j+1] == 'x')) || tt[i][j+1] == 'x' && tt[i][j+2] == 'x') {
					canWin = true;
				} else if ((tt[i-1][j] == 'x' && (tt[i-2][j] == 'x' || tt[i+1][j] == 'x')) || tt[i+1][j] == 'x' && tt[i+2][j] == 'x') {
					canWin = true;
				} else if ((tt[i-1][j-1] == 'x' && (tt[i-2][j-2] == 'x' || tt[i+1][j+1] == 'x')) || tt[i+1][j+1] == 'x' && tt[i+2][j+2] == 'x') {
					canWin = true;
				} else if ((tt[i+1][j-1] == 'x' && (tt[i+2][j-2] == 'x' || tt[i-1][j+1] == 'x')) || tt[i-1][j+1] == 'x' && tt[i-2][j+2] == 'x') {
					canWin = true;
				}
				
				if (canWin) break;
			}
			if (canWin) break;
		}
		
		System.out.println(canWin?"YES":"NO");
	}
}
