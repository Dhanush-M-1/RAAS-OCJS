import java.util.*;
public class Minimum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		for(int e = 0;e < q;e++) {
			int l = scan.nextInt(),r = scan.nextInt(),d = scan.nextInt();
			if(d > r || d < l)
				System.out.println(d);
			else if(l == 1 && d == 1)
				System.out.println(r+1);
			else {
				System.out.println((r/d+1)*d);
			}
		}
		scan.close();

	}

}