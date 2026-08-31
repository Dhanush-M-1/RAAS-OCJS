import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bulbs {

	
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer s = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		
		boolean[] on = new boolean[m];
		
		for (int i = 0; i < n; i++) {
			s = new StringTokenizer(in.readLine());
			
			int bulbs = Integer.parseInt(s.nextToken());
			
			for (int j = 0; j < bulbs; j++) {
				on[Integer.parseInt(s.nextToken()) - 1] = true;
			}
		}
		
		for (int i = 0; i < m; i++) {
			if(!on[i]){
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
}
