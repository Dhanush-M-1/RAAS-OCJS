
import java.util.*;

public class AprilFool2021 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n=s.nextInt();
		String str=s.next();
		
		
		for(int i=1;i<str.length();i++) {
			if(str.charAt(i)<str.charAt(i-1)) {
				System.out.println("YES");
				System.out.println(i+" "+(i+1));
				return;
			}
		}
		System.out.println("NO");
		
	}

}
