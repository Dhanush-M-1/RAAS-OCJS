import java.util.*;
public class Problem30 {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		double k = ((double)n * (double)y)/100.0;
		int res = (int)Math.ceil(k) - x;
		res = (res >= 0) ? res: 0;
		System.out.println(res);
	}
}