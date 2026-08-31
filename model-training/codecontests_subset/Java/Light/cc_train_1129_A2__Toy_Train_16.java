import java.io.*;
import java.util.*;
import java.math.*;

public class A {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/a.in"))));
		/**/
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[m];
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			a[i] = sc.nextInt()-1;
			b[i] = sc.nextInt()-1;
		}
		int[] times = new int[n];
		int[] then = new int[n];
		for (int i = 0; i < m; i++) {
			int diff = (b[i]+n-a[i])%n;
			if (then[a[i]]==0) {
				then[a[i]] = diff;
				continue;
			}
			times[a[i]]++;
			then[a[i]] = Math.min(then[a[i]], diff);
		}
		StringBuilder tp = new StringBuilder();
		String sp = "";
		for (int i = 0; i < n; i++) {
			int ans = 0;
			for (int j = 0; j < n; j++) {
				int k = i+j;
				if (k>=n)
					k-=n;
				if (then[k]==0)
					continue;
				ans = Math.max(ans, j+times[k]*n+then[k]);
			}
			tp.append(sp+ans);
			sp = " ";
		}
		System.out.println(tp);
	}
}