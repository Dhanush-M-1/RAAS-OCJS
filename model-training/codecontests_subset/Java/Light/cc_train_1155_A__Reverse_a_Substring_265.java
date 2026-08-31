import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		String S = sc.next();
		char[] sArr = S.toCharArray();
		char max = sArr[0];
		int maxI = 0;
		
		for (int i = 1; i < len; ++i) {
			if (max < sArr[i]) {
				max = sArr[i];
				maxI = i;
			} else if (max > sArr[i]) {
				System.out.println("YES");
				System.out.println((maxI + 1) + " " + (i + 1));
				
				return;
			}
		}
		
		System.out.println("NO");
		
		sc.close();
	}
}
