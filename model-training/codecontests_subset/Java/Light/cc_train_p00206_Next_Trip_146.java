import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();

		while (true) {
			boolean flag = false;
			int border = Integer.parseInt(scan.next());
			if (border == 0) {
				break;
			}
			String ret = "NA";
			int sum = 0;
			for (int i = 0; i < 12; i++) {
				int m = Integer.parseInt(scan.next());
				int n = Integer.parseInt(scan.next());
				int sub = m - n;
				sum += sub;
				if (sum >= border && flag == false) {
					ret = String.valueOf(i + 1);
					flag = true;
				}
			}

			arr.add(ret);
		}
		arr.stream().forEach(System.out::println);
	}

}