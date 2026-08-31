import java.util.*;

public class sports {
	static int n, unif[][], count;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		unif = new int[n][2];
		for (int i = 0; i < n; i++) {
			unif[i][0] = in.nextInt();
			unif[i][1] = in.nextInt();
		}
		
		count = 0;
		for (int i = 0; i < n; i++) { // host
			for (int j = 0; j < n; j++) { // guest
				if (i == j) continue;
				if (unif[i][0] == unif[j][1]) count++;
			}
		}
		System.out.println(count);
	}
}
