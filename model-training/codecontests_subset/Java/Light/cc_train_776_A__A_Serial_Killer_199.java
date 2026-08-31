import java.util.*;

public class Temp {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String temp = sc.nextLine();
		String [] st = temp.split(" ");
		String p1 = st[0];
		String p2 = st[1];

		int n = Integer.parseInt(sc.nextLine());
		int i = 0;
		while(i <= n) {
			System.out.println(p1+" "+p2);
			if(i < n) {
				st = sc.nextLine().split(" ");
				if (st[0].equals(p1)) {
					p1 = st[1];
				}
				else if(st[0].equals(p2)){
					p2 = st[1];
				}
			}
			i++;
		}
	}
}