import java.util.Scanner;

public class Main{

	public static void main(String... args){
		Scanner scan = new Scanner(System.in);
		
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		if(a <= 9 && a >= 1 && b <= 9 && b >= 1 ){
			System.out.println(a*b);
		} else {
			System.out.println(-1);
		}
		
	}
}