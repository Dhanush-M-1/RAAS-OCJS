import java.io.BufferedInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Games {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(new BufferedInputStream(System.in));
		int n = scanner.nextInt();
		Map<Integer, Integer> home = new HashMap<>();
		Map<Integer, Integer> guest = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int h = scanner.nextInt();
			int g = scanner.nextInt();
			home.put(h, home.containsKey(h) ? home.get(h) + 1 : 1);
			guest.put(g, guest.containsKey(g) ? guest.get(g) + 1 : 1);
			sum += home.containsKey(g) ? home.get(g) : 0;
			sum += guest.containsKey(h) ? guest.get(h) : 0;
		}
		scanner.close();
		System.out.println(sum);
	}
}
