import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			String s = sc.next();
			char[] c = s.toCharArray();
			int[] a = new int[m];
			for (int i = 0; i < m; i++)
				a[i] = sc.nextInt();
			int[] b = new int[26];

			Arrays.sort(a);
			int j = 0;
			for (int i = 0; i < m; i++) {
				for (; j < a[i]; j++) {
					b[c[j] - 97] += (m - i);
				}
			}
			for (int i = 0; i < n; i++)
				b[c[i] - 97]++;
			for (int i : b)
				System.out.print(i + " ");
			System.out.println();
		}
	}
}

 	 				  			 	   		    	  	 	 	