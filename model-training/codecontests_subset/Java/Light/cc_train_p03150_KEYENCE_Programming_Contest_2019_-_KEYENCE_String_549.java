import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for (int i=0;i<=7;i++) {
			String t = s.substring(0,i);
			t +=s.substring(s.length()-7+i);
			if ("keyence".equals(t)==true) {
				System.out.println("YES");
				return ;
			}
		}
		System.out.println("NO");
	}
}