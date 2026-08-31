import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br =
				new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int target = Integer.parseInt(br.readLine());
			if (target == 0) break;
			int sum = 0, ans = 0;
			for (int i = 1; i <= 12; i++) {
				String[] str = br.readLine().split(" ");
				sum += Integer.parseInt(str[0]) - Integer.parseInt(str[1]);
				if (sum >= target && ans == 0) ans = i;
			}
			System.out.println(ans == 0 ? "NA" : ans);
		}

	}

}