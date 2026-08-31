import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solutions {

	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int []a = new int[100];
		Arrays.fill(a, 0);
		for(int i = 0; i < n; i++) {
			int k = sc.nextInt();
			for(int j =0; j < k; j++) {
				int r = sc.nextInt() - 1;
				a[r] = 1;
			}
		}
		int res = 0;
		for(int i = 0; i < m; i++) {
			if(a[i] == 1)
				res++;
		}
		
		if(res == m)
			System.out.println("YES");
		else {
			System.out.println("NO");
		}
		sc.close();
	}

}
