//package cf.gym;

import java.util.Scanner;

public class A560 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		str = str.substring(str.length() - x);
		int count = 0;

		for (int i = 0, len = str.length(); i < len; i++) {
//			System.out.print(str.charAt(i));
			if (str.charAt(i) == '1' && i != len - y - 1) {
				count++;
			}else if(str.charAt(i) == '0' && i == len - y - 1) {
				count++;
			}
		}
		System.out.print(count);
	}
}
