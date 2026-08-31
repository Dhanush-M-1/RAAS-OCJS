import java.util.*;
import java.io.*;

public class A {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int sum = (m*(m+1))/2;
		boolean[] set = new boolean[m+1];

		for(int i = 0; i < n; i++) {
			int cnt = in.nextInt();
			for(int j = 0; j < cnt ; j++) {
				int tmp = in.nextInt();
				if(set[tmp]) continue;

				set[tmp] = true;
				sum -= tmp;
			}
		}

		System.out.println(sum == 0 ? "YES": "NO");
 	}
}