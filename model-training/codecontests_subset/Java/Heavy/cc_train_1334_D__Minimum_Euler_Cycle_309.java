import java.io.*;
import java.util.*;

public class CF1334D extends PrintWriter {
	CF1334D() { super(System.out); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1334D o = new CF1334D(); o.main(); o.flush();
	}

	void main() {
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long l = sc.nextLong();
			long r = sc.nextLong();
			long h = 1;
			int i = 1;
			while (i < n && h + (n - i) * 2 <= l) {
				h += (n - i) * 2;
				i++;
			}
			while (i < n && h <= r) {
				for (int j = i + 1; j <= n; j++) {
					if (h >= l && h <= r)
						print(i + " ");
					h++;
					if (h >= l && h <= r)
						print(j + " ");
					h++;
				}
				i++;
			}
			if (h <= r)
				print(1);
			println();
		}
	}
}
