import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		int c = 0;
		boolean[] already = new boolean[n];
		for (int i = 0; i < n; i++)
			if (Integer.parseInt(sc.next()) != i + 1)
				already[i] = true;
		for (int i = 0; i < n - 1; i++) {
			if (!already[i]) {
				c++;
				already[i + 1] = true;
			}
		}
		if (!already[n - 1])
			c++;
		System.out.println(c);
	}
}