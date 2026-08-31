import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class ProblemB {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String word = sc.next();
		HashMap<String , Integer> map = new HashMap<>();
		for(int i = 0 ; i < word.length()-1 ; i ++) {
			String key = word.substring(i, i+2);
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}
			else {
				map.put(key, 1);
			}
		}
		String bigger = null ;
		int big = -1;
		for(Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue() > big) {
				big = entry.getValue();
				bigger = entry.getKey();
			}
		}
		System.out.println(bigger);
	}
}
