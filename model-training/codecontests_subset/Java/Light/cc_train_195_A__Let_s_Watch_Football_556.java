// practice with kaiboy
import java.io.*;
import java.util.*;

public class CF195A extends PrintWriter {
	CF195A() { super(System.out, true); }
	Scanner sc = new Scanner(System.in);
	public static void main(String[] $) {
		CF195A o = new CF195A(); o.main(); o.flush();
	}

	void main() {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		println((a * c + b - 1) / b - c);
	}
}
