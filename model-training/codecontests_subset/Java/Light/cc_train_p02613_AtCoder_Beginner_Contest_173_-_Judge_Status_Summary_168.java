import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(final String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String, Integer> map = new HashMap<String, Integer>();
		while(n-->0) {
			String z = sc.next();
			map.put(z, map.getOrDefault(z, 0) + 1);
		}
		System.out.println("AC x " + map.getOrDefault("AC", 0));
		System.out.println("WA x " + map.getOrDefault("WA", 0));
		System.out.println("TLE x " + map.getOrDefault("TLE", 0));
		System.out.println("RE x " + map.getOrDefault("RE", 0));
	}
}
