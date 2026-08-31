import java.util.Scanner;

public class phoneNum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();;
		String s = scan.next();
		scan.close();
		int x = 0;
		for(int i = 0; i < n; i++) {
			if(s.charAt(i) == '8') {
				x ++;
			}
		}
		int y = n / 11;
		if(y <= x) {
			System.out.println(y);
		}else if(y > x) {
			System.out.println(x);
		}
	}
}