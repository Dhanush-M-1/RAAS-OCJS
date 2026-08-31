import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		if(n == m) System.out.println(n);
		else{
			System.out.println(2);
		}
	}
}
