import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[][] card = new boolean[4][13];
		String markList[] = { "S", "H", "C", "D" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] cardTemp = br.readLine().split(" ");
			int mark = 0;
			switch (cardTemp[0]) {
			case "S":
				mark = 0;
				break;
			case "H":
				mark = 1;
				break;
			case "C":
				mark = 2;
				break;
			case "D":
				mark = 3;
				break;
			}
			int number = Integer.parseInt(cardTemp[1]);

			card[mark][number - 1] = true;
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				if (card[i][j] == false) {
					System.out.println(markList[i] + " " + (j + 1));
				}
			}
		}
	}

}