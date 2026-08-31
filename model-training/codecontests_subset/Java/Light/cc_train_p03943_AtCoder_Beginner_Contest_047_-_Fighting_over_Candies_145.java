import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//整数の入力
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		//条件分岐
		if((a + b == c) || (b + c == a) || (a + c == b)) {
			System.out.println("Yes");
			return;
		}else {
			System.out.println("No");
		}
	}

}
