import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProblemA implements Comparator<Integer> {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);

		int n, target;

		n = input.nextInt();
		target = input.nextInt();

		Integer[] values = new Integer[n];
		for (int i = 0; i < values.length; i++) {
			values[i] = input.nextInt();
		}

		Arrays.sort(values, new ProblemA());
		for (int i = 0; i < values.length; i++) {
			if (target % values[i] == 0) {
				System.out.println(target / values[i]);
				return;
			}
		}

	}

	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg1.compareTo(arg0);
	}

}