import java.util.*;
public class ladder {
 
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t-->0) {
			int a = s.nextInt();
			int b = s.nextInt();
			int c = s.nextInt();
			int ans = 0;
			while(b>0 && c>1) {
				b -= 1;
				c -=2;
				ans++;
			}
			while(a>0 && b>1) {
				b-=2;
				a-=1;
				ans++;
			}
			System.out.println(ans*3);
		}
 
	}
 
}