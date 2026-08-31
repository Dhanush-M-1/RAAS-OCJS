import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int f[][] = new int[n + 1][10];
		int p[][] = new int[n + 1][11];
		int ans = 0;
		for (int i = 1; i <= n; i++)
			for (int j = 0; j < 10; j++)
				f[i][j] = Integer.parseInt(sc.next());
		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= 10; j++)
				p[i][j] = Integer.parseInt(sc.next());
		for (int i = 1; i <= 1024; i++) {
			String bin[] = String.format("%10s", Integer.toBinaryString(i)).replaceAll(" ", "0").split("");
			int index[] = new int[n + 1];
			for (int j = 0; j < 10; j++) {
				if (Integer.parseInt(bin[j]) == 1) {
					for (int k = 1; k <= n; k++) {
						if (f[k][j] == 1)
							index[k]++;
					}
				}
			}
			int tem = 0;
			for (int j = 1; j <= n; j++) {
				tem += p[j][index[j]];
			}
			if (tem > ans || i == 1)
				ans = tem;
		}
		System.out.println(ans);
	}
}