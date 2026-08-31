import java.util.*;

public class A615 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		
		Set<Integer> set = new HashSet();
		for (int i = 0; i < n; i++) {
			int k = scan.nextInt();
			
			for (int j = 0; j < k; j++) {
				set.add(scan.nextInt());
			}
		}
		System.out.println(set.size() == m ? "YES": "NO");
	}

}
