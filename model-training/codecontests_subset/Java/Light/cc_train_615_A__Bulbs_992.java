import java.util.*;
public class Bulbs {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		HashSet<Integer> set = new HashSet<Integer>();
		while(n>0) {
			int num = s.nextInt();
			while(num>0) {
				int bulb = s.nextInt();
				set.add(bulb);
				num--;
			}
			n--;
		}
		if(set.size()==m)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}