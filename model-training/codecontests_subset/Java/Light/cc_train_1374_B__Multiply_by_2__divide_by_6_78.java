
import java.util.*;

public class b {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		
		int nC = stdin.nextInt();
		
		for (int loop=0; loop<nC; loop++) {

			int n = stdin.nextInt();
			
			int n2 = 0;
			while (n%2 == 0) {
				n2++;
				n /= 2;
			}
			
			int n3 = 0;
			while (n%3 == 0) {
				n3++;
				n /= 3;
			}
			
			if (n2 > n3 || n > 1)
				System.out.println(-1);
			else
				System.out.println(n3-n2+n3);
			
		}
	
	}
}