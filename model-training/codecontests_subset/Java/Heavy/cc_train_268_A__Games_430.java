import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		StringTokenizer token;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		
		String[][] pairs = new String[n][2];
		
		for (int i = 0; i < n; i++) {
			token = new StringTokenizer(in.readLine());
			pairs[i][0] = token.nextToken();
			pairs[i][1] = token.nextToken();
		}
		
		int counter = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (pairs[i][0].equals(pairs[j][1]))
					counter++;
		
		System.out.println(counter);
	}
}
