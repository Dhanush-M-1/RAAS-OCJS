import java.util.Scanner;


public class King_of_Thieves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		char f[]=in.next().toCharArray();
		for (int i = 0; i < n; i++) {
			if (f[i] == '*') {
				for (int d = 1; i + d * 4 < n; d++) {
					int d1 = i + d;
					int d2 = i + d * 2;
					int d3 = i + d * 3;
					int d4 = i + d * 4;
					if (f[d1] == '*' && f[d2] == '*' && f[d3] == '*'
							&& f[d4] == '*') {
						System.out.println("yes");
						return;
					}
				}
			}
		}
		System.out.println("no");
	}

}
