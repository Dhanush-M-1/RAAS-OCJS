import java.util.*;
import java.math.*;

public class Sample {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int i = 0; i < t; ++i) {
			int n = input.nextInt();
			int[] ls = new int[n];
			for(int j = 0; j < n; ++j) {
				ls[j] = input.nextInt();
			}
			if(ls[0] + ls[1] <= ls[n-1]) {
				System.out.println("1 2 " + Integer.toString(n));
			} else {
				System.out.println(-1);
			}
		}
		input.close();
	}
}