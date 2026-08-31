import java.util.*;

public class ndaidemf {
	public static void main(String[] args) {
		new ndaidemf();
	}
	
	public ndaidemf() {
		Scanner s = new Scanner(System.in);
		System.err.println("");

		int n = s.nextInt();
		int max = 202;
		int[] a = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			a[i] = s.nextInt()/100;
			sum += a[i];
		}
		
		if(sum%2 == 1) {
			System.out.println("NO");
			return;
		}
		
		boolean[] reach = new boolean[max];
		reach[0] = true;
		for(int i = 0; i < n; i++) {
			for(int j = max-1; j >= 0; j--) {
				if(reach[j] && j+a[i] < max) reach[j+a[i]] = true;
			}
		}
		
		if(reach[sum/2]) System.out.println("YES");
		else System.out.println("NO");
	}
	
}
