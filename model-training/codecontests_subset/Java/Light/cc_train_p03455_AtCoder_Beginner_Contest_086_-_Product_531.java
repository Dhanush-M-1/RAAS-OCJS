import java.util.Scanner;

public class Main {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		String[] judge = {"Even","Odd"};

		System.out.print(judge[(a * b)%2]);
	}
}
