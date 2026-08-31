import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		boolean canCalc = a < 10 && b < 10;
		int ans = canCalc ? a * b : -1;
		System.out.println(ans);
		sc.close();
	}

}
