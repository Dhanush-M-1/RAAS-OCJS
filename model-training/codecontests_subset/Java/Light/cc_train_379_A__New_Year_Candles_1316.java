import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int ans = a;
		while(a >= b){
			ans += a / b;
			a = (a - (b * (a / b))) + (a / b);
		}
		System.out.println(ans);
	}
}