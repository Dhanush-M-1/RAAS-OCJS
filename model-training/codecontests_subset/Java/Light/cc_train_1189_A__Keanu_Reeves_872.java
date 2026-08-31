import java.util.*;

public class CPThree {
	
	private static boolean checking(String s) {
		int zeros = 0;
		int ones = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.substring(i, i + 1).equals("0")) {
				zeros++;
			} else {
				ones++;
			}
		}
		if(zeros != ones) {
			return true;
		} else {
			return false;
		}
	}
	
	private static String cutting(String s, int n) {
		String ans = "";
		ans = s.substring(0, n - 1) + " " + s.substring(n-1, n);
		return ans;
	}
	
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		sc.close();
		boolean good = checking(str);
		if(good) {
			System.out.println(1);
			System.out.println(str);
		} else {
			System.out.println(2);
			System.out.println(cutting(str, n));
		}
	}
}

