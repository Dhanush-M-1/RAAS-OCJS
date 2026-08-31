// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF931A extends PrintWriter {
	CF931A() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF931A o = new CF931A(); o.main(); o.flush();
	}

	void main() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		if (a > b) {
			int tmp = a; a = b; b = tmp;
		}
		int c = (a + b) / 2;
		println((c - a) * (c - a + 1) / 2 + (b - c) * (b - c + 1) / 2);
	}
}
