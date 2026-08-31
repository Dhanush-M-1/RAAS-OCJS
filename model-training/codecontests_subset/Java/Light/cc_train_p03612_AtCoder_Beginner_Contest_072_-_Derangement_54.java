import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(in.nextInt() - 1);
		}
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (list.get(i) == i) {
				if (i == 0) {
					Collections.swap(list, i, i + 1);
					ans++;
				} else {
					if (i + 1 < N && list.get(i + 1) == i + 1) {
						Collections.swap(list, i, i + 1);
					} else {
						Collections.swap(list, i, i - 1);
					}
					ans++;
				}
			}
		}
		System.out.println(ans);
		in.close();
	}
}