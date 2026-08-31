import java.util.Arrays;
import java.util.Scanner;

public class A615 {
	
	void go(Scanner s) {
		int N = s.nextInt(), sn[] = new int[s.nextInt()];
		for(int i = 0; i < N; i++) {
			for(int x = s.nextInt(); x > 0; x--)
				sn[s.nextInt() - 1]++;
		}
		System.out.println(Arrays.stream(sn).min().getAsInt() == 0 ? "NO" : "YES");
	}
	
	int min(int a, int b) { return a < b ? a : b; }
	int max(int a, int b) { return a > b ? a : b; }
	public static void main(String[] args) { new A615().go(new Scanner(System.in)); }
}
