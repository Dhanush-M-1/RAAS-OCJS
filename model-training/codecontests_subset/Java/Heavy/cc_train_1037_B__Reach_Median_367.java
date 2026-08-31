import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B1037 {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt(), s = in.nextInt(), i;
		long ans = 0;
		int[] a = new int[n];
		
		for(i = 0; i < n; ++i) 
			a[i] = in.nextInt();
		
		if(n == 1) {
			System.out.println((int)Math.abs(a[0] - s));
			System.exit(0);
		}
		Arrays.sort(a);
		
		if(a[n / 2] > s) {
			i = n / 2;
			while(i >= 0 && a[i] > s) {
				ans += a[i] - s;
				i--;
			}
		}
		else
			if(a[n / 2] < s) {
				i = n / 2;
				while(i < n && a[i] < s) {
					ans += s - a[i];
					i++;
				}
			}
		System.out.println(ans);
	}
}
