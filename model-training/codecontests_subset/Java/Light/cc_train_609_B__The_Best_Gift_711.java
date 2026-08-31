//package education.round3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheBestGift {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] parts = br.readLine().split(" ");
		int n = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);

		int counts[] = new int[m + 1];
		parts = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			counts[Integer.parseInt(parts[i])]++;
		}

		int result = 0;
		for (int i = 0; i < m + 1; i++) {
			//System.out.println(counts[i]);
			for (int j = i+1; j < m + 1; j++) {
				result += counts[i] * counts[j];
			}
		}

		System.out.println(result);
	}
}
