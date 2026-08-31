//import java.lang.reflect.Array;
import java.math.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] a = new int[200000];
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(),s = input.nextInt();
		for(int i = 0 ;i < n ; i++) {
			a[i] = input.nextInt();
		}
		Arrays.sort(a, 0 , n);
		int k = n / 2;
		long ans = 0;
		if(a[k] > s) {
			while(k >= 0 && a[k] > s) {
				ans += a[k] - s;
				k--;
			}
		}
		else if(a[k] < s) {
			while(a[k] < s && k < n) {
				ans += s - a[k];
				k++;
			}
		}
		System.out.println(ans);
	}
}
