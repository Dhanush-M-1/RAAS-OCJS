import java.util.*;
import java.io.*;

public class TaskA {
	public static void main(String[] args) throws IOException {
		Scanner f = new Scanner(System.in);
		int c = f.nextInt(), v0 = f.nextInt(), v1 = f.nextInt(), a = f.nextInt(), l = f.nextInt();
		c -= v0;
		if (c <= 0) {
			System.out.println(1); return;
		}
		int i = 2;
		while (c > 0) {
			c -= Math.min(v0 + (i-1) * a, v1) - l;
			i++;
		}
		System.out.println(i - 1);
	}
}
