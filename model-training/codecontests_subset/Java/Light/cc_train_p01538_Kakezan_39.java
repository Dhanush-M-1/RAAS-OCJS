import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int amount = Integer.parseInt(br.readLine());

		for (int i = 0; i < amount; i++) {
			String input = br.readLine();
			count_prod(input);
			System.out.println(count);
		}
	}

	public static void count_prod(String input) {
		int number = Integer.parseInt(input);
		count = 0;
		while (number > 9) {
			count++;
			number = prod(String.valueOf(number));
		}
	}

	public static int prod(String input) {
		int length = input.length();
		int max = 0;
		for (int i = 0; i < length - 1; i++) {
			int left, right;
			left = Integer.parseInt(input.substring(0, i + 1));
			right = Integer.parseInt(input.substring(i + 1));
			if (max < left * right) {
				max = left * right;
			}
		}
		return max;
	}

}

