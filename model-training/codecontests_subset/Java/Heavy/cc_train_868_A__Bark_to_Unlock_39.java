import java.util.Scanner;

public class Bark {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String srev = s.charAt(1)+s.charAt(0)+"";
		int n = scn.nextInt();
		String[] strs = new String[n];
		boolean found = false;
		for(int i = 0; i < n; i++) {
			strs[i] = scn.next();
			if(strs[i].equals(s) || strs[i].equals(srev)) {
				found = true;
			}
		}
		if(!found) {
			boolean f1 = false, f2 = false;
			for(int i = 0;i < n; i++) {
				if(strs[i].charAt(1) == s.charAt(0)) f1 = true;
				if(strs[i].charAt(0) == s.charAt(1)) f2 = true;
				if(f1 && f2) {
					found = true;
					break;
				}
			}
		}
		if(found) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	
	}

}
