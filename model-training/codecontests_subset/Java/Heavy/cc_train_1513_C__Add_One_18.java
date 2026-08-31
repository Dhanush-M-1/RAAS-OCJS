import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Practice {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw=new PrintWriter(System.out);
		
		long[] arr = new long[200025];
		for (int i = 0; i < 10; i++)
			arr[i] = 1;
		
		int t = Integer.parseInt(br.readLine());
		
		long mod = (long) Math.pow(10, 9) + 7;
		
		for (int i = 10; i < 200025; i++)
			arr[i] = (arr[i - 10] + arr[i - 9]) % mod;
		
		while (t-- > 0) {
			String[] s1 = br.readLine().split(" ");
			long n = Long.valueOf(s1[0]);
			int k = Integer.valueOf(s1[1]);
			long ans = 0;
			while (n > 0) {
				ans = (ans+arr[(k + (int)(n % 10))])%mod;
				n = n / 10;
			}
		//	System.out.println("888888888888");
			pw.println(ans%mod);
		}
		pw.close();
	}
}
