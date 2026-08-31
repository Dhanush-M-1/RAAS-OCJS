import java.util.Scanner;
public class A519 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int sum = 0, sum1 = 0, sum2 = 0;
		
		for(int i=0; i<n; i++)
			sum += in.nextInt();
		
		for(int i=0; i<(n-1); i++)
			sum1 += in.nextInt();
		
		for(int i=0; i<(n-2); i++)
			sum2 += in.nextInt();
		
		System.out.println(sum - sum1);
		System.out.println(sum1 - sum2);
	}
}
