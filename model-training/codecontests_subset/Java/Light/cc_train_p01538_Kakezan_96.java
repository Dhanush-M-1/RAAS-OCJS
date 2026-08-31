import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		String m;
		int cnt;
		int max;
		
		n = sc.nextInt();
		while (n-- != 0) {
			m = sc.next();
			cnt = 0;
			while (m.length() != 1) {
				max = 0;
				cnt++;
				for (int i = 1; i < m.length(); i++) {
					int le = Integer.parseInt(m.substring(0, i));
					int ri = Integer.parseInt(m.substring(i, m.length()));
					max = Math.max(max, le * ri);
				}
				m = Integer.toString(max);
			}
			
			System.out.println(cnt);
		}
	}
}