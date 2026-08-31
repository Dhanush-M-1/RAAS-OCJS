import java.util.*;
public class New_year_2015_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] w = new int[n];
		for (int i=0; i<n; i++){
			w[i] = in.nextInt();
		}
		int[] order = new int[m];
		for (int i=0; i<m; i++){
			order[i] = in.nextInt()-1;
		}
		in.close();
		
		boolean[] visited = new boolean[n];
		int[] stack = new int[n];
		int[] index = new int[n];
		int counter = 0;
		
		for (int i=0; i<m; i++){
			if (!visited[order[i]]){
				stack[counter] = order[i];
				visited[order[i]] = true;
				index[order[i]] = counter;
				counter++;
			}
		}
		
		long res = 0;
		for (int i=0; i<m; i++){
			for (int j=0; j<index[order[i]]; j++){
				res += w[stack[j]];
			}
			
			// shift the stack
			int temp = stack[index[order[i]]];
			int temp2 = 0;
			int val = index[order[i]];
			for (int j=0; j<=val; j++){
				temp2 = temp;
				temp = stack[j];		
				stack[j] = temp2;
				index[stack[j]]++;
				if (stack[j]==order[i]) index[stack[j]] = 0;
			}
		}
		System.out.println(res);
		
	}

}
