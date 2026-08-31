import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int a,b;
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		b = input.nextInt();
		int c = a*b;
		if(c%2 == 0) {
			System.out.println("Even");
		}else {
			System.out.println("Odd");
		}
	}
}