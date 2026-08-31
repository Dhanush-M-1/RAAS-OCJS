import java.util.Scanner;


public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt()*2;
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		long ans = 0;
		for (int x = 0; x <= n && x <= a; x++) {
			for (int y = 0; x+2*y <= n && y <= b; y++) {
				int s = n-x-2*y;
				if (s % 4==0 && s/4 <= c)
					ans++;
			}
		}
		System.out.println(ans);
	}

}
