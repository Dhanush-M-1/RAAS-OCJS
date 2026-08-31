import java.util.Scanner;

public class Problem_519B {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int sum1 = 0;
		int sum2 = 0;
		int sum3 = 0;
		
		for(int i = 0; i < n; i++) {
			sum1 += in.nextInt();
		}
		
		sum2 = sum1;
		
		for(int i = 0; i < n - 1; i++) {
			sum2 -= in.nextInt();
		}
		
		sum3 = sum1 - sum2;
		
		for(int i = 0; i < n - 2; i++) {
			sum3 -= in.nextInt();
		}
		
		System.out.println(sum2);
		System.out.println(sum3);
	}

}
