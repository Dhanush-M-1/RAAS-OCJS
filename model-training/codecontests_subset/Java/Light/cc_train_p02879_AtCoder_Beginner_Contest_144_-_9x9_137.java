import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int ans = 0;
		if (a >=1 && a<=9 && b>=1 &&b<=9) {
			ans = a * b;
		} else {
			ans = -1;
		}

		System.out.println(ans);
	}

}