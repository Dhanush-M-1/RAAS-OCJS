import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class d2A {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
		int inputs = Integer.parseInt(file.readLine());
		while(inputs-->0) {
			StringTokenizer st = new StringTokenizer(file.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(file.readLine());
			HashSet<Integer> a = new HashSet<>();
			for(int i = 0; i < n; i++) {
				a.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(file.readLine());
			HashSet<Integer> b = new HashSet<>();
			for(int i = 0; i < m; i++) {
				b.add(Integer.parseInt(st.nextToken()));
			}
			boolean found = false;
			for(int i : b) {
				if(!a.add(i)) {
					found = true;
					System.out.println("YES");
					System.out.println("1 " + i);
					break;
				}
			}
			if(!found)
				System.out.println("NO");
		}

	}

}
