import java.util.*;

public class Solution_1 {
	public static void main(String[] args) {
//		solution start :-)
		Scanner sc = new Scanner(System.in);
		String si = sc.next();
		int n = sc.nextInt();
		boolean flag=false,flag1=false,flag2=false;
		String s[] = new String[n];
		for(int i=0;i<n;i++) {
			s[i] = sc.next();
			if(s[i].equals(si)) {
				flag = true;
			}
		}
		char c1 = si.charAt(0);
		char c2 = si.charAt(1);
		for(int i=0;i<n;i++) {
			if(s[i].charAt(0)==c2) {
				flag1 = true;
				break;
			}
		}
		for(int i=0;i<n;i++) {
			if(s[i].charAt(1)==c1) {
				flag2 = true;
				break;
			}
		}
		if(flag) System.out.println("YES");
		else {
			if(flag1&&flag2) System.out.println("YES");
			else System.out.println("NO");
		}
//		solution end \(^-^)/
//		                |
//		               / \
	}
	
}
