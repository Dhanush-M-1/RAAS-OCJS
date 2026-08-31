
import java.util.Scanner;

public class MinimalNumber {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int res[] = new int[n];
		for(int i = 0; i < n; i++) {
			int a = in.nextInt();
			int b = in.nextInt();
			int c = in.nextInt();
			if(a > c) {
				res[i] = c;	
			}
			else {
				res[i] = (int) (c * Math.ceil(b / c)) + c;
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(res[i]);
		}
	}
}
