import java.util.Scanner;

public class Task284B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String p = sc.next();
		sc.close();
		
		int a = 0;
		int i = 0;
		for (int j = 0; j < n; j++) {
			char m = p.charAt(j);
			if (m == 'A') {
				a++;
			} else if (m == 'I') {
				i++;
			}
		}
		
		if (i == 1) {
			System.out.println(1);
		} else if (i == 0) {
			if (a == 0) {
				System.out.println(0);
			} else {
				System.out.println(a);
			}
		} else {
			System.out.println(0);
		}
	}
}