import java.util.Scanner;

public class Garden {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), k = in.nextInt(), i, m = 0;
		for (i = 0; i < n; i++) {
			
			int a = in.nextInt();
			if (k % a == 0 && a > m)
				m = a;
		}
		in.close();
		System.out.println(k / m);
	}
}
