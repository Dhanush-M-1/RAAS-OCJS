import java.io.*;
import java.util.*;

public class Mafia {
	private static int n;
	private static long[] roundsPreference;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		n = in.nextInt();
		roundsPreference = new long[n];

		long sum = 0;
		for (int i = 0; i < n; i++) {
			roundsPreference[i] = in.nextLong();
			sum += roundsPreference[i];
		}

		long left = 1L, right = sum, best = 0L;
		while (left <= right) {
			long rounds = left + (right - left) / 2;

			if (check(rounds)) {
				best = rounds;
				right = rounds - 1;
			} else {
				left = rounds + 1;
			}
		}

		System.out.println(best);
	}

	public static boolean check(long rounds) {
		long canSupervise = 0L;

		for (int i = 0; i < n; i++) {
			if (roundsPreference[i] > rounds) {
				return false;
			}
			canSupervise += rounds - roundsPreference[i];
		}

		return canSupervise >= rounds;
	}
}
