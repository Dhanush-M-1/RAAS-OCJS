import java.util.Scanner;

public class Prob316B {
	public static void main(String[] Args) {
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int k = scan.nextInt() - 1;

		int[] uf = new int[x];
		for (int i = 0; i < x; i++)
			uf[i] = i;

		int[] arr = new int[x];
		for (int i = 0; i < x; i++)
			arr[i] = scan.nextInt() - 1;

		for (int i = 0; i < x; i++)
			if (arr[i] != -1)
				merge(uf, i, arr[i]);

		int[] sizes = new int[x];
		for (int i = 0; i < x; i++)
			sizes[getpar(uf, i)]++;

		int index = 1;
		for (int i = 0; i < x; i++)
			while (arr[k] != -1) {
				k = arr[k];
				index++;
			}
		sizes[k] = 0;

		boolean[] dp = new boolean[x];
		dp[0] = true;
		for (int i = 0; i < x; i++)
			if (sizes[i] != 0)
				for (int j = x - 1; j >= sizes[i]; j--)
					if (dp[j - sizes[i]])
						dp[j] = true;

		for (int i = 0; i < x; i++)
			if (dp[i])
				System.out.println(i + index);
	}

	static int getpar(int[] arr, int i) {
		return arr[i] == i ? i : getpar(arr, arr[i]);
	}

	static void merge(int[] arr, int a, int b) {
		arr[getpar(arr, a)] = getpar(arr, b);
	}
}
