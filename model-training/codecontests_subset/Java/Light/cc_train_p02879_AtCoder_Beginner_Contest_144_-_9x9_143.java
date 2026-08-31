import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();

		// どちらも9以下ならA*B、どちらかが9より大きければ-1
		System.out.println(((A<=9)&&(B<=9)) ? A*B : -1);

		sc.close();
	}


}