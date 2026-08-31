import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int one = sc.nextInt();
		int two = sc.nextInt();
		
		if(one>9||two>9) {
			System.out.println(-1);
		}
		else
			System.out.println(one*two);
	
	}
}