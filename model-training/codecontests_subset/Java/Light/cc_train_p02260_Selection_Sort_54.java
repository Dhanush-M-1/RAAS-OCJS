import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String ns = br.readLine();
		int n = Integer.parseInt(ns);

		String as = br.readLine();
		String[] as_ary = as.split(" ");

		int[] a_ary = new int[n];
		for (int i = 0; i < n; i++) {
			a_ary[i] = Integer.parseInt(as_ary[i]);
		}

		int minj;
		int min;
		int count = 0;
		for (int i = 0; i < n; i++) {
			minj = i;
			for (int j = i + 1; j < n; j++) {
				if (a_ary[j] < a_ary[minj]) {
					minj = j;
				}
			}

			if (i != minj) {
				count += 1;
				min = a_ary[minj];
				a_ary[minj] = a_ary[i];
				a_ary[i] = min;
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.printf(a_ary[i] + (i != n - 1 ? " ": ""));
		}
		System.out.println("\n"+count);
	}
}
