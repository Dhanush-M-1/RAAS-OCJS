import java.util.*;

public class edu33A {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int spec = 3 - scan.nextInt();
		if (spec == 0) {
			System.out.println("NO");
			return;
		}
		for (int i = 0; i < n - 1; i++) {
			int a = scan.nextInt();
			if (a == spec) {
				System.out.println("NO");
				return;
			}
			spec = sw(spec,a);
		}
		System.out.println("YES");
	}
	
	public static int sw(int spec, int win) {
		if (spec==1) {
			return (win==2) ? 3 : 2;
		} else if (spec ==2) {
			return (win==1) ? 3 : 1;
		} else return (win==1) ? 2 : 1;
	}

}
