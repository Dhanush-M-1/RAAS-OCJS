import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int dist = Math.abs(a - b);
		
		int double_steps = dist / 2;
		int extra_step = dist % 2;
		
		int sum = dist/2 * (dist/2 + 1);
		sum += extra_step * (dist / 2 + 1);
		System.out.println(sum);
	}
}
