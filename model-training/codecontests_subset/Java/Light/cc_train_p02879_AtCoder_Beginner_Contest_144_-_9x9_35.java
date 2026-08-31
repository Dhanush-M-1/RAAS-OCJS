import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		if(a>=1 && a<=9 && b>=1 && b<=9) {
			System.out.print(a*b);
		}
		else {
			System.out.print(-1);
		}
	}
}
