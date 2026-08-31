import java.util.*;

public class p195A {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();

		System.out.println((long)(Math.ceil((double)(a*c)/(double)b)-c));
	}
}