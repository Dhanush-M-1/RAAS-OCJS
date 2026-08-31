import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1, 1, 2, 1, 2, 1, 5, 2, 2, 1, 5, 1, 2, 1, 14, 1, 5, 1, 5, 2, 2, 1, 15, 2,
				2, 5, 4, 1, 4, 1, 51);
		Scanner sc = new Scanner(System.in);
		System.out.println(list.get(sc.nextInt() - 1));
	}
}
