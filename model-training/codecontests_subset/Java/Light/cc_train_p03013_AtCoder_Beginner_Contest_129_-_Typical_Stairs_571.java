import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int broken_sum = sc.nextInt();
		int[] array = new int[broken_sum + 1];

		for (int i=0; i<broken_sum; i++) {
			array[i] = sc.nextInt();
		}
		array[broken_sum] = sum + 1;

		long result = (fibonatch(array[0]))% 1000000007;

		for (int i=1; i<broken_sum+1; i++) {
			if (array[i] -  array[i-1] == 1) {
				result = 0;
				break;
			}
			result = (result * fibonatch(array[i] -  array[i-1] - 1) % 1000000007) % 1000000007;
		}


		System.out.println(result % 1000000007);
	}

	static long fibonatch(int num) {
		long tmp1 = 1;
		long tmp2 = 1;


		if (num < 3) {
			return 1;
		} else {
			long n = 0;
			for (long i = 3; i <= num; i ++) {
				n = (tmp1 + tmp2) % 1000000007;
				tmp1 = tmp2 % 1000000007;
				tmp2 = n % 1000000007;
			}
			return n;
		}

	}

}
