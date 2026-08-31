import java.util.Scanner;
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = new Integer(sc.next());
		String s = sc.next();
		for (int jump=1; jump<25; jump++) {
			for (int i=0; i+4*jump<n; i++) {
				if (s.charAt(i)=='*'&&s.charAt(i+jump)=='*'&&s.charAt(i+2*jump)=='*'&&s.charAt(i+3*jump)=='*'&&s.charAt(i+4*jump)=='*') {
					System.out.println("yes");
					return;
				}
			}
		}
		System.out.println("no");
		return;
    }
}
