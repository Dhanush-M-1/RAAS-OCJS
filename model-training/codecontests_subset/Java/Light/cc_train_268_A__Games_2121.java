/**
 *
 * @author λkt345
 */

import java.util.*;

public class games {

	public static final int MAXN = 102;

	public static void main(String... args) {
		int total = 0;
		int[] colorsVisitor = new int [MAXN];
		int[] colorsHost = new int [MAXN];

		Scanner sin = new Scanner(System.in);
		int N = sin.nextInt();
		for(int i = 0; i < N; ++i) {
			colorsHost[sin.nextInt()]++;
			colorsVisitor[sin.nextInt()]++;
		}
		
		for(int i = 1; i <= 100; ++i) {
			total += colorsHost[i] * colorsVisitor[i];
		}
		System.out.println(total);
	}
}
