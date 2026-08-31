import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[][]p = new long[n + 1][2];
		for(int i = 0; i < n; i++) {
			long x = scan.nextLong();
			long y = scan.nextLong();
			long[]t = {x, y};
			p[i] = t;
		}
		p[n] = p[0];
		scan.close();
		for(int i = 0; i < n; i++) {
			long s = area(p[(i - 1 + n) % n], p[i], p[i + 1]);
			long t = area(p[i], p[i + 1], p[(i + 2) % n]);
			if(s * t < 0) {
				System.out.println(0);
				System.exit(0);
			}
		}
		System.out.println(1);
	}
	static long area(long[]x, long[]y, long[]z) {
		return (cross(vec(z, x), vec(z, y)));
	}
	static long cross(long[]u, long[]v) {
		return u[0] * v[1] - u[1] * v[0];
	}
	static long[] vec(long[]p1, long[]p2) {
		long[]u = {p2[0] - p1[0], p2[1] - p1[1]};
		return u;
	}
}
