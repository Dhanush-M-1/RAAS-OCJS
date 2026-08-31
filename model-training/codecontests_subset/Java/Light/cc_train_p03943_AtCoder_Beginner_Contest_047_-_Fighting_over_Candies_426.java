import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		int a = stdIn.nextInt();
		int b = stdIn.nextInt();
		int c = stdIn.nextInt();
		
		if(a+b==c || b+c==a || c+a == b) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
		
		
	}

}
