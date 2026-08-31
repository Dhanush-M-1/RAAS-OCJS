import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int a[] = new int[n];

		String str[] = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(str[i]);
		}

		int ans = 0;
		for (int i = 0; i < n - 1; i++) {
			if (a[i] == i + 1) {
				int temp = a[i];
				a[i] = a[i + 1];
				a[i + 1] = temp;
				ans++;
			}
		}

		if (a[n - 1] == n) {
			ans++;
		}

		System.out.println(ans);
	}
}