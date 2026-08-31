import java.io.IOException;
import java.util.Scanner;

public class Solutions {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.nextLine();
		String s = sc.nextLine();
		
		int p = s.length() / 11;
		int c8 = 0;
		for(int i =0; i < s.length(); i++) {
			if(s.charAt(i) == '8')
				c8++;
		}
		
		System.out.println(Math.min(c8, p));
		sc.close();
	}
}
