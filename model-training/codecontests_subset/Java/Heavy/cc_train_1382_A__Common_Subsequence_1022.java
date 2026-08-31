
import java.util.*;
public class nearly_prime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a[] = new int[n];
			int b[] = new int[m];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0;i<m;i++) {
				b[i] = sc.nextInt();
			}
			Arrays.sort(a);
			Arrays.sort(b);
			int s = 0;
			int i = 0;
			int j = 0;
			boolean present = false;
			while(i<n && j<m) {
				if(b[j] == a[i]) {
					s = b[j];
					present = true;
					break;
				}
				if(a[i]>b[j]) {
					j++;
					i--;
				}
				i++;
			}
			if(present) {
				System.out.println("YES");
				System.out.println(1+" "+s);
			}
			else {
				System.out.println("NO");
			}
		}
}
}