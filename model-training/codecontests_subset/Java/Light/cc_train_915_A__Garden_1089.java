import java.util.Scanner;

public class TaskA {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		int n = in.nextInt();
		int k = in.nextInt();
		int max = 0;
		for(int i = 0 ; i < n ; i ++) {
			int a = in.nextInt();
			if(a > max && k%a == 0) max = a;
		}
		System.out.print(k/max);
	}
}
