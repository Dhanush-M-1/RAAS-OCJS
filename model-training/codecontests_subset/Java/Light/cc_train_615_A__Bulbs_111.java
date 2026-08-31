import java.util.*;

public class Bulbs {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		ArrayList<Integer> bulbs = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			int x = scan.nextInt();
			for(int j = 0; j < x; j++) {
				bulbs.add(scan.nextInt());
			}
		}
		boolean yes = true;
		for(int i = 0; i < m; i++) if(bulbs.indexOf(i+1)==-1) {
			yes = false;
			break;
		}
		System.out.println(yes ? "YES" : "NO");
	}
}
