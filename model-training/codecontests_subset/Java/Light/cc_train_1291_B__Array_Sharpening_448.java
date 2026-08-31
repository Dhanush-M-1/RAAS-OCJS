import java.util.*;
import java.lang.*;
import java.io.*;

public class B {
	public static void main (String[] args) throws java.lang.Exception {
		new Solution();
	}
}
class Solution {
	Scanner scanner;

	public Solution() {
		scanner = new Scanner(System.in);
		scanner.nextLine();
		for (;scanner.hasNext();) {
			run_case();
		}
	}

	private void run_case() {
		scanner.nextLine();
		int[] arr = strToIntArray(scanner.nextLine());

		int sz = arr.length;
		int l = 0, r = 0;

		// check
		for (int i=0; i<sz/2; i++) {
			if (arr[i] >= l && arr[sz-1 - i] >= r) {

			} else {
				System.out.println("No");
				return;
			}
			l ++;
			r ++;
		}

		// odd center
		if (sz % 2 == 1 && arr[sz/2] < l) {
			System.out.println("No");
			return;
		}

		// even
		if (sz % 2 == 0) {
			l --;
			if (arr[sz/2-1] == arr[sz/2] && arr[sz/2-1] == l) {
				System.out.println("No");
				return;
			}
		}

		System.out.println("Yes");
		return;
	}

	private int[] strToIntArray(String str) {
	    String[] vals = str.split("\\s+");
	    int sz = vals.length;
	    int[] res = new int[sz];
	    for (int i=0; i<sz; i++) {
	        res[i] = Integer.parseInt(vals[i]);
	    }
	    return res;
	}

}
