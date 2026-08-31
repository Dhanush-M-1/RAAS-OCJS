import java.util.Scanner;
public class MinimumInteger {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
		int test = scn.nextInt();
		while (test > 0) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			int d = scn.nextInt();
			if (d < x) {
				System.out.println(d);
			} else {
				int check = y / d;
				if (check * d > y) {
					System.out.println(check * d);
				} else {
					System.out.println((check + 1) * d);}}
			test--;}}}