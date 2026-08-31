import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		List<Integer> list = new ArrayList<>();
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(scan.nextInt());
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) % 2 == 0) {
				list1.add(list.get(i));
			} else {
				list2.add(list.get(i));
			}
		}
		Collections.sort(list1);
		Collections.sort(list2);
		// for (int i = 0; i < list1.size(); i++) {
		// System.out.println(list1.get(i));
		// }
		if (Math.abs(list1.size() - list2.size()) <= 1) {
			System.out.println("0");
		}
		if (list1.size() - list2.size() >= 2) {
			for (int i = 0; i < list1.size() - list2.size() - 1; i++) {
				sum = sum + list1.get(i);
			}
			System.out.println(sum);
		}
		if (list2.size() - list1.size() >= 2) {
			for (int i = 0; i < list2.size() - list1.size() - 1; i++) {
				sum = sum + list2.get(i);
			}
			System.out.println(sum);
		}
	}

}