import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i = 0; i < array.length; i++) 
			array[i] = sc.nextInt();
		System.out.println(Arrays.stream(array).sum() -n);
	}
}