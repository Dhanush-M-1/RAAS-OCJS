import java.util.Scanner;

public class bulb {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		boolean[] a = new boolean[m];
		for(int i = 0; i < n; i++) {
			int x = scan.nextInt();
			for (int j = 0; j < x; j++) {
				a[scan.nextInt()-1] = true;
			}
		}
		boolean res = true;
		for(int i = 0; i < m; i++) {
			res&=a[i];
			}
		    System.out.println(res?"YES":"NO");
		}
	}

