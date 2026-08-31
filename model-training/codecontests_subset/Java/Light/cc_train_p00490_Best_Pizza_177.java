import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws java.io.IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		Integer[] cal = new Integer[n];
		for (int i = 0; i < n; i++) {
			cal[i] = sc.nextInt();
		}Arrays.sort(cal, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b-a;
            }});

		double max = 0;
		for (int i = 0; i <= n; i++) {
			int sum = c;
			for (int j = 0; j < i; j++) {
				sum += cal[j];
			}
			max = Math.max(max, 1.0 * sum / (a + i * b));
		}
		System.out.println((int)max);
	}
}