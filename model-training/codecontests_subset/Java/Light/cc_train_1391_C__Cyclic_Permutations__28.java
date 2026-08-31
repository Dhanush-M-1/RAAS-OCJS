import java.io.*;
import java.util.*;

public class CF1391C extends PrintWriter {
	CF1391C() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF1391C o = new CF1391C(); o.main(); o.flush();
	}

	static final int MD = 1000000007;
	void main() {
		int n = sc.nextInt();
		long f = 1;
		for (int i = 1; i <= n; i++)
			f = f * i % MD;
		long g = 1;
		for (int i = 1; i < n; i++)
			g = g * 2 % MD;
		println((f - g + MD) % MD);
	}
}
