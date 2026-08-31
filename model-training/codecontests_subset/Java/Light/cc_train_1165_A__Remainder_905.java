import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		String st = sc.nextLine();
		st = st.substring(st.length() - x);
		int count = 0;

		for (int i = 0, len = st.length(); i < len; i++) {
//			System.out.print(str.charAt(i));
			if (st.charAt(i) == '1' && i != len - y - 1) {
				count++;
			}else if(st.charAt(i) == '0' && i == len - y - 1) {
				count++;
			}
		}
		System.out.print(count);

	}
}
