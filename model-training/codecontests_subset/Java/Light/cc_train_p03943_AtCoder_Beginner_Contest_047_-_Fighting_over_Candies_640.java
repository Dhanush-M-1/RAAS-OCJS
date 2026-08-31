import java.util.Scanner;

public class Main {

	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt(),b=scan.nextInt(),c=scan.nextInt();

		System.out.println((a+b==c || a+c==b || b+c==a)?"Yes":"No");
	}

}