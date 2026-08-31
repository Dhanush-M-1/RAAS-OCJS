import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.jws.Oneway;

public class treasre {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String string = reader.readLine();
		int lastTreasurePosition = -1;
		int balancedOne = 0;
		int balancedTwo = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '#') {
				lastTreasurePosition = i;
				balancedOne--;
				continue;
			}
			if (string.charAt(i) == ')') {
				balancedOne--;
				continue;
			}
			balancedOne++;
		}
		if (balancedOne < 0 || lastTreasurePosition == -1) {
			System.out.println(-1);
			return;
		}
		balancedOne++;
		for (int i = 0; i < string.length(); i++) {
			if (i == lastTreasurePosition) {
				balancedTwo -= balancedOne;

			} else if (string.charAt(i) == '(') {
				balancedTwo++;
			} else {
				balancedTwo--;
			}
			if (balancedTwo < 0) {
				System.out.println(-1);
				return;
			}
		}

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != '#') {
				continue;
			}
			if (lastTreasurePosition == i) {
				System.out.println(balancedOne);
				continue;
			}
			System.out.println(1);
		}
	}
}
