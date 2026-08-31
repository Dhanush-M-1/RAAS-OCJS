import java.util.*;

public class cf168a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		int needed = (n*y-1)/100 + 1;
		System.out.println(Math.max(0,needed-x));
	}
}
