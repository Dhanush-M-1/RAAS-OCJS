import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] matches = new boolean[n];
		for (int i = 0; i < n; i++) {
		    matches[i] = (sc.nextInt() == (i + 1));
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
		    if (matches[i]) {
		        count++;
		        i++;
		    }
		}
		System.out.println(count);
   }
}

