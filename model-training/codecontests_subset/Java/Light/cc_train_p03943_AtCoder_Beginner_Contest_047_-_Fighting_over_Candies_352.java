import java.util.*;
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int a = Integer.parseInt(sc.next());
		int b = Integer.parseInt(sc.next());
		int c = Integer.parseInt(sc.next());
		
		if((a+b == c) || (a+c == b) || (b+c == a)) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}