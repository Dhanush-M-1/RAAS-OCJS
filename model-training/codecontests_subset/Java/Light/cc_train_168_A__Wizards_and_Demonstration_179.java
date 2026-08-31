import java.util.*;

public class A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(Math.max((int)Math.ceil((double)y*n/100 - x),0));
	}
}
