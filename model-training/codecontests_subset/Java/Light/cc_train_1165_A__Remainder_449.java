import java.util.*;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		char[] arr = new char[n];
		arr = s.toCharArray();
		int counter = 0;
		for (int i = n - 1; i > n - 1 - y; i --) {
			if (arr[i] == '1') {
				counter ++;
			}
		}
		if (arr[n - 1 - y] == '0') {
			counter ++;
		}
		for (int i = n - 2 - y; i > n - 1 - x; i --) {
			if (arr[i] == '1') {
				counter ++;
			}
		}
		System.out.println(counter);
		
		
	}
}
