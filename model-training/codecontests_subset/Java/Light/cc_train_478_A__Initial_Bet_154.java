import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c1 = sc.nextInt();
		int c2 = sc.nextInt();
		int c3 = sc.nextInt();
		int c4 = sc.nextInt();
		int c5 = sc.nextInt();
		int total = c1 + c2 + c3 + c4 + c5;
		if (total == 0) {
			System.out.println("-1");
		} else if (total%5 == 0) {
			System.out.println(total/5);
		} else {
			System.out.println("-1");
		}
	}
}
