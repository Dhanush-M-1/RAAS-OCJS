import java.util.*;
class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] A = castToInt(sc.nextLine().split(" "));
		int[] B = castToInt(sc.nextLine().split(" "));
		int[] C = castToInt(sc.nextLine().split(" "));
		int total = 0;
		int pre = 999;
		for (int a : A) {
			total += B[a-1];
			if (a - pre == 1) {
				total += C[a-2];
			}
        	pre = a;
		}
      System.out.println(total);
	}
	static int[] castToInt(String[] s) {
		int[] ret = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			ret[i] = Integer.parseInt(s[i]);
		}
		return ret;
	}
}