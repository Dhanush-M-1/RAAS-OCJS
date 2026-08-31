import java.util.*;
import java.io.*;

public class B {
	
	static Map<Long, Long> result = new HashMap<Long, Long>();

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		long t = in.nextLong();
		long six = 1;
		long current = 0;
		
		while (six <= 999999999999999999L) {
			result.put(six, current);
			six = six * 6;
			current++;

			// System.out.println(six + " ----- ");

			long two = six;
			long twoC = current;
			while (two % 2 == 0) {
				two = two / 2;
				twoC++;
				
				// System.out.println(two);
				if (result.containsKey(two) == false) {	
					result.put(two, twoC);
				}
			}
		}

		long two = six;
		long twoC = current;
		while (two % 2 == 0) {
			two = two / 2;
			twoC++;
			
			// System.out.println(two);
			if (result.containsKey(two) == false) {	
				result.put(two, twoC);
			}
		}


		// result.forEach((k, v) -> {
		// 	if (v > 28) {
		// 		System.out.println("Key: " + k + " Value: " + v);
		// 	}
		// });


		for (int i  = 0; i < t; i++) {
			long n = in.nextLong();

			solve(n);
		}
	}

	private static void solve(long n) {
		if (result.containsKey(n)) {
			System.out.println(result.get(n));
		} else {
			System.out.println("-1");
		}
	}
}