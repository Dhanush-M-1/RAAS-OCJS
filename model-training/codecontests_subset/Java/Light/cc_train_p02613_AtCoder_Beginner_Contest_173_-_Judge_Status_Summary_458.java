import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("AC", 0);
		map.put("WA", 0);
		map.put("TLE", 0);
		map.put("RE", 0);
		for (int i=0;i<N;i++) {
			String S = sc.next();
			map.put(S, map.get(S)+1);
		}
		System.out.println("AC x "+map.get("AC"));
		System.out.println("WA x "+map.get("WA"));
		System.out.println("TLE x "+map.get("TLE"));
		System.out.println("RE x "+map.get("RE"));
	}
}