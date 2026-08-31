import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine().trim());
		int odd = 0, even = 0;
		int a[] = new int[n];
		String s[] = br.readLine().trim().split(" ");
		for(int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(s[i]);
			if(a[i]%2 == 0) {
				even++;
			}
			else odd++;
		}
		int ans = 0;
		Arrays.sort(a);
		if(even > odd + 1) {
			int c = even-odd-1;
			int i = 0;
			while(c > 0 && i < n) {
				if(a[i]%2 == 0) {
					ans += a[i];
					c--;
				}
				i++;
			}
		}
		else if(odd > even + 1) {
			int c = odd-even-1;
			int i = 0;
			while(c > 0 && i < n) {
				if(a[i]%2 == 1) {
					ans += a[i];
					c--;
				}
				i++;
			}
		}
		System.out.println(ans);
	}
}
