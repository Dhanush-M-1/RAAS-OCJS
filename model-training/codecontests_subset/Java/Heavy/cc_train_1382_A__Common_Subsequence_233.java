import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		StringBuilder result = new StringBuilder();
		int t = scan.nextInt();
		for(int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			List<Integer> an = new ArrayList<>();
			for(int j = 0; j < n; j++) {
				an.add(scan.nextInt());
			}
			
			int res = 0;
			for(int j = 0; j < m; j++) {
				int nextInt = scan.nextInt();
				if(an.contains(nextInt)) {
					res = nextInt;
				}
			}
			String answer = (res != 0) ? "YES\n1 " + res : "NO";
			result.append(answer + "\n");
		}
		System.out.println(result);
    }	
}