import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;


public class C {
	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	static int[] readIntArray() throws IOException {
		String[] v = br.readLine().split(" ");
		int[] ans = new int[v.length];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = Integer.valueOf(v[i]);
		}

		return ans;
	}

	
	public static void main(String[] args) throws IOException {
		int[] nml = readIntArray();
		int[] w = readIntArray();
		int[] b = readIntArray();
		
		long ans = 0;
		
		for (int i = 1; i < b.length; i++) {
			
			HashSet<Integer> used = new HashSet<Integer>();
			for (int j = i - 1; j >= 0; j--) {
				if (b[j] == b[i]) break;
				used.add(b[j] - 1);
			}
			
			for(Integer u : used) {
				ans+= w[u];
			}
			
		}
		
		System.out.println(ans);
		
	}
}
