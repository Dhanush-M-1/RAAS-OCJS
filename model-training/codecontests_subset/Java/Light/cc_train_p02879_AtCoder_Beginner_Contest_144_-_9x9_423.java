import java.util.*;

class Main {
	Scanner sc;

	Main() {
		sc = new Scanner(System.in);
	}
	
	void calc() {
		int A = sc.nextInt();
		int B = sc.nextInt();
		if (A > 9 || B > 9) System.out.println(-1);
		else System.out.println(A*B);
	}

	public static void main(String[] args) {
		new Main().calc();
	}
}