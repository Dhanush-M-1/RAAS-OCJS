import java.util.Scanner;
import java.util.stream.IntStream;

import javax.script.ScriptException;

public class Main {

	/** 時間帯の数 */
	private static final Integer TIME = 10;

	public static void main(String[] args) throws ScriptException {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			scanner.nextLine();
			// 各店舗の営業時間帯の配列
			int[] f = new int[n];
			IntStream.range(0, n).forEach(i -> f[i] = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""), 2));
			// 利益の配列
			int[][] p = new int[n][TIME + 1];
			IntStream.range(0, n)
					.forEach(i -> IntStream.rangeClosed(0, TIME).forEach(j -> p[i][j] = scanner.nextInt()));
			System.out.println(IntStream.range(1, pow(2, TIME)).map(i -> calcResult(i, n, f, p)).max().getAsInt());
		}
	}

	/**
	 * nのmべき乗を返す
	 * 
	 * @param n
	 * @param m
	 * @return nのmべき乗
	 */
	private static int pow(int n, int m) {
		int result = 1;
		while (m > 0) {
			if (1 == (m & 1)) {
				result *= n;
			}
			n *= n;
			m >>= 1;
		}
		return result;
	}

	/**
	 * 現在の営業時間帯で得られる利益を計算する
	 * 
	 * @param t 現在の営業時間帯
	 * @param n 店舗の数
	 * @param f 各店舗の営業時間帯
	 * @param p 利益の配列
	 * @return 現在の営業時間帯で得られる利益
	 */
	private static int calcResult(int t, int n, int[] f, int[][] p) {
		return IntStream.range(0, n).map(i -> p[i][sameCount(t, f[i])]).sum();
	}

	/**
	 * 2つの店舗の営業時間帯が同じものカウントを計算する
	 * 
	 * @param t1 営業時間帯1
	 * @param t2 営業時間帯2
	 * @return 2つの店舗の営業時間帯が同じものカウント
	 */
	private static int sameCount(int t1, int t2) {
		return Integer.bitCount(t1 & t2);
	}
}
