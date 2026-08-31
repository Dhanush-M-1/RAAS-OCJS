import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			ArrayList<String> str = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				String s = br.readLine();
				str.add(s);
			}

			int wordSum = 0;
			int goro[] = { 5, 7, 5, 7, 7 };
			int goroI = 0;
			boolean flag = false;
			int ans = 0;

			for (int i = 0; i < n; i++) {
				for (int j = i; j < n; j++) {
					wordSum += str.get(j).length();
					if (goro[goroI] < wordSum) {
						goroI = 0;
						wordSum = 0;
						break;
					}
					if (goro[goroI] == wordSum) {
						goroI++;
						wordSum = 0;
						if (goroI == 5) {
							flag = true;
							ans = i + 1;
							break;
						}
					}
				}
				if (flag)
					break;
			}
			System.out.println(ans);
		}
	}

}
