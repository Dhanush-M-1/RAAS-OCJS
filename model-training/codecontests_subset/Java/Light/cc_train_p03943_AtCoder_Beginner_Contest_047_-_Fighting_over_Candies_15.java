import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int c = sc.nextInt();
		if (c==h-w||c==w-h||c==w+h) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}