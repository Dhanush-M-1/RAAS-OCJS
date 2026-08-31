import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();

		if( a <10 && b < 10)System.out.println(a*b);
		else System.out.println(-1);

		in.close();
	}
}