import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
	static int[] MASKS = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512 };
	static int DAY_NUM = 5, HOUR_NUM = 2;

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String[] tokens = in.readLine().split(" ");
		int N = Integer.parseInt(tokens[0]);
		boolean[][] F = new boolean[N][DAY_NUM * HOUR_NUM];
		for (int i = 0; i < N; ++i) {
			tokens = in.readLine().split(" ");
			for (int j = 0; j < DAY_NUM * HOUR_NUM; ++j) {
				F[i][j] = tokens[j].equals("1") ? true : false;
			}
		}
		int[][] P = new int[N][DAY_NUM * HOUR_NUM + 1];
		for (int i = 0; i < N; ++i) {
			tokens = in.readLine().split(" ");
			for (int j = 0; j <= DAY_NUM * HOUR_NUM; ++j) {
				P[i][j] = Integer.parseInt(tokens[j]);
			}
		}
		List<boolean[]> patterns = genPattern();
		long result = Long.MIN_VALUE / 2;
		for (boolean[] pattern : patterns) {
			result = Math.max(result, calcProfit(pattern, F, P));
		}
		System.out.println(result);

	}

	static long calcProfit(boolean[] pattern, boolean[][] F, int[][] P) {
		long result = 0;
		for (int i = 0; i < F.length; ++i) {
			int count = 0;
			for (int j = 0; j < 10; ++j) {
				if (pattern[j] && F[i][j]) {
					count++;
				}
			}
			result += (long) P[i][count];
		}
		return result;
	}

	static List<boolean[]> genPattern() {
		List<boolean[]> patterns = new ArrayList<>(1024);
		for (int i = 1; i < 1024; ++i) {
			patterns.add(genPattern(i));
		}
		return patterns;
	}

	static boolean[] genPattern(int value) {
		boolean[] pattern = new boolean[10];
		for (int i = 0; i < 10; ++i) {
			pattern[i] = (value & MASKS[i]) == 0 ? false : true;
		}
		return pattern;
	}
}