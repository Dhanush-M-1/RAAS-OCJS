import java.util.*;

public class test {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int l;
		int r;
		int d;
		int t=in.nextInt();
		for (int i = 0; i < t; i++) {
			l = in.nextInt();
			r = in.nextInt();
			d = in.nextInt();
			if (d < l)
				System.out.println(d);
			else
				System.out.println((r/d+1)*d);
		}
	}

}
