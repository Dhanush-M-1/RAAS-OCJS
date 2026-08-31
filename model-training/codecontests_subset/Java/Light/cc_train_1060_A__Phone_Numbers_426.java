import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		if (n < 11 || !s.contains("8")) {
			System.out.println(0);
		} else {
			int count=0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '8') {
					n-=11;
					count++;
					if(n==0||n<11) {
						break;
					}
				}
			}
			System.out.println(count);
		}
	}

}
