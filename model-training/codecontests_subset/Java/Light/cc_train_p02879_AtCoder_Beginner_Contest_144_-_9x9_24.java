import java.util.Scanner;

class Main {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	int A, B;
	A = sc.nextInt();
	B = sc.nextInt();

	if (A > 9 || B > 9)
	    System.out.println(-1);
	else
	    System.out.println(A * B);
    }
}