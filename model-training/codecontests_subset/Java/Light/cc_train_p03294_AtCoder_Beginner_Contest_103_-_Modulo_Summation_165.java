import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		ArrayList<Long> list =  new ArrayList<Long>();
		for(int i = 0; i < num; i++) {
			list.add(scanner.nextLong());
		}
		long res = 0;

		for(long j : list) {
			res += j - 1;
		}

		System.out.println(res);
	}
}