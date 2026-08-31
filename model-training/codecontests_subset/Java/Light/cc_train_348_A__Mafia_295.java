import java.util.*;

public class Mafia {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = in.nextInt();
		int ans = 0;
		double k = 0;
		
		for(int i = 0; i < n; i++) {
			int v = in.nextInt();
			ans = Math.max(ans, v);
			k += v;
		}
		System.out.println((int)Math.max(ans, ((k+n-2)/(n-1))));
	}
}