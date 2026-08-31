import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = scn.nextInt();
		}
		int tmp;
		int count = 0;
		for (int i = 0; i < num.length; i++) {
			int minj = i;
			for (int j = i; j < num.length; j++) {
				if (num[j] < num[minj]) {
					minj = j;
				}
			}
			if (num[minj] != num[i]) {
				int temp = num[i];
				num[i] = num[minj];
				num[minj] = temp;
				count++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < num.length - 1; a++) {
			sb.append(num[a] + " ");
		}
		System.out.println(sb.append(num[num.length - 1]).toString());
		System.out.println(count);
	}
}

