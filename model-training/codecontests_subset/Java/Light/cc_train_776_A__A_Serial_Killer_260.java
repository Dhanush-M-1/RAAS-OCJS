import java.util.*;
public class Car {
	public static void main (String[] args) {
	Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		int n = sc.nextInt();
		String[] kill = new String[n];
		String[] replace = new String[n];
		System.out.println(a + " " + b);
		for (int i = 0; i < n; i++) {
			kill[i] = sc.next();
			replace[i] = sc.next();
			if (kill[i].equals(a))
				a = replace[i];
			else
				b = replace[i];
			System.out.println(a + " " + b);
		}
	}
}