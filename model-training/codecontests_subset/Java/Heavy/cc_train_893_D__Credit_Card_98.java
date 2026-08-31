import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		int ans = 0;
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int d = input.nextInt();
		int[] trans = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			trans[i] = input.nextInt();
		}
		int min = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (trans[i] == 0) {
				if (min < 0) {
					min = 0;
				}
				if (max < 0) {
					max = d;
					ans++;
				}
			} else {
				min += trans[i];
				max += trans[i];
				if (min > d) {
					System.out.println("-1");
					return;
				}
				if (max > d) {
					max = d;
				}
			}
		}
		System.out.println(ans);
	}
}
			 		 				     		 	  		     		