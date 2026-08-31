import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		int y = s.nextInt();
		int result = 0;
		result += x;
		while(x >= y)
		{
			int tmp = x % y;
			x /= y;
			result +=x;
			x += tmp;
		}
		System.out.println(result);
	}
}
