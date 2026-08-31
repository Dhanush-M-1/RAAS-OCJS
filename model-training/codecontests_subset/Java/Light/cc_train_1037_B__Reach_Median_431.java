import java.util.Arrays;
import java.util.Scanner;

public class b {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long s = in.nextLong();
		long[] a = new long[n];
		for(int i = 0; i<n; i++) {
			a[i] = in.nextInt();
		}
		Arrays.sort(a);
		long op = 0;
		if(a[n/2]<s) {
			for(int i = n/2;i<n; i++) {
				if(a[i]<s) {
					op+=s-a[i];
				}
				else break;
			}
		}else if(a[n/2]>s) {
			for(int i = n/2; i>=0; i--) {
				if(a[i]>s) {
					op+=a[i]-s;
				}
				else break;
			}
		}
		System.out.println(op);

	}

}
