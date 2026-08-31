import java.util.Arrays;
import java.util.Scanner;

public class p1155a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextInt();
		String a = in.next();
		int[] pos = new int[26];
		Arrays.fill(pos, -1);
		for(int i = 0; i < a.length(); i++) {
			for(char b = 'z'; b > a.charAt(i); b--) {
				if(pos[b-'a'] != -1) {
					System.out.println("YES");
					System.out.println(pos[b-'a']+1 + " " + (i+1));
					return;
				}
			}
			pos[a.charAt(i)-'a'] = i;
		}
		System.out.println("NO");
	}
}
