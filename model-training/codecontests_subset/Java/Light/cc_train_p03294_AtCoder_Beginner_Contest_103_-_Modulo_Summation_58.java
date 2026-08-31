import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		long ans = 0;
		for(int i = 0; i < n; i++) {
			ans += sc.nextInt();
		}
		System.out.println(ans - n);
    }
}
