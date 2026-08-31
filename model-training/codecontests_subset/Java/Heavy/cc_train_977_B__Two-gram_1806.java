
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String s = scanner.next();
		Map<String,Integer>dist = new HashMap<String,Integer>();
		
		String temp = "";
		
		for(int i = 0; i < n - 1; i++) {
			temp = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
			if(dist.containsKey(temp)) {
				dist.put(temp, dist.get(temp) + 1);
			}else {
				dist.put(temp, 1);
			}
		}
		
		int maxV = 0;
		String max = "";
		
		for(Map.Entry<String,Integer> entry : dist.entrySet()) {
			
			if(entry.getValue() >= maxV) {
				maxV = entry.getValue();
				max = entry.getKey();
			}
			
		}
		
		System.out.println(max);
		
	}
}
