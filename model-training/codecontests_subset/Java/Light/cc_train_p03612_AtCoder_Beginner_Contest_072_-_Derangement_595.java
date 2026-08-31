import java.util.*;

public class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
		    arr[i] = sc.nextInt();
		}
		int idx = 1;
		int count = 0;
		while (idx <= n) {
		    if (arr[idx] == idx) {
		        if (idx < n && arr[idx + 1] == idx + 1) {
		            idx++;
		        }
		        count++;
		    }
		    idx++;
		}
        System.out.println(count);
   }
}


