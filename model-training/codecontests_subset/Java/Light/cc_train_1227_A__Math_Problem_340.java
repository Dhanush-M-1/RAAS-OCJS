import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.StreamTokenizer;
import java.io.IOException;

public class Intercepts {

	public static void main(String [] args) throws IOException {
		QuickInput in = new QuickInput();
		int t = in.nextInt();
		for (int u = 0; u < t; u++){
			int n = in.nextInt();
			int Rmin = Integer.MAX_VALUE;
			int Lmax = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++){
				int l = in.nextInt();
				int r = in.nextInt();
				Rmin = Math.min(Rmin, r);
				Lmax = Math.max(Lmax, l);
			}
			
			System.out.println(Math.max(Lmax - Rmin, 0));
		}
	}

}

class QuickInput {
	
	StreamTokenizer stk;
	
	QuickInput(){
		stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	}
	
	int nextInt() throws IOException {
		stk.nextToken();
		return (int) stk.nval;
	}
	
}