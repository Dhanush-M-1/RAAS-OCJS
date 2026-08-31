import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		if(a>0 && a<=9 && b>0 && b<=9) System.out.println(a*b);
		else System.out.println("-1");
	}

}
