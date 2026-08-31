import java.io.*;
import java.util.*;

public class CF1208A extends PrintWriter {
	CF1208A() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1208A o = new CF1208A(); o.main(); o.flush();
	}

	void main() {
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt() % 3;
			println(n == 0 ? a : n == 1 ? b : a ^ b);
		}
	}
}
