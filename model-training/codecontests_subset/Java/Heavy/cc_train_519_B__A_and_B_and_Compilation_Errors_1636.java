
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created: 2/1/2018
 *
 * @author phil
 */
public class B519_AAndBAndCompilationErrors {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int first[] = new int[n];
		int second[] = new int[n-1];
		int third[] = new int[n-2];

		int firstError = 0;
		int secondError = 0;

		for (int i = 0; i < n; i++) {
			first[i] = sc.nextInt();
		}

		for (int i = 0; i < (n - 1); i++) {
			second[i] = sc.nextInt();
		}

		for (int i = 0; i < (n - 2); i++) {
			third[i] = sc.nextInt();
		}
		Arrays.sort(first);
		Arrays.sort(second);
		Arrays.sort(third);

		int i = 0;
		while (i < (n-1) && first[i] == second[i]) {
			i++;
		}
		firstError = first[i];

		i = 0;
		while (i < (n-2) && second[i] == third[i]) {
			i++;
		}
		secondError = second[i];

		System.out.println(firstError);
		System.out.println(secondError);
	}



}
