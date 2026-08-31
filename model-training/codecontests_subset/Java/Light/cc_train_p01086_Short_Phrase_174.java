import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = Integer.parseInt(sc.next());
			if (n == 0) break;
			String[] w = new String[n];
			for (int i  = 0; i < n; i++) {
				w[i] = sc.next();
			}
			for (int i = 0; i < n; i++) {
				boolean a = false;
				boolean b = false;
				boolean c = false;
				boolean d = false;
				boolean e = false;
				int index = i;
				int len = 0;
				while (index < n && len < 5) {
					len += w[index++].length();
				}
				if (len == 5)
					a = true;
				else
					continue;
				len = 0;
				while (index < n &&len < 7) {
					len += w[index++].length();
				}
				if (len == 7)
					b = true;
				else
					continue;
				len = 0;
				while (index < n && len < 5) {
					len += w[index++].length();
				}
				if (len == 5)
					c = true;
				else
					continue;
				len = 0;
				while (index < n && len < 7) {
					len += w[index++].length();
				}
				if (len == 7)
					d = true;
				else
					continue;
				len = 0;
				while (index < n && len < 7) {
					len += w[index++].length();
				}
				if (len == 7)
					e = true;
				else
					continue;
				if (a && b && c && d && e) {
					System.out.println(i + 1);
					break;
				}
			}
		}
	}
}
