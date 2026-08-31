import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] sa = br.readLine().split(" ");
		int n = Integer.parseInt(sa[0]);
		int k = Integer.parseInt(sa[1]);
		int q = Integer.parseInt(sa[2]);
		sa = br.readLine().split(" ");
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(sa[i]);
		}
		br.close();

		int ans = Integer.MAX_VALUE;
		for (int x = 0; x < n; x++) {
			int min = a[x];
			List<Integer> list = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				if (a[i] >= min) {
					list.add(a[i]);
				} else {
					if (list.size() - k + 1 > 0) {
						Collections.sort(list);
						for (int j = 0; j < list.size() - k + 1; j++) {
							list2.add(list.get(j));
						}
					}
					list.clear();
				}
			}
			if (list.size() - k + 1 > 0) {
				Collections.sort(list);
				for (int j = 0; j < list.size() - k + 1; j++) {
					list2.add(list.get(j));
				}
			}
			if (list2.size() >= q) {
				Collections.sort(list2);
				if (list2.get(0) == min) {
					int val = list2.get(q - 1) - min;
					ans = Math.min(ans, val);
				}
			}
		}
		System.out.println(ans);
	}
}
