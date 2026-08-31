import java.util.*;
import static java.lang.System.*;
import java.math.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] eat = new int[n];
		for(int i = 0; i < n; i++) {
			eat[i] = sc.nextInt();
		}
		int[] point = new int[n];
		for(int i = 0; i < n; i++) {
			point[i] = sc.nextInt();
		}
		int[] adp = new int[n-1];
		for(int i = 0; i < n-1; i++) {
			adp[i] = sc.nextInt();
		}
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int eating = eat[i] - 1;
			sum += point[eating];
			if(i < n-1) {
				if((eat[i] + 1) == eat[i+1]) {
					sum += adp[eating];
				}
			}
		}
		out.println(sum);
	}
}