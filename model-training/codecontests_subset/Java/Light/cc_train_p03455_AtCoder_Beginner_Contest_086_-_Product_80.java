import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String msg = "";
		
		if((a * b) % 2 == 0) {
			msg = "Even";
		}else {
			msg = "Odd";
		}
		System.out.println(msg);
	}
}
