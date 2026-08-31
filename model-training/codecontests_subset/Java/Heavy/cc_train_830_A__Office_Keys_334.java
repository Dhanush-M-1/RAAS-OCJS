import java.util.Arrays;
import java.util.Scanner;

public class OfficeKeys {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(), k = in.nextInt(), p = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = in.nextInt();
		int[] b = new int[k];
		for (int i = 0; i < k; i++) b[i] = in.nextInt();
		Arrays.sort(a);
		Arrays.sort(b);
		int solution = -1;
		for (int i = 0; i < k - n + 1; i++) {
			int currMax = -1;
			for (int j = 0; j < n; j++) {
					if ((Math.abs(a[j] - b[i+j]) + Math.abs(p - b[i+j]) > currMax) || (currMax == -1))
						currMax = Math.abs(a[j] - b[i+j]) + Math.abs(p - b[i+j]);
			}
			if ((currMax < solution) || (solution == -1)) solution = currMax;
		}
		System.out.println(solution);
		
		in.close();
				
	}
}
