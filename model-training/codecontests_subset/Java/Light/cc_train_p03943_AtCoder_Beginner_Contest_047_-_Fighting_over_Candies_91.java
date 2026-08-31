import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] ary = new int[3];
		ary[0] = sc.nextInt();
		ary[1] = sc.nextInt();
		ary[2] = sc.nextInt();
		Arrays.sort(ary);
		if (ary[0] + ary[1] == ary[2]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
}