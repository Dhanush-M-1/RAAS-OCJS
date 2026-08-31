import java.util.*;

public class Testy {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		int n = in.nextInt();
		System.out.println(a + " " + b);
		for(int i=0;i<n;i++){
			String c = in.next();
			if(a.equals(c)) a = in.next();
			else b = in.next();
			System.out.println(a + " " + b);
		}
	}
}
