import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int n;
		if(A <= 9 && B <= 9) {
			n = A * B;
		}else {
			n = -1;
		}
		System.out.println(n);
	}

}
