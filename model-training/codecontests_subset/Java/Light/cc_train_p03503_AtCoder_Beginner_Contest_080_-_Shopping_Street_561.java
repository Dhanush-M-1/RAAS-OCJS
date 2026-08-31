import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] Eigyo = new String[n];
		for(int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < 10; j++) {
				sb.append(sc.next());
			}
			Eigyo[i] = sb.toString();
		}
		int[][] p = new int[n][11];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 11; j++) {
				p[i][j] = sc.nextInt();//i番目の店がj個被ると
			}
		}
		Long ans = Long.MIN_VALUE;
		//自分の営業日を全探索2^10
		for(int i = 1; i < 1<<10 ; i++) {
			long rieki = 0;
			for(int j = 0; j < n; j++) {
				int howKaburi = kaburi(Eigyo[j], i);
				rieki += p[j][howKaburi];
			}
			ans = Math.max(rieki, ans);
		}
		System.out.println(ans);
	}

	private static int kaburi(String str, int j) {
		int count = 0;
		char[] s = str.toCharArray();
		String g = Integer.toBinaryString(j);
		for(int i = g.length(); i < 10; i++) {
			g = "0"+g;
		}
		char[] own = g.toCharArray();
		for(int i = 0; i < 10; i++) {
			if(s[i]=='1'&&own[i]=='1') {
				count++;
			}
		}
		return count;
	}
}