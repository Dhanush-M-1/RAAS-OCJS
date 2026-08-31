import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int l = s.length();
		int p_l = l-7;
		String set_s = "";
		
		if (l==7) {
			if (s.equals("keyence")) {
				System.out.println("YES");
				return;
			}
			
		} else {
			for (int j=0; j<=7; j++) {
				set_s = s.substring(0,j) + s.substring(j+p_l,l);
              
				if (set_s.equals("keyence")) {
					System.out.println("YES");
					return;
				}
			}
		}

		System.out.println("NO");
		return;
		
	}
}