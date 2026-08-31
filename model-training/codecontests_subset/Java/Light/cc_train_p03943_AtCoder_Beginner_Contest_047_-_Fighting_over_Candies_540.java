import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] values = {sc.nextInt(),sc.nextInt(),sc.nextInt()};
		Arrays.sort(values);
		if(values[0]+values[1] == values[2]) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
}