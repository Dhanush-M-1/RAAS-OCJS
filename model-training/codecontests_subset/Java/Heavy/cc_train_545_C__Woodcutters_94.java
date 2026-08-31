
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class woodTree {

	public static void main(String[] args) throws IOException, NumberFormatException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] c = new int[n];
		int[] h = new int[n];
		for(int i=0; i<n; i++) {
			String[] s = br.readLine().split(" ");
			c[i] = Integer.parseInt(s[0]);
			h[i] = Integer.parseInt(s[1]);
		}
		if(n==0 || n==1 || n==2) {
			System.out.println(n);
			return;
		}
		int cnt=1;
		for(int i=1; i<n-1; i++) {
			if(c[i]-h[i] > c[i-1]) {
				cnt++;
			} else if(c[i]+h[i] < c[i+1]) {
				cnt++;
				c[i] += h[i];
			}
		}
		System.out.println(cnt+1);
	}

}
