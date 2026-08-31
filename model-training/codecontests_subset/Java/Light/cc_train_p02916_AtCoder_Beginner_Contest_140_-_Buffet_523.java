import java.util.*;
import static java.lang.Integer.*;
//import static java.lang.Long.*;
import static java.lang.Math.*;
import static java.lang.System.*;

public class Main {
	public static void main(String[] args) {
		int i,j;
		Scanner sc = new Scanner(in);
		int n = parseInt(sc.next());
		int[] a = new int[n];
		for(i=0;i<n;i++) {
			a[i] = parseInt(sc.next());
		}
		int[] b = new int[n];
		for(i=0;i<n;i++) {
			b[i] = parseInt(sc.next());
		}
		int[] c = new int[n];
		for(i=0;i<n-1;i++) {
			c[i] = parseInt(sc.next());
		}
		int ans = b[a[0]-1];
		for(i = 1; i < n; i++) {
			ans += b[a[i]-1];
			if(a[i]==a[i-1]+1) {
				ans += c[a[i-1]-1];
			}
		}
		out.println(ans);
	}
}
