import java.io.*;
import java.util.*;
import java.math.*;

public class B {
	public static void main(String[] args) throws IOException {

		/**/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		/*/
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("src/b.in"))));
		/**/
		
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			ans = Math.max(ans, Math.min(num-1, 1000000-num));
		}
		System.out.println(ans);
	}
}