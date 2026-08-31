import java.util.*;

public class a {

	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int t = in.nextInt();
		
		while(t-- > 0) {
			
			int n = in.nextInt();
			
			List<Integer> tab = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				tab.add(in.nextInt());
			}
			
			Collections.sort(tab);
			
			if(tab.get(0) + tab.get(1) <= tab.get(n-1)) {
				
				System.out.print(1 + " " + 2 + " ");
				System.out.println(n);
				
			}
			
			else {
				System.out.println(-1);
			}
		}
	}
}