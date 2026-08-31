import java.util.Scanner;

public class A820MisterB {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int init = in.nextInt();
		int max = in.nextInt();
		int ac = in.nextInt();
		int last = in.nextInt();
		
		int cur = init;
		int ans = 1;
		
		while (cur < n) {
			init += ac;
			if (init > max) {
				init = max;
			}
			n += last;
			cur += init;
			ans++;
		}
		
		System.out.println(ans);
		
	}
	
}
