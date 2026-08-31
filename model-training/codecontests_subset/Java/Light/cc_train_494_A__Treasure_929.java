import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class C282 {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		String s = r.readLine();
		int[] zawed = new int[s.length()];
		int a = 0;
		boolean aywa = true;
		int pos = -1;
		int lasta = -1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '#') {
				a--;
				zawed[i]++;
				pos = i;
				lasta = a;
			}
			if (s.charAt(i) == '(')
				a++;
			if (s.charAt(i) == ')')
				a--;
			if (a < 0)
				aywa = false;

		}
		
		if (lasta - a < 0){
				aywa = false;
				
		}
		
		else{
			zawed[pos] = zawed[pos] + a;
			int b = lasta-a;
			for(int i = pos+1 ; i < s.length() ; i++){
				if (s.charAt(i) == '(')
					b++;
				if (s.charAt(i) == ')')
					b--;
				if (b < 0)
					aywa = false;
			}
		}
		if (aywa) {
			for (int i = 0; i < zawed.length; i++)
				if (zawed[i] != 0)
					System.out.println(zawed[i]);

		} else {
			System.out.println(-1);
		}

	}

	static BufferedReader r = new BufferedReader(new InputStreamReader(
			System.in));
	static StringTokenizer tkn;
}
