import java.util.*;
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int a, b, c;
			int total = 0;
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			while(c >= 2 && b >= 1) {
				c-= 2;
				b--;
				total += 3;
			}
			
			while(b >= 2 && a >= 1) {
				b -= 2;
				a--;
				total += 3;
			}
			System.out.println(total);
		}
	}
}