import java.util.*;
public class CF385A_BearAndRaspberry {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int [] a = new int[n];
		for(int i = 0; i < n; i ++){
			a[i] = in.nextInt();
		}
		int max = 0;
		for(int i = 1; i < n; i ++){
			max = Math.max(max, a[i - 1] - a[i] - k);
		}
		System.out.println(max);
	}
}
