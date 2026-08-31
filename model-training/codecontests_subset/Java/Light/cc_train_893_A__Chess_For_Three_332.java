import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] st = new int[4];
		st[1] = st[2] = 1;
		while(t-- > 0) {
			int w = sc.nextInt();
			if(st[w] == 0) {
				System.out.println("NO");
				return;
			}
			for(int i = 1 ; i <= 3 ; i++)
				if(i != w)
					st[i] ^= 1;
		}
		System.out.println("YES");
		sc.close();
	}
}
