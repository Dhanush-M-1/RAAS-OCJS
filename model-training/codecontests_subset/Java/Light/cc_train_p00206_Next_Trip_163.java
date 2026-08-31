import static java.lang.System.*;
import java.util.*;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		while(true) {
			int n = sc.nextInt();
			if (n == 0) break;
			boolean F = false;
			
			int saving = 0;
			int[] a = new int[12], b = new int[12];
			for (int i=0; i<12; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			for (int i=0; i<12; i++) {
				saving += a[i] - b[i];
				if (saving >= n) {
					out.println(i+1);
					F = true;
					break;
				}
			}
			
			if (!F) out.println("NA");
		}
	}
}

