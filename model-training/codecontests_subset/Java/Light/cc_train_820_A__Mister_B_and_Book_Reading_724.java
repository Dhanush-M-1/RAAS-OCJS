import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Codeforces820A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int c = Integer.parseInt(st.nextToken());
		int v0 = Integer.parseInt(st.nextToken());
		int v1 = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] table = new int[c+1];
		table[0] = 0;
		table[1] = v0;
		for (int i = 2; i <= c; i++) {
			table[i] = table[i-1]-l+Math.min(v1, v0+a*(i-1));
		}
		
		boolean complete = false;
		for (int i = 1; i <= c; i++) {
			if ((table[i] >= c) && (complete == false)) {
				complete = true;
				System.out.println(i);
			}
		}

	}

}
