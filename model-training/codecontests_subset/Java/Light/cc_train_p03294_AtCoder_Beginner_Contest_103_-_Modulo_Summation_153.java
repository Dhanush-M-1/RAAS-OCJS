import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long result =0;
		for (int i=0;i<N;i++) {
			result +=sc.nextLong()-1;
		}
		System.out.println(result);
	}
}