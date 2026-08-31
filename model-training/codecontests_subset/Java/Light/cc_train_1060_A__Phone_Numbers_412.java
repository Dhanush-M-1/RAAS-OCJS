import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] nums = br.readLine().toCharArray();
		int c8 = 0;
		for (int i = 0; i < N; i++) {
			if (nums[i] == '8') c8++;
		}
		int ans = Math.min(N / 11, c8);
		System.out.println(ans);
	}

}
