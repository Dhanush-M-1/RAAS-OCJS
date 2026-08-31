import java.util.Scanner;

public class editable {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int ans = 0, a = scan.nextInt(), b = scan.nextInt();
		int used = 0;
		while(a > 0) {
			a--;
			ans++;
			used++;
			if(used == b) {
				used = 0;
				a++;	
			}
		}
		System.out.println(ans);
	}
}