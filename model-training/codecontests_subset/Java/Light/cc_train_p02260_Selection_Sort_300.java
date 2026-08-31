import java.util.Scanner;

public class Main{
	public static void main(String args[]) {
		int i, j;// loop counter
		int N/* number of element */, num[]/* array of number */, min/* order number of minimum number */;
		int count = 0;// count number of exchanging number
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for (i = 0; i < N; ++i) {
			num[i] = sc.nextInt();
		}
		for (i = 0; i < N; ++i) {
			min = i;
			for (j = i; j < N; ++j) {
				if (num[min] > num[j]) {
					min = j;
				}
			}
			if (min != i) {
				int tmp = num[i];
				num[i] = num[min];
				num[min] = tmp;
				++count;
			}
		}
		for (i = 0; i < N; ++i) {
			System.out.print(num[i]);
			if (i != N - 1) {
				System.out.print(" ");
			}
		}
		System.out.print("\n");
		System.out.println(count);
		sc.close();
	}
}

