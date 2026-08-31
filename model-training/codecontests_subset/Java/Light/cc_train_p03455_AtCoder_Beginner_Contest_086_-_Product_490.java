import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		// 整数の入力
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a*b%2==1) {
			System.out.println("Odd");
		} else {
			System.out.println("Even");
		}
		
	}
}