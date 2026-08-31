import java.util.*;

public class P1 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int numTests = reader.nextInt();
		for (int testNum = 0; testNum < numTests; testNum++) {
			int length = reader.nextInt();
			long first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, last = Integer.MIN_VALUE, i = -1, j = -1, k = -1;
			
			for (int a = 1; a <= length; a++) {
				long curr = reader.nextLong();
				if (curr < first) {
					second = first;
					j = i;
					first = curr;
					i = a;
				}
				else if (curr < second) {
					second = curr;
					j = a;
				}
				if (curr >= last) {
					last = curr;
					k = a;
				}
			}
			if (first == 0) {
				System.out.println(-1);
			}
			else if (first + second <= last) {
				System.out.println(i + " " + j + " " + k);
			}
			else {
				System.out.println(-1);
			}
		}
		
		reader.close();
	}
	
}
