import java.util.Scanner;


public class CodeForces379A {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int a = input.nextInt(), b = input.nextInt();
		
		int count = 0;
		int r = a * b;
		
		while (r > b - 1) {
			r -= b - 1;
			count++;
		}
		
		System.out.println(count);
		input.close();
	}

}
