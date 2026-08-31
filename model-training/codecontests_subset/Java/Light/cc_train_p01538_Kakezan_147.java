import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int i = 0; i < q; i++) {
			int n = sc.nextInt();
			Set<Integer> set = new HashSet<Integer>();
			int c = 0;
			while (true) {
				if (set.contains(n)) {
					c = -1;
					break;
				}
				if (n < 10) {
					break;
				}
				set.add(n);
				c++;
				String str = Integer.toString(n);
				int max = 0;
				for (int j = 1; j < str.length(); j++) {
					String str1 = str.substring(0, j);
					String str2 = str.substring(j, str.length());
					max = Math.max(max,
							Integer.parseInt(str1) * Integer.parseInt(str2));
				}
				n = max;
			}
			System.out.println(c);
		}
	}
}