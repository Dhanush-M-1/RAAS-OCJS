import java.util.Arrays;
import java.util.Scanner;
public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int x = 0, y = 0, min = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			if (a[i] % 2 == 0)
				x++;
			else
				y++;
		}
		int b[] = new int[x];
		int c[] = new int[y];
		for (int i = 0, j = 0, k = 0; i < n; i++) {
			if (a[i] % 2 == 0) {
				b[j] = a[i];
				j++;
			} else {
				c[k] = a[i];
				k++;
			}
		}
		Arrays.sort(b);
		Arrays.sort(c);

		if (Math.abs(x - y) <= 1)
			System.out.println(min);
		else {
			if (x > y) {
				for (int i = 0; i < (x - y - 1); i++)
					min += b[i];
				System.out.println(min);
			} else {
				for (int i = 0; i < (y - x - 1); i++)
					min += c[i];
				System.out.println(min);
			}
		}
	}
}
			   		  			 	 	   		  			 		