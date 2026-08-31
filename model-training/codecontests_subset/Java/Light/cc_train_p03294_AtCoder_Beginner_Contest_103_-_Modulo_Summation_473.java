import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ans = -n;
		for (int i=0; i<n; i++) ans += scanner.nextInt();
		System.out.println(ans);
	}
}