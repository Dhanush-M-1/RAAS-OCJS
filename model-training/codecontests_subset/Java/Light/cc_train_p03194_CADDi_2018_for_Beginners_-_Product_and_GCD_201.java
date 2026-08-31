import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long P = sc.nextLong();
		HashMap<Long, Long> map = new HashMap<Long, Long>();
		
		boolean flag = true;
		out : while(flag) {
			for(long i = 2; i <= Math.sqrt(P); i++) {
				if(P % i == 0) {
					if(map.containsKey(i)) {
						P /= i;
						map.put(i, map.get(i) + 1);
						continue out;
					} else {
						P /= i;
						map.put(i, (long)1);
						continue out;
					}
				}
			}
			if(map.containsKey(P)) {
				map.put(P, map.get(P) + 1);
			} else {
				map.put(P, (long)1);
			}
			flag = false;
		}
		
		long ans = 1;
		for(long i : map.keySet()) {
			long temp = map.get(i) / N;
			if(temp >= 1) {
				ans = ans * (long)Math.pow(i, temp); 
			}
		}
		System.out.println(ans);
	}
}
