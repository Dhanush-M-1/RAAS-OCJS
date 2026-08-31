import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		System.out.println(Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i - 1).sum());;
	}
}
