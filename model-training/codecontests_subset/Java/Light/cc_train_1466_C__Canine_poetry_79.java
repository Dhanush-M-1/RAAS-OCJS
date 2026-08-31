import java.util.*;

public class P3 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int numTests = reader.nextInt();
		for (int testNum = 0; testNum < numTests; testNum++) {
			String s = reader.next();
			int n = s.length();
			char[] arr = new char[n];
			for (int i = 0; i < n; i++) {
				arr[i] = s.charAt(i);
			}
			int change = 0;
			if (n == 1) {
				System.out.println(0);
			}
			else {
				if (arr[1] == arr[0]) {
					arr[1] = ';';
					change++;
				}
				for (int i = 2; i < n; i++) {
					if (arr[i] == arr[i - 1]) {
						arr[i] = ';';
						change++;
					}
					else if (arr[i] == arr[i - 2]) {
						arr[i] = ';';
						change++;
					}
				}
				System.out.println(change);
			}
		}
		reader.close();
	}
	
}
