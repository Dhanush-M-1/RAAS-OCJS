import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		Map<String, Integer> map = new HashMap<>();
		map.put("AC", 0);
		map.put("WA", 0);
		map.put("TLE", 0);
		map.put("RE", 0);
		
		for (int i = 0; i < n; i++) {
			String key = sc.next();
			map.put(key, map.get(key) + 1);
		}
		
		System.out.println("AC x " + map.get("AC"));
		System.out.println("WA x " + map.get("WA"));
		System.out.println("TLE x " + map.get("TLE"));
		System.out.println("RE x " + map.get("RE"));
		
		sc.close();
	}
	
}

