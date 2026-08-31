import java.util.*;
public class SerialKiller {
    public static void main(String args[]) {
		String killer1, killer2, killer3;
		int n;
		Scanner scan = new Scanner(System.in);
		killer1 = scan.next();
		killer2 = scan.next();
		n = scan.nextInt();
		System.out.println(killer1 + " " + killer2);
		for(int i = 0; i < n; i++) {
			killer3 = scan.next();
			if(killer3.equals(killer1))
				killer1 = scan.next();
			else
				killer2 = scan.next();
			System.out.println(killer1 + " " + killer2);
		}
	}
}