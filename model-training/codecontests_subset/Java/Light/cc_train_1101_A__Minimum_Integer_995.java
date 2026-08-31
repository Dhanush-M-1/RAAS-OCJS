import java.util.*;

public class MinimumInteger {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = Integer.parseInt(scan.nextLine());
		for (int rep = 0; rep < q; rep++) {
			StringTokenizer str = new StringTokenizer(scan.nextLine());
			long l = Long.parseLong(str.nextToken());
			long r = Long.parseLong(str.nextToken());
			long d = Long.parseLong(str.nextToken());
			
			if(d < l || d > r) {
				System.out.println(d);
			}
			else {
				System.out.println((r/d + 1) * d);
			}
		}
	}
}
