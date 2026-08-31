import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			int[] p = new int[n];
			IntStream.range(0, n).forEach(i -> p[i] = scanner.nextInt());
			System.out.println(getResult(p, 0));
		}
	}

	/**
	 * @param p     数字の配列
	 * @param start 開始インデックス
	 * @return 最小の入替え数
	 */
	private static int getResult(int[] p, int start) {
		int next = -1;
		for (int i = start; i < p.length; i++) {
			if ((i + 1) == p[i]) {
				next = i;
				break;
			}
		}
		if (next >= 0) {
			int result = Integer.MAX_VALUE;
			if (next == p.length - 1) {
				result = getResult(swap(p, next - 1), next - 1) + 1;
			} else {
				result = getResult(swap(p, next), next) + 1;
			}
			return result;
		}
		return 0;
	}

	/**
	 * @param p     数字の配列
	 * @param index インデックス
	 * @return 数字の配列のインデックスとインデックス＋1の要素を入替えた配列
	 */
	private static int[] swap(int[] p, int index) {
		int temp = p[index];
		p[index] = p[index + 1];
		p[index + 1] = temp;
		return p;
	}
}
