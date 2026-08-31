import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		
		int m = 0;
		
		if(a<=9 && b<=9) {
			m = a * b;
			System.out.println(m);
		}
		else {
			System.out.println("-1");
		}

	}

}
