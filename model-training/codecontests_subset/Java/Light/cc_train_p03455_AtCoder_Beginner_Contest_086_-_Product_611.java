import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int c = (a * b) % 2;

		if(c == 1){
			System.out.println("Odd");
		}
		else{
			System.out.println("Even");
		}
	}

}