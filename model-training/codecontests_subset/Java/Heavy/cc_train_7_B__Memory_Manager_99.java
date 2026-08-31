import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt(), m = in.nextInt();
		int num = 0;
		int[] pos = new int[10001];
		for (int i = 0; i < t; i++) {
			String operation = in.next();
			if (operation.equals("alloc")) {
				int n, os, f = 0;
				os = in.nextInt();
				if (in.hasNextInt())
					n = in.nextInt();
				else {
					n = os;
					f = 1;
				}
				int flag = -1;
				if (f == 1) {
					for (int j = 1; j <= m; j++) {
						int p = 0;
						for (int k = j; k < j + n && k <= m; k++)
							if (pos[k] == 0)
								p++;
						if (p == n) {
							flag = j;
							break;
						}
					}
				} else {
					for (int j = os; j <= m; j++) {
						int p = 0;
						for (int k = j; k < j + n && k <= m; k++)
							if (pos[k] == 0)
								p++;
						if (p == n) {
							flag = j;
							break;
						}
					}
				}
				if (flag == -1)
					System.out.println("NULL");
				else {
					num++;
					for (int j = flag; j < flag + n; j++)
						pos[j] = num;
					System.out.println(num);
				}
			} else if (operation.equals("erase")) {
				int n = in.nextInt();
				if (n <= 0) {
					System.out.println("ILLEGAL_ERASE_ARGUMENT");
					continue;
				}
				int flag = -1;
				for (int j = 1; j <= m; j++)
					if (pos[j] == n) {
						pos[j] = 0;
						flag = 1;
					}
				if (flag == -1)
					System.out.println("ILLEGAL_ERASE_ARGUMENT");

			} else if (operation.equals("defragment")) {
				int j, z = 1;
				for (j = 1; j <= m; j++)
					if (pos[j] > 0)
						pos[z++] = pos[j];
				for (; z <= m; z++)
					pos[z] = 0;
			}
		}
	}
}
