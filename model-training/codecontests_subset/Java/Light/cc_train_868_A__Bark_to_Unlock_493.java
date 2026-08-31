import java.util.Scanner;

public class BarkToUnlock {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String pw = sc.next();
		int n = sc.nextInt();
		String[] words = new String[n];
		for(int i = 0; i < n; i++) {
			words[i] = sc.next();
		}
		
		boolean left = false;
		boolean right = false;
		for(int i = 0; i < n; i++) {
			if(words[i].charAt(1) == pw.charAt(0))
				left = true;
			if(words[i].charAt(0) == pw.charAt(1))
				right = true;
			if(words[i].equals(pw) || (left && right)) {
				System.out.println("YES");
				return;
			}
		}
		
		System.out.println("NO");
		
	}
	
}