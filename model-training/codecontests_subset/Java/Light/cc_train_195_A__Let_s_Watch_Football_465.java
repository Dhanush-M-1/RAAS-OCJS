import java.util.Scanner;


public class ProblemA {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		
		int t = (int) Math.ceil(((double) a - (double) b) * (double) c / (double) b);
		System.out.println(t);
	}
}
