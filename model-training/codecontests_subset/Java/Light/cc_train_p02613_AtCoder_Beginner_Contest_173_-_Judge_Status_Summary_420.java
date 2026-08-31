import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<String,Integer> result = new LinkedHashMap<String,Integer>();
		result.put("AC",0);
		result.put("WA",0);
		result.put("TLE",0);
		result.put("RE",0);
		for(int i = 0;i < n; i++) {
			String key = sc.next();
			result.put(key,result.get(key)+1);
		}
		for(String key: result.keySet()) {
			System.out.println(key + " x " + result.get(key));
		}
	}
}