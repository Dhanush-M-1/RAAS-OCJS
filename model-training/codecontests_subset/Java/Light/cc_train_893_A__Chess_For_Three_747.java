import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int f = 1;
		int t = 2;
		int o = 3;
		boolean pos = true;
		for(int i = 0; i < n; i++) {
			//System.out.println(f + " vs " + t);
			int k = sc.nextInt();
			if(k == f) {
				int h = o;
				o = t;
				t = h;
			} else if(k == t) {
				int h = o;
				o = f;
				f = h;
			} else {
				pos = false;
				break;
			}
		}
		System.out.println(pos ? "YES" : "NO");
	}
}
