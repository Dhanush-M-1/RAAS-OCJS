import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt(),b=scan.nextInt();
		if((a*b)%2==0) {
			System.out.println("Even");
		}
		else {
			System.out.println("Odd");
		}

	}

}