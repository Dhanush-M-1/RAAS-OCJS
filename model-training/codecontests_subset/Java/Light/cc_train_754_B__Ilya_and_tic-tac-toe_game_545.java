import java.io.*;
import java.util.*;

public class CF754B {
	static boolean row(char[][] aa, int i, int j) {
		return i + 2 < 4 && aa[i][j] == 'x' && aa[i + 1][j] == 'x' && aa[i + 2][j] == 'x';
	}
	static boolean col(char[][] aa, int i, int j) {
		return j + 2 < 4 && aa[i][j] == 'x' && aa[i][j + 1] == 'x' && aa[i][j + 2] == 'x';
	}
	static boolean diag0(char[][] aa, int i, int j) {
		return i + 2 < 4 && j + 2 < 4 && aa[i][j] == 'x' && aa[i + 1][j + 1] == 'x' && aa[i + 2][j + 2] == 'x';
	}
	static boolean diag1(char[][] aa, int i, int j) {
		return i + 2 < 4 && j - 2 >= 0 && aa[i][j] == 'x' && aa[i + 1][j - 1] == 'x' && aa[i + 2][j - 2] == 'x';
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] aa = new char[4][4];
		for (int i = 0; i < 4; i++)
			br.readLine().getChars(0, 4, aa[i], 0);
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (aa[i][j] == '.') {
					aa[i][j] = 'x';
					for (int i_ = 0; i_ < 4; i_++)
						for (int j_ = 0; j_ < 4; j_++)
							if (row(aa, i_, j_) || col(aa, i_, j_) || diag0(aa, i_, j_) || diag1(aa, i_, j_)) {
								System.out.println("YES");
								return;
							}
					aa[i][j] = '.';
				}
		System.out.println("NO");
	}
}
