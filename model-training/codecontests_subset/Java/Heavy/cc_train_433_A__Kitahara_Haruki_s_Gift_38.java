import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KitaharaGift {

	public static void main(String[] args) throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String input;

			while ((input = reader.readLine()) != null && input.length() > 0) {
				int appleNumber = Integer.parseInt(input.trim());
				StringTokenizer data = new StringTokenizer(reader.readLine());
				int[] weights = new int[appleNumber];

				for (int i = 0; i < appleNumber; i++) {
					weights[i] = Integer.parseInt(data.nextToken());
				}
				if (canDivide(weights)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	private static boolean canDivide(int[] data) {
		Arrays.sort(data);
		int index = data.length - 1;
		int sum1 = 0;
		int sum2 = 0;

		while (index >= 0) {
			sum1 += data[index--];

			while (index >= 0 && sum2 < sum1) {
				sum2 += data[index--];
			}
		}
		return sum1 == sum2;
	}
}