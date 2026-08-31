import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CodeForce {
	public static void main(String[] args) {
		Map<String, Integer> data = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += scan.nextInt();
		}
		if (sum % 5 == 0 && sum > 0)
			System.out.println(sum / 5);
		else
			System.out.println(-1);
	}
}