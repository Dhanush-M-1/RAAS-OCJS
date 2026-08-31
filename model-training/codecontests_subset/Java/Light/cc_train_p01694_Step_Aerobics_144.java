import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static String ok[] = { "luru", "rulu", "ldrd", "rdld" };

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			String str[] = br.readLine().split(" ");

			if (str.length == 1) {
				System.out.println("0");
				continue;
			}

			int ans = 0;

			for (int i = 0; i < n - 1; i += 2) {
				String action = str[i] + str[i + 1];
				for (int j = 0; j < ok.length; j++) {
					if (ok[j].equals(action)) {
						ans++;
						break;
					}
				}
			}
			System.out.println(ans);
		}
	}
}
