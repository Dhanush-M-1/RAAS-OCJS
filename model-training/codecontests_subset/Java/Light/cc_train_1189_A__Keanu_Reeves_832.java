import java.io.*;
import java.util.*;

public class CF1189A extends PrintWriter {
	CF1189A() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1189A o = new CF1189A(); o.main(); o.flush();
	}

	void main() {
		int n = sc.nextInt();
		byte[] cc = sc.next().getBytes();
		int d = 0;
		for (int i = 0; i < n; i++)
			if (cc[i] == '0')
				d++;
			else
				d--;
		if (d != 0) {
			println(1);
			println(new String(cc));
		} else {
			println(2);
			println(new String(cc, 0, 1) + " " + new String(cc, 1, n - 1));
		}
	}
}
