import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class A {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int nu[] = new int[n];
		int bulb[] = new int[m];
		for (int i = 0; i < m; i++) {
			bulb[i] = i + 1;
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nu[i] = sc.nextInt();
			for (int j = 0; j < nu[i]; j++) {
				int t = sc.nextInt();
				list.add(t);
			}
		}
		String s = "YES";
		for (int i = 0; i < m; i++) {
			if (list.contains(bulb[i]) == false) {
				s = "NO";
				break;
			}
		}

		System.out.println(s);
	}
}