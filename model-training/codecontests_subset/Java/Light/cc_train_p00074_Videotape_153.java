import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int h = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			if(h == -1 && m == -1 && s == -1) break;
			int t1 = 3600 * 2;
			int t2 = 3600 * 2 * 3;
			int t = h * 3600 + m * 60 + s;
			t1 -= t;
			t2 = 3 * t1;
			int h1 = t1 / 3600;
			t1 -= 3600 * h1;
			int m1 = t1 / 60;
			t1 -= 60 * m1;
			System.out.printf("%02d:%02d:%02d\n", h1, m1, t1);
			int h2 = t2 / 3600;
			t2 -= 3600 * h2;
			int m2 = t2 / 60;
			t2 -= 60 * m2;
			System.out.printf("%02d:%02d:%02d\n", h2, m2, t2);
		}
		sc.close();
	}
}
