import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
//		int[] array = new int[N];
		int result = 0;
		for (int i = 0; i < N; i++) {
			int value = sc.nextInt();
			if (i + 1 == value) {
//				array[i] = sc.nextInt();
//				array[i++] = value;
				if (i + 1 != N) {
					sc.nextInt();
					i++;
				}
				result++;
			}
		}
		sc.close();
		System.out.println(result);
	}
}