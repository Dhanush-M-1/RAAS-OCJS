import java.util.*;
import java.io.*;
public class a {
	public static void main(String[] arg) {
		new a();
	}
	public a() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int ret = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int v = in.nextInt();
			if(k%v == 0) ret = Math.min(ret, k/v);
		}
		System.out.println(ret);
	}
}