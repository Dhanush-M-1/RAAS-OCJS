import java.util.*;
public class Np
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int left = scanner.nextInt();
		int right = scanner.nextInt();
		System.out.println(left == right ? left : "2");
	}
}