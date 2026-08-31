import java.util.*;
import java.util.stream.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans += in.nextInt() - 1;
		}
		System.out.println(ans);
	}
}