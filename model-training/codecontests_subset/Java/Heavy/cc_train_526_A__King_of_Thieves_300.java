import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Zepto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String str = in.nextLine();
		boolean found = false;
		boolean ar[] = new boolean[n];
		for (int i = 0; i < n; i++)if (str.charAt(i) == '*')ar[i] = true;
		for (int s = 0; s < n; s++) {
			if (!ar[s])continue;
			for (int d = 1; s + d * 4 < n; d++) {
				boolean ok = true;
				for (int j = 1; j<=4; j++) {
					if (!ar[s + d*j]) {
						ok = false;
						break;
					}
				}
				if (ok)found = true;
			}
		}
		System.out.println(found ? "yes" : "no");
	}

}
