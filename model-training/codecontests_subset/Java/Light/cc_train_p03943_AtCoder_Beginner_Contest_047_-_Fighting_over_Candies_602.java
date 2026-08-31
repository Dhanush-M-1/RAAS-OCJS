import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		int[] arr = {a,b,c};
		Arrays.parallelSort(arr);
		if(arr[2]==arr[1]+arr[0]) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
		
	}
}