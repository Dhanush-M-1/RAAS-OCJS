import java.util.*;
import java.io.*;

public class MinimumInteger {

	public static void main(String[] args) throws IOException {
		Scanner scn = new Scanner(System.in);
		int q = scn.nextInt();
		while (q > 0) {
			int l, r, d;
			l = scn.nextInt();
			r = scn.nextInt();
			d = scn.nextInt();
			int ans;
			if ((l - 1) / d > 0) {
				ans=d;
			} else if (r % d == 0) {
				ans = ((r / d) + 1) * d;
			} else {
				ans = d * ((r - 1) / d + 1);
			}
			System.out.println(ans);
			q--;
		}
	}

}
