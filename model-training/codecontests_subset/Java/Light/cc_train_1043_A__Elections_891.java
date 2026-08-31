import java.util.*;
public class A {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++)
		{
			int x = s.nextInt();
			sum += x;
			max = Math.max(max, x);
		}
		System.out.println((int) (Math.max(Math.floor((2.0*sum)/((double) n)) + 1, max)));
	}

}
