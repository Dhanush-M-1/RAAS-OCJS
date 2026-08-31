import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] a = new int[3];
		for (int i = 0; i < 3; i++) a[i] = sc.nextInt();
		Arrays.parallelSort(a);
		System.out.println(a[0]+a[1]==a[2]?"Yes":"No");
		sc.close();
	}
}