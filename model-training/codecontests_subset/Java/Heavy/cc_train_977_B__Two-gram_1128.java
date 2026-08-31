import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoGram {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		String ops = scanner.next();
		
		Map<String, Integer> twoGcount = new HashMap<String, Integer>();
		
		for (int i = 0; i < num-1; i++) {
			String st = ops.substring(i, i+2);
			twoGcount.put(st, twoGcount.getOrDefault(st, 0)+1);
		}
		String res = ops.substring(0,2);
		int max = twoGcount.get(res);
		for (String key : twoGcount.keySet()) {
			if(twoGcount.get(key) > max){
				res = key;
				max = twoGcount.get(key);
			}
			else if(twoGcount.get(key) == max && ops.indexOf(key) < ops.indexOf(res)){
				res = key;
			}
		}
		System.out.println(res);

		scanner.close();
	}

}
