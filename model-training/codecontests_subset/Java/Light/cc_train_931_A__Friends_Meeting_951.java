import java.util.Scanner;

public class Codeforces941A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), bigger = 0, smaller = 0, mid=0;
		if (n > m) {
			bigger = n;
			smaller = m;
		} else {
			bigger = m;
			smaller = n;
		}
		mid = (int) (((long)bigger + smaller) / 2);
		int distsmall=mid-smaller;
		int distbig=bigger-mid;

		int tot=0;
		for (int i = 1; i <= distbig; i++) {
		    tot += i;
		}
		for (int i = 1; i <= distsmall; i++) {
		    tot += i;
		}
		System.out.println(tot);

	}

}
