import java.util.Scanner;

public class LetsWatchFootball195A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int v1 = in.nextInt();
		int v2 = in.nextInt();
		int t1 = in.nextInt();
		int d = v1 * t1;
		int t2 = (int) Math.ceil(((double) d) / v2);
		System.out.println(t2 - t1);
	}
}
