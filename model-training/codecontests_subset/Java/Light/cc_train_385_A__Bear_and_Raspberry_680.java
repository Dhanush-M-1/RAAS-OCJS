import java.util.*;

public class BearAndHoney {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), c = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = sc.nextInt();
		int max = 0;
		for(int i=0; i<n-1; i++) max = Math.max(max, a[i]-c-a[i+1]);
		System.out.println(max);
	}
}
