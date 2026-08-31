import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();
		String s = scan.nextLine();
		int q = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '1') q++; else q--;
		}
		int k = (q == 0) ? 1 : 0;
		System.out.println(k+1);
		System.out.println((k == 0) ? s : s.substring(0, n-1) + " " + s.charAt(n-1));
	}
}