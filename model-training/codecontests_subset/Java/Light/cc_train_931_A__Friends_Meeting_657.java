import java.util.Scanner;

public class p931A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt(), b = scan.nextInt();
		long ans = 0;
		int c = 1;
		while (Math.min(a, b)+c <= (a+b)/2) {
			ans += c*2;
			c++;
		}
		if ((Math.max(a, b)-Math.min(a, b))%2==1) {
			ans += (long) Math.ceil((1.0*Math.max(a, b)-Math.min(a, b))/2);
		}
		System.out.println(ans);
	}
	
}
