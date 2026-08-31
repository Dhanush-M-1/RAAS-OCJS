import java.util.*;

public class NewYearTransportation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner stdin = new Scanner(System.in);
		String[] line = stdin.nextLine().split(" ");
	    
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
	    
		int [] weights = new int [n];
	    int [] input = new int [m];
	    
		line = stdin.nextLine().split(" ");
	    
		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(line[i]);
		}
	    
		line = stdin.nextLine().split(" ");
	    
		Set<Integer> visited = new HashSet<>();
		int [] order = new int [n];
		int index = 0;
		
		for (int i = 0; i < m; i++) {
			input[i] = Integer.parseInt(line[i]);
			if (visited.contains(input[i])) {
				continue;
			}
			visited.add(input[i]);
			order[index] = input[i];
			index++;
		}
		int ans = 0;
		
		for (int i = 0; i < m; i++) {
			int wt = 0;
			int j = 0;
			for (j = 0; ;j++) {
				
				if (order[j] == input[i])
					break;
				wt += weights[order[j]-1];
			}
			
			int temp = order[j];
			for (int k = j; k > 0; k--) {
				order[k] = order[k-1];
			}
			order [0] = temp;
			ans+=wt;
		}
		
		System.out.println(ans);
	}

}
