import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String ans = (a % 2 == 1) && (b % 2 == 1) ? "Odd" : "Even";

		System.out.println(ans);
    }

}