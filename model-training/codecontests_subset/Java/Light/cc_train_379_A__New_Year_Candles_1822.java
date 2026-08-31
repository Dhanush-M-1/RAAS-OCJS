import java.util.Scanner;


public class NewYearCandles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ret = 0, a = sc.nextInt(), b = sc.nextInt();
//		while (a >= b) {
//			a -= b;
//			ret += b;
//			a++;
//		}
//		ret += a;
//		System.out.println(ret);
		int K = (a - 1) / (b - 1);
		ret = K*b + a - K*(b-1);
		System.out.println(ret);
	}

}
