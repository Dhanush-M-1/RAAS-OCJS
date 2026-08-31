import java.util.*;
import java.io.*;

public class HelloWorld {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		long ans = 1;
		for(int i = 1; i <= n; i++) {
			ans *= i;
			ans %= 1000000007;
		}
		long power = 1;
		for(int i = 1; i < n; i++) {
			power *= 2;
			power %= 1000000007;
		}
		ans = ans + 1000000007 - power;
		ans %= 1000000007;
		writer.println(ans);
		writer.close();
		br.close();
	}
}
