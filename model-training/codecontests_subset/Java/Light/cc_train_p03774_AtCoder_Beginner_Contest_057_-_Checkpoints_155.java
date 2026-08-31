import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a[] = new int[N];
		int b[] = new int[N];
		int c[] = new int[M];
		int d[] = new int[M];
		for (int i = 0; i < N; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
		}
		for (int i= 0;i<M;i++) {
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			int min =Math.abs(c[0]-a[i])+Math.abs(d[0]-b[i]);
			int minPosition = 0;
			for (int j=1;j<M;j++) {
				int temp = Math.abs(c[j]-a[i])+Math.abs(d[j]-b[i]);
				if (temp<min) {
					min = temp;
					minPosition = j;
				}
			}
			System.out.println(minPosition+1);
		}
	}
}
