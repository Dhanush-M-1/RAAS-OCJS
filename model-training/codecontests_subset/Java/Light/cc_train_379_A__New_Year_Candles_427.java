import java.util.*;

public class NewYearCandles_379A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int f = b;
		double sum = a;
		double x = a;
		while(x>=b) {
			sum = sum + x/(double)b ;
			b = b*f;
		}
		sum = sum + (x/(double)(b));
		System.out.println((int)Math.floor(sum));
		
	}

}