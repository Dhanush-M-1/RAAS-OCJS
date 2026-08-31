import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		Scanner stdin=new Scanner(System.in);
		int a=stdin.nextInt();
		int b=stdin.nextInt();

		if((a*b)%2==1)
			System.out.println("Odd");
		else if((a*b)%2==0)
			System.out.println("Even");
	}
}
