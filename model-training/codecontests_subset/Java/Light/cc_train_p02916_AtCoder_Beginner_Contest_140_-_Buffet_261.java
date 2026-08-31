
import java.util.Scanner;

public class Main {

	public static final long MOD = 1_000_000_007;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int count = 0;
		int before = -1;
		
		for (int i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		for (int i=0;i<n;i++) {
			b[i]=sc.nextInt();
		}
		for (int i=0;i<n-1;i++) {
			c[i]=sc.nextInt();
		}
		
		for (int i=0;i<n;i++) {
			int k = a[i];
			count+=b[k-1];
			if(k==before+1) {
				count+=c[k-2];
			}
			before=k;
		}
		
		System.out.println(count);
		
		
		
		
	}



}