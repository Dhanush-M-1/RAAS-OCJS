import java.util.Scanner;

public class B_educ_38 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int res = 0;
		for(int i = 0; i < n; i++) {
			int num = scn.nextInt();
			int a = num - 1;
			int b = 1000000 - num;
			res = Math.max(res, Math.min(a, b));
		}
		System.out.println(res);

	}

}
