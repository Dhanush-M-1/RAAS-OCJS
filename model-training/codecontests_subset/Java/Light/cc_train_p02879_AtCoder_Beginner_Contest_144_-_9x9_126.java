import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt();
		int B =sc.nextInt();
		if((1<=A&&A<=9)&&(1<=B&&B<=9)) {
		System.out.print(A*B);
		}else {
			System.out.print("-1");
		}
		sc.close();
	}

}