import java.util.*;

public class demonstration {
	public static void main(String[] args)	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int x = in.nextInt();
		int y = in.nextInt();
		System.out.println(max((int)(Math.ceil(n*y/100.0)-x),0));
	}
	public static int max(int a, int b)	{
		if (a > b)
			return a;
		return b;
	}
}
