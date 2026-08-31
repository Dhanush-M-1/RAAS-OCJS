import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N-1];
		int sum = 0;

		for(int i = 0; i<N;i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0; i<N;i++) {
			b[i] = sc.nextInt();
		}
		for(int i = 0; i<N-1;i++) {
			c[i] = sc.nextInt();
		}

		for(int i = 0;i<N;i++) {
			sum += b[i];

		}
		for(int i = 0;i<N-1;i++) {
			if(a[i+1] == a[i] + 1) {
				sum += c[a[i]-1];
			}
		}
		System.out.println(sum);

		sc.close();
	}
}


