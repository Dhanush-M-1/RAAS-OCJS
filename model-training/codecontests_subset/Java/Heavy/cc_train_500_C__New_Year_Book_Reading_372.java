import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class cSolution{
	private static BufferedReader br;
	public static void main(String args[]){
		br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(next());
		int m = Integer.parseInt(next());
		int[] weights = new int[n];
		int[] toLift = new int[n];
		int[] track = new int[n];
		int total = 0;
		for (int i = 0; i < n; i++){
			weights[i] = Integer.parseInt(next());
			track[i] = n;
		}
		int next;
		for (int i = 0; i < m; i++){
			next = Integer.parseInt(next());
			for (int j = 0; j < n; j++){
				if (j == next-1){
					total += toLift[j];
					toLift[j] = 0;
				} else {
					if (track[next-1] > track[j] || track[next-1] == n){
						if (track[j] != n){
							track[j] += 1;
						}
						toLift[j] += weights[next-1];
					}
				}
			}
			track[next-1] = 0;
		}
		System.out.println(total);

	}

	private static StringTokenizer st;

	private static String next(){
		while (st == null || !st.hasMoreElements()){
			String str;
			try{
				str = br.readLine();
			} catch (IOException e){
				return null;
			}
			st = new StringTokenizer(str);
		}
		return st.nextToken();
	}

}