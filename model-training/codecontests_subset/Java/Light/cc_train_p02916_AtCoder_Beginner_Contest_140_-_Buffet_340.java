import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		int b = 0;
		int[] c = new int[n+1];

		for(int i=1;i<=n;i++) 	a[i] = sc.nextInt();
		for(int i=1; i<=n; i++) 	b+= sc.nextInt();
		for(int i=1; i<=n-1; i++) c[i] = sc.nextInt();

		for(int i=1; i<n; i++) {
			if(a[i+1]-a[i] ==1) {
				b+=c[a[i]];
			}
		}

		System.out.println(b);
	}
}
