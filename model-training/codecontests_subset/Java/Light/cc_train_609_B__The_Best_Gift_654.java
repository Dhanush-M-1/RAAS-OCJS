import java.util.HashMap;
import java.util.Scanner;

public class possibility_to_pair_2_books {
	
	public static int possibility_pair_2_books(int[] a, int n, int m) {
		
		// Count number of book for each genre
		HashMap<Integer, Integer> dict = new HashMap();
		for (int i=0; i < n; i++) {
			if (dict.get(a[i]) == null) {
				dict.put(a[i],1);
			}
			else {
				dict.put(a[i], dict.get(a[i]) + 1);
			}
		}
				
		// Count possibility to pair 2 books from different genre
		int sum = 0;
		for (int i=1; i < m; i++) {
			for (int j=i+1; j <= m; j++) {
				sum += dict.get(i) * dict.get(j);
			}
		}
		
		
		return sum;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		int[] a = new int[n];
		
		for (int i=0; i < n; i++) {
			a[i] = scan.nextInt();
		}
		
		System.out.println(possibility_pair_2_books(a, n, m));
		
	}

}
