import java.util.Scanner;
public class Main { //C

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] a = new int[N];
		int max = 0;

		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
			max += a[i];
		}

		System.out.println(max - N);

	}

}
