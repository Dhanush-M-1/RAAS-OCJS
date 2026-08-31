
import java.util.ArrayList;
import java.util.Scanner;

public class CF_519B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long sum1 = 0;
		long sum2 = 0;
		long sum3 = 0;

		
		for (int i = 0; i < n; i++) {
			sum1+=sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			sum2+=sc.nextInt();
		}
		for (int i = 0; i < n - 2; i++) {
			sum3+=sc.nextInt();
		}
		System.out.println(sum1-sum2);
		System.out.println(sum2-sum3);
	}
}
//当不会做的时候，试试求和能不能解决？针对集合问题