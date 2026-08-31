import java.util.Scanner;


public class divisor {
	static int odd;
	static int even;
	public static void main(String [] args){
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		if(a == b) System.out.print(a); else
		System.out.print(2);
	}
}
