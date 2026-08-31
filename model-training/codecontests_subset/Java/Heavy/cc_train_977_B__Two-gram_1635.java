import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.nextLine();
		String s = scanner.nextLine(); 
		
		Map<String, Integer> res = new HashMap<String, Integer>();
		for (int i = 0; i < n - 1; i++) {
			String tmp = s.substring(i,i+2);
			if (res.containsKey(tmp))
				res.put(tmp, res.get(tmp)+1);
			else 
				res.put(tmp, 1);
		}
		
		
		Set<Entry<String, Integer>> entrySet = res.entrySet();
		int max = 0;
		String key ="";
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				key = entry.getKey();
			}
		}
		System.out.println(key);
		
	}
}
